package com.example.quizso;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.quizso.model.Category;
import com.example.quizso.model.CategoryScore;
import com.example.quizso.utils.DBHelper;
import com.example.quizso.utils.SessionManager;

import java.util.List;

public class CategoryProgressActivity extends AppCompatActivity {
    
    private SessionManager sessionManager;
    private DBHelper dbHelper;
    private LinearLayout categoryContainer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_progress);
        
        sessionManager = new SessionManager(this);
        dbHelper = new DBHelper(this);
        categoryContainer = findViewById(R.id.categoryProgressContainer);
        
        loadCategoryProgress();
        
        Button btnBack = findViewById(R.id.btnBackToCategories);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(this, CategorySelectionActivity.class));
            finish();
        });
    }
    
    private void loadCategoryProgress() {
        String username = sessionManager.getUsername();
        if (username == null) return;
        
        List<CategoryScore> scores = dbHelper.getAllCategoryScores(username);
        
        // Mostrar todas las categorías (excepto TODOS)
        for (Category category : Category.values()) {
            if (category == Category.TODOS) continue;
            
            // Buscar puntuación de esta categoría
            CategoryScore score = null;
            for (CategoryScore cs : scores) {
                if (cs.getCategory() == category) {
                    score = cs;
                    break;
                }
            }
            
            createCategoryProgressCard(category, score);
        }
    }
    
    private void createCategoryProgressCard(Category category, CategoryScore score) {
        CardView card = new CardView(this);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        cardParams.setMargins(0, 0, 0, 24);
        card.setLayoutParams(cardParams);
        card.setCardElevation(8f);
        card.setRadius(16f);
        try {
            card.setCardBackgroundColor(android.graphics.Color.parseColor(category.getColor()));
        } catch (IllegalArgumentException e) {
            card.setCardBackgroundColor(0xFF6366F1); // color por defecto
        }
        card.setContentPadding(32, 32, 32, 32);
        
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        
        // Título de categoría
        TextView tvTitle = new TextView(this);
        tvTitle.setText(category.getEmoji() + " " + category.getDisplayName());
        tvTitle.setTextSize(20);
        tvTitle.setTextColor(0xFFFFFFFF);
        tvTitle.setTypeface(null, android.graphics.Typeface.BOLD);
        layout.addView(tvTitle);
        
        // Información de progreso
        TextView tvInfo = new TextView(this);
        if (score != null) {
            StringBuilder info = new StringBuilder();
            info.append("\n📊 Intentos: ").append(score.getAttempts());
            info.append("\n🏆 Mejor puntuación: ").append(String.format("%.2f/5.00", score.getBestScore()));
            info.append("\n📝 Última puntuación: ").append(String.format("%.2f/5.00", score.getLastScore()));
            info.append("\n✅ Preguntas respondidas: ").append(score.getQuestionsAnswered());
            
            double percentage = (score.getBestScore() / 5.0) * 100;
            info.append("\n📈 Porcentaje: ").append(String.format("%.1f%%", percentage));
            
            tvInfo.setText(info.toString());
        } else {
            tvInfo.setText("\nAún no has intentado esta categoría.\n¡Comienza ahora!");
        }
        tvInfo.setTextSize(14);
        tvInfo.setTextColor(0xFFFFFFFF);
        layout.addView(tvInfo);
        
        card.addView(layout);
        categoryContainer.addView(card);
    }
}
