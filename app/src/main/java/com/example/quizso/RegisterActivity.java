package com.example.quizso;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quizso.utils.DBHelper;
import com.example.quizso.utils.SessionManager;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {
    
    private TextInputEditText etUsername, etPassword, etConfirmPassword;
    private MaterialButton btnRegister, btnBackToLogin;
    private DBHelper dbHelper;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicializar componentes
        etUsername = findViewById(R.id.etRegUsername);
        etPassword = findViewById(R.id.etRegPassword);
        etConfirmPassword = findViewById(R.id.etRegConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnBackToLogin = findViewById(R.id.btnBackToLogin);

        dbHelper = new DBHelper(this);
        sessionManager = new SessionManager(this);

        // Botón de registro
        btnRegister.setOnClickListener(v -> registerUser());

        // Botón volver al login
        btnBackToLogin.setOnClickListener(v -> {
            finish();
        });
    }

    private void registerUser() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        // Validaciones
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (username.length() < 3) {
            Toast.makeText(this, "El usuario debe tener al menos 3 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 4) {
            Toast.makeText(this, "La contraseña debe tener al menos 4 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        // Intentar registrar
        if (dbHelper.registerUser(username, password)) {
            Toast.makeText(this, "¡Registro exitoso! Puedes iniciar sesión", Toast.LENGTH_LONG).show();
            
            // Opcional: Auto-login después del registro
            sessionManager.createLoginSession(username);
            startActivity(new Intent(RegisterActivity.this, WelcomeActivity.class));
            finish();
        } else {
            Toast.makeText(this, "El usuario ya existe. Elige otro nombre", Toast.LENGTH_SHORT).show();
        }
    }
}
