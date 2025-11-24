package com.example.quizso.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import com.example.quizso.model.Category;
import com.example.quizso.model.CategoryScore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "quiz_app.db";
    private static final int DB_VERSION = 3;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (username TEXT PRIMARY KEY, password TEXT, created_at TEXT)");
        db.execSQL("CREATE TABLE category_scores (" +
                "username TEXT, " +
                "category TEXT, " +
                "attempts INTEGER DEFAULT 0, " +
                "best_score REAL DEFAULT 0, " +
                "last_score REAL DEFAULT 0, " +
                "questions_answered INTEGER DEFAULT 0, " +
                "last_played_date TEXT, " +
                "PRIMARY KEY (username, category), " +
                "FOREIGN KEY (username) REFERENCES users(username))");
        
        // Usuario admin con contraseña hasheada
        db.execSQL("INSERT INTO users VALUES ('admin', '" + hashPassword("1234") + "', datetime('now'))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            // Migrar de contraseñas en texto plano a hasheadas
            db.execSQL("DROP TABLE IF EXISTS users");
            onCreate(db);
        }
        if (oldVersion < 3) {
            // Agregar tabla de puntuaciones por categoría
            db.execSQL("CREATE TABLE IF NOT EXISTS category_scores (" +
                    "username TEXT, " +
                    "category TEXT, " +
                    "attempts INTEGER DEFAULT 0, " +
                    "best_score REAL DEFAULT 0, " +
                    "last_score REAL DEFAULT 0, " +
                    "questions_answered INTEGER DEFAULT 0, " +
                    "last_played_date TEXT, " +
                    "PRIMARY KEY (username, category), " +
                    "FOREIGN KEY (username) REFERENCES users(username))");
        }
    }

    // Hash de contraseña con SHA-256
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return password; // Fallback (no recomendado en producción)
        }
    }

    // Validar usuario con contraseña hasheada
    public boolean validateUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String hashedPassword = hashPassword(password);
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?",
                new String[]{username, hashedPassword});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    // Registrar nuevo usuario
    public boolean registerUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        
        // Verificar si el usuario ya existe
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=?", new String[]{username});
        if (cursor.getCount() > 0) {
            cursor.close();
            return false; // Usuario ya existe
        }
        cursor.close();

        // Insertar nuevo usuario con contraseña hasheada
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", hashPassword(password));
        values.put("created_at", "datetime('now')");
        
        long result = db.insert("users", null, values);
        return result != -1; // true si se insertó correctamente
    }

    // Verificar si un usuario existe
    public boolean userExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=?", new String[]{username});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    // Guardar o actualizar puntuación de categoría
    public void saveCategoryScore(String username, Category category, double score, int questionsAnswered) {
        SQLiteDatabase db = this.getWritableDatabase();
        String categoryName = category.name();
        
        // Verificar si ya existe un registro
        Cursor cursor = db.rawQuery("SELECT * FROM category_scores WHERE username=? AND category=?",
                new String[]{username, categoryName});
        
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("category", categoryName);
        values.put("last_score", score);
        values.put("questions_answered", questionsAnswered);
        values.put("last_played_date", "datetime('now')");
        
        if (cursor.getCount() > 0) {
            // Actualizar registro existente
            cursor.moveToFirst();
            int attempts = cursor.getInt(cursor.getColumnIndex("attempts")) + 1;
            double bestScore = cursor.getDouble(cursor.getColumnIndex("best_score"));
            
            values.put("attempts", attempts);
            values.put("best_score", Math.max(bestScore, score));
            
            db.update("category_scores", values, "username=? AND category=?",
                    new String[]{username, categoryName});
        } else {
            // Insertar nuevo registro
            values.put("attempts", 1);
            values.put("best_score", score);
            db.insert("category_scores", null, values);
        }
        
        cursor.close();
    }

    // Obtener puntuación de una categoría específica
    public CategoryScore getCategoryScore(String username, Category category) {
        SQLiteDatabase db = this.getReadableDatabase();
        String categoryName = category.name();
        
        Cursor cursor = db.rawQuery("SELECT * FROM category_scores WHERE username=? AND category=?",
                new String[]{username, categoryName});
        
        CategoryScore categoryScore = null;
        if (cursor.moveToFirst()) {
            categoryScore = new CategoryScore(
                    username,
                    category,
                    cursor.getInt(cursor.getColumnIndex("attempts")),
                    cursor.getDouble(cursor.getColumnIndex("best_score")),
                    cursor.getDouble(cursor.getColumnIndex("last_score")),
                    cursor.getInt(cursor.getColumnIndex("questions_answered")),
                    cursor.getString(cursor.getColumnIndex("last_played_date"))
            );
        }
        
        cursor.close();
        return categoryScore;
    }

    // Obtener todas las puntuaciones de un usuario
    public List<CategoryScore> getAllCategoryScores(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<CategoryScore> scores = new ArrayList<>();
        
        Cursor cursor = db.rawQuery("SELECT * FROM category_scores WHERE username=?",
                new String[]{username});
        
        while (cursor.moveToNext()) {
            String categoryName = cursor.getString(cursor.getColumnIndex("category"));
            Category category;
            try {
                category = Category.valueOf(categoryName);
            } catch (IllegalArgumentException e) {
                continue; // Skip invalid categories
            }
            
            CategoryScore score = new CategoryScore(
                    username,
                    category,
                    cursor.getInt(cursor.getColumnIndex("attempts")),
                    cursor.getDouble(cursor.getColumnIndex("best_score")),
                    cursor.getDouble(cursor.getColumnIndex("last_score")),
                    cursor.getInt(cursor.getColumnIndex("questions_answered")),
                    cursor.getString(cursor.getColumnIndex("last_played_date"))
            );
            scores.add(score);
        }
        
        cursor.close();
        return scores;
    }
}