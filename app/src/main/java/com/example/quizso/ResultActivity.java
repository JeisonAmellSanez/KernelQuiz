package com.example.quizso;

import android.content.Intent;
import android.os.Bundle;
//import android.widget.Button;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quizso.model.Category;
import com.example.quizso.model.CategoryScore;
import com.example.quizso.utils.DBHelper;
import com.example.quizso.utils.SessionManager;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    
    private SessionManager sessionManager;
    private DBHelper dbHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        sessionManager = new SessionManager(this);
        dbHelper = new DBHelper(this);

        double score = getIntent().getDoubleExtra("score", 0.0);
        double pct = (score / 5.0) * 100;
        
        String categoryName = getIntent().getStringExtra("category");
        Category category = null;
        if (categoryName != null) {
            try {
                category = Category.valueOf(categoryName);
            } catch (IllegalArgumentException e) {
                // Ignore
            }
        }

        TextView tv = findViewById(R.id.tvResult);
        StringBuilder resultText = new StringBuilder();
        resultText.append("¡Cuestionario completado!\n\n");
        
        if (category != null && category != Category.TODOS) {
            resultText.append("Categoría: ").append(category.getDisplayName()).append(" ")
                    .append(category.getEmoji()).append("\n\n");
        }
        
        resultText.append(String.format("Tu calificación:\n%.2f / 5.00\n(%.1f%%)", score, pct));
        
        // Mostrar estadísticas de la categoría
        if (category != null && category != Category.TODOS) {
            String username = sessionManager.getUsername();
            if (username != null) {
                CategoryScore categoryScore = dbHelper.getCategoryScore(username, category);
                if (categoryScore != null) {
                    resultText.append("\n\n📊 Estadísticas de ").append(category.getDisplayName()).append(":");
                    resultText.append(String.format("\n• Intentos: %d", categoryScore.getAttempts()));
                    resultText.append(String.format("\n• Mejor puntuación: %.2f/5.00", categoryScore.getBestScore()));
                    resultText.append(String.format("\n• Preguntas respondidas: %d", categoryScore.getQuestionsAnswered()));
                }
            }
        }
        
        tv.setText(resultText.toString());

        // Mostrar detalles
        TextView tvDetails = findViewById(R.id.tvDetails);
        ArrayList<String> details = getIntent().getStringArrayListExtra("resultDetails");
        if (details != null && !details.isEmpty()) {
            tvDetails.setText(TextUtils.join("\n", details));
        } else {
            tvDetails.setText("No hay detalles disponibles.");
        }

        findViewById(R.id.btnRetry).setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, CategorySelectionActivity.class);
            startActivity(intent);
            finish();
        });

        findViewById(R.id.btnLogout).setOnClickListener(v -> {
            sessionManager.logout();
            startActivity(new Intent(ResultActivity.this, LoginActivity.class));
            finishAffinity();
        });
    }
}
