package com.example.quizso;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.example.quizso.model.Question;
import com.example.quizso.model.AnswerOption;
import com.example.quizso.model.Category;
import com.example.quizso.utils.QuestionBank;
import com.example.quizso.utils.DBHelper;
import com.example.quizso.utils.SessionManager;
import java.util.*;

public class QuizActivity extends AppCompatActivity {
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int attempts = 0;
    private double totalScore = 0.0;
    private List<AnswerOption> currentShuffledOptions;
    private Vibrator vibrator;
    private Category currentCategory;
    private SessionManager sessionManager;
    private DBHelper dbHelper;

    private TextView tvQuestion, tvScore, tvProgressPercent;
    private ProgressBar progressBar;
    private Button[] optionButtons = new Button[4];
    private Button btnNext;
    private List<String> resultDetails = new ArrayList<>(); // para el reporte final


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Inicializar vibrador
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        sessionManager = new SessionManager(this);
        dbHelper = new DBHelper(this);

        tvQuestion = findViewById(R.id.tvQuestion);
        tvScore = findViewById(R.id.tvScore);
        progressBar = findViewById(R.id.progressBar);
        tvProgressPercent = findViewById(R.id.tvProgressPercent);
        optionButtons[0] = findViewById(R.id.btnOption1);
        optionButtons[1] = findViewById(R.id.btnOption2);
        optionButtons[2] = findViewById(R.id.btnOption3);
        optionButtons[3] = findViewById(R.id.btnOption4);
        btnNext = findViewById(R.id.btnNext);

        if (savedInstanceState != null) {
            currentQuestionIndex = savedInstanceState.getInt("currentQuestionIndex", 0);
            totalScore = savedInstanceState.getDouble("totalScore", 0.0);
        }

        // Obtener categoría seleccionada
        String categoryName = getIntent().getStringExtra("CATEGORY");
        currentCategory = Category.TODOS;
        if (categoryName != null) {
            try {
                currentCategory = Category.valueOf(categoryName);
            } catch (IllegalArgumentException e) {
                currentCategory = Category.TODOS;
            }
        }

        // Obtener preguntas filtradas por categoría
        questions = QuestionBank.getQuestionsByCategory(currentCategory);
        Collections.shuffle(questions);
        
        // Limitar a 20 preguntas si hay más
        if (questions.size() > 20) {
            questions = questions.subList(0, 20);
        }
        
        loadQuestion();
    }

    private void loadQuestion() {
        if (currentQuestionIndex >= questions.size()) {
            showResults();
            return;
        }

        // Reiniciar intentos para la nueva pregunta
        attempts = 0;

        TextView tvCounter = findViewById(R.id.tvQuestionCounter);
        tvCounter.setText(String.format("Pregunta %d de %d", currentQuestionIndex + 1, questions.size()));

        Question q = questions.get(currentQuestionIndex);
        tvQuestion.setText(q.getQuestionText());

        currentShuffledOptions = new ArrayList<>(q.getOptions());
        Collections.shuffle(currentShuffledOptions);

        attempts = 0;
        btnNext.setEnabled(false);

        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(currentShuffledOptions.get(i).getText());
            optionButtons[i].setEnabled(true);
            // Reset a estilo default de Material Button
            optionButtons[i].setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.surface)));
            optionButtons[i].setTextColor(ContextCompat.getColor(this, R.color.text_primary));
            final int index = i;
            optionButtons[i].setOnClickListener(v -> checkAnswer(index));
        }

        updateScore();
        updateProgress(); // Actualizar barra de progreso
    }

    private void checkAnswer(int selected) {
        attempts++;
        AnswerOption opt = currentShuffledOptions.get(selected);
        Question currentQuestion = questions.get(currentQuestionIndex);

        if (opt.isCorrect()) {
            double points = 0.25;
            if (attempts == 2) points = 0.1875;
            else if (attempts == 3) points = 0.125;
            else if (attempts == 4) points = 0.0625;
            totalScore += points;

            // 👇 NUEVO: Guardar con el texto de la pregunta
            String status = (attempts <= 2) ? "✅ Correcto" : "⚠️ Estudiar tema";
            String detail = String.format("%s\n→ %s - intento %d",currentQuestion.getQuestionText(), status, attempts);
            resultDetails.add(detail);

            // Marcar como correcta con color verde
            optionButtons[selected].setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.answer_correct)));
            optionButtons[selected].setTextColor(Color.WHITE);
            
            // Feedback de respuesta correcta
            playCorrectFeedback();
            
            disableAllOptions();
            btnNext.setEnabled(true);
        } else {
            Toast.makeText(this, "Incorrecta, intente nuevamente", Toast.LENGTH_SHORT).show();

            // Marcar como incorrecta
            optionButtons[selected].setEnabled(false);
            optionButtons[selected].setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.answer_incorrect)));
            optionButtons[selected].setTextColor(Color.WHITE);
            
            // Feedback de respuesta incorrecta
            playIncorrectFeedback();

            if (attempts >= 4) {
                // Resaltar la correcta
                for (int i = 0; i < 4; i++) {
                    if (currentShuffledOptions.get(i).isCorrect()) {
                        optionButtons[i].setBackgroundTintList(ColorStateList.valueOf(
                            ContextCompat.getColor(this, R.color.answer_correct)));
                        optionButtons[i].setTextColor(Color.WHITE);
                        break;
                    }
                }

                // 👇 NUEVO: Guardar pregunta completa como incorrecta
                String detail = String.format(
                        "%s\n→ ❌ Incorrecta (4 intentos)",
                        currentQuestion.getQuestionText()
                );
                resultDetails.add(detail);

                disableAllOptions();
                btnNext.setEnabled(true);
            }
        }
    }

    private void disableAllOptions() {
        for (Button b : optionButtons) b.setEnabled(false);
    }

    public void onNextClick(View view) {
        currentQuestionIndex++;
        loadQuestion();
    }

    private void showResults() {
        // Guardar puntuación por categoría en la base de datos
        String username = sessionManager.getUsername();
        if (username != null && currentCategory != Category.TODOS) {
            dbHelper.saveCategoryScore(username, currentCategory, totalScore, questions.size());
        }
        
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("score", totalScore);
        intent.putExtra("category", currentCategory.name());
        intent.putStringArrayListExtra("resultDetails", new ArrayList<>(resultDetails));
        startActivity(intent);
        finish();
    }

    private void updateScore() {
        double pct = (totalScore / 5.0) * 100;
        tvScore.setText(String.format("Puntaje: %.2f / 5.00 (%.1f%%)", totalScore, pct));
    }

    private void updateProgress() {
        int totalQuestions = questions.size();
        int currentProgress = (int) (((float) (currentQuestionIndex + 1) / totalQuestions) * 100);
        
        // Animar la barra de progreso
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            progressBar.setProgress(currentProgress, true);
        } else {
            progressBar.setProgress(currentProgress);
        }
        
        // Actualizar porcentaje
        tvProgressPercent.setText(currentProgress + "%");
    }

    // Feedback para respuesta correcta
    private void playCorrectFeedback() {
        // Vibración corta y suave (100ms)
        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
        
        // Sonido de éxito usando ToneGenerator
        try {
            ToneGenerator toneGen = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 50);
            toneGen.startTone(ToneGenerator.TONE_PROP_ACK, 150);
            new android.os.Handler().postDelayed(toneGen::release, 200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Feedback para respuesta incorrecta
    private void playIncorrectFeedback() {
        // Vibración más fuerte con patrón (200ms pausa 100ms 200ms)
        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                long[] pattern = {0, 200, 100, 200};
                vibrator.vibrate(VibrationEffect.createWaveform(pattern, -1));
            } else {
                long[] pattern = {0, 200, 100, 200};
                vibrator.vibrate(pattern, -1);
            }
        }
        
        // Sonido de error usando ToneGenerator
        try {
            ToneGenerator toneGen = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 50);
            toneGen.startTone(ToneGenerator.TONE_PROP_NACK, 150);
            new android.os.Handler().postDelayed(toneGen::release, 200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentQuestionIndex", currentQuestionIndex);
        outState.putDouble("totalScore", totalScore);
    }
}
