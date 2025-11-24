package com.example.quizso;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quizso.utils.DBHelper;
import com.example.quizso.utils.SessionManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    
    private SessionManager sessionManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        sessionManager = new SessionManager(this);
        
        // Verificar si ya hay sesión activa
        if (sessionManager.isLoggedIn()) {
            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
            finish();
            return;
        }
        
        setContentView(R.layout.activity_login);

        TextInputEditText etUser = findViewById(R.id.etUsername);
        TextInputEditText etPass = findViewById(R.id.etPassword);
        MaterialButton btnLogin = findViewById(R.id.btnLogin);
        MaterialButton btnRegister = findViewById(R.id.btnGoToRegister);
        DBHelper dbHelper = new DBHelper(this);

        btnLogin.setOnClickListener(v -> {
            String u = etUser.getText().toString().trim();
            String p = etPass.getText().toString().trim();
            if (u.isEmpty() || p.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }
            if (dbHelper.validateUser(u, p)) {
                // Guardar sesión
                sessionManager.createLoginSession(u);
                
                Toast.makeText(this, "¡Bienvenido " + u + "!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        // Botón para ir a registro
        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }
}