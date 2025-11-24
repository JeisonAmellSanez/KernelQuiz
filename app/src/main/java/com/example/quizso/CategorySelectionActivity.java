package com.example.quizso;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.quizso.model.Category;
import com.example.quizso.utils.QuestionBank;
import com.google.android.material.button.MaterialButton;
import android.widget.TextView;

public class CategorySelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_selection);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
        findViewById(R.id.btnViewProgress).setOnClickListener(v -> {
            Intent intent = new Intent(this, CategoryProgressActivity.class);
            startActivity(intent);
        });

        setupCategoryButtons();
    }

    private void setupCategoryButtons() {
        // Todas las categorías
        setupCategoryCard(R.id.cardTodos, Category.TODOS);
        setupCategoryCard(R.id.cardProcesos, Category.PROCESOS);
        setupCategoryCard(R.id.cardMemoria, Category.MEMORIA);
        setupCategoryCard(R.id.cardArchivos, Category.ARCHIVOS);
        setupCategoryCard(R.id.cardPlanificacion, Category.PLANIFICACION);
        setupCategoryCard(R.id.cardConcurrencia, Category.CONCURRENCIA);
        setupCategoryCard(R.id.cardEntradaSalida, Category.ENTRADA_SALIDA);
    }

    private void setupCategoryCard(int cardId, Category category) {
        CardView card = findViewById(cardId);
        card.setOnClickListener(v -> startQuizWithCategory(category));
    }

    private void startQuizWithCategory(Category category) {
        int questionCount = QuestionBank.getQuestionsByCategory(category).size();
        
        if (questionCount < 5) {
            Toast.makeText(this, "Esta categoría necesita más preguntas", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("CATEGORY", category.name());
        startActivity(intent);
    }
}
