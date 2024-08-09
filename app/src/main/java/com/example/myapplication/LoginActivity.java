package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView errorMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        errorMessageTextView = findViewById(R.id.errorMessage);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Reset error message
                errorMessageTextView.setVisibility(View.INVISIBLE);
                errorMessageTextView.setText("");

                // Validasi username dan password
                if (username.isEmpty()) {
                    showErrorMessage("Username Must be Filled!");
                } else if (password.isEmpty()) {
                    showErrorMessage("Password Must be Filled!");
                } else if (username.length() <= 5 || username.length() >= 10) {
                    showErrorMessage("Username length must be > 5 and < 10!");
                } else {
                    // Login berhasil
                    errorMessageTextView.setVisibility(View.VISIBLE);
                    errorMessageTextView.setText("Login berhasil");

                    // Buat Intent untuk memulai MainActivity
                    Intent intent = new Intent(LoginActivity.this, AboutActivity.class);
                    startActivity(intent);

                    // Akhiri LoginActivity sehingga pengguna tidak bisa kembali dengan tombol back
                    finish();
                }
            }
        });
    }

    private void showErrorMessage(String message) {
        errorMessageTextView.setVisibility(View.VISIBLE);
        errorMessageTextView.setText(message);
    }
}