package com.example.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText loginUsername = findViewById(R.id.login_username);
        EditText loginPassword = findViewById(R.id.login_password);
        Button loginButton = findViewById(R.id.login_button);
        Button registerButton = findViewById(R.id.register_button);

        loginButton.setOnClickListener(v -> {
            String username = loginUsername.getText().toString().trim();
            String password = loginPassword.getText().toString().trim();

            // Access SharedPreferences to get stored user details
            SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
            String registeredUsername = sharedPreferences.getString("username", "");
            String registeredPassword = sharedPreferences.getString("password", "");
            String registeredEmail = sharedPreferences.getString("email", ""); // Get registered email if needed

            // Validate login credentials
            if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
                Intent intent = new Intent(LoginActivity.this, UserDetailsActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("email", registeredEmail); // Pass the registered email
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Invalid login. Please register first.", Toast.LENGTH_SHORT).show();
            }
        });

        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
