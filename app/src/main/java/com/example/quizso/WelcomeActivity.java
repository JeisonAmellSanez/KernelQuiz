package com.example.quizso;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quizso.utils.SessionManager;

public class WelcomeActivity extends AppCompatActivity {
    
    private SessionManager sessionManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        sessionManager = new SessionManager(this);
        
        // Mostrar el nombre del usuario
        TextView tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
        String username = sessionManager.getUsername();
        if (username != null) {
            tvWelcomeUser.setText("¡Hola, " + username + "!");
        }

        findViewById(R.id.btnStartQuiz).setOnClickListener(v ->
                startActivity(new Intent(WelcomeActivity.this, CategorySelectionActivity.class))
        );

        findViewById(R.id.btnLogout).setOnClickListener(v -> {
            // Cerrar sesión
            sessionManager.logout();
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            finish();
        });

        findViewById(R.id.btnAbout).setOnClickListener(v ->
                startActivity(new Intent(WelcomeActivity.this, AboutActivity.class))
        );
    }
}
