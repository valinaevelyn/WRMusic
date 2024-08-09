package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
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

//                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("drawer_username",username);
//                    editor.apply();

//                    TextView drawerUsername = findViewById(R.id.drawer_username);
//                    drawerUsername.setText(username);

                    // Buat Intent untuk memulai MainActivity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("USERNAME", username);

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