package com.example.coba;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    private EditText etUsername, etEmail, etPassword;
    private Button btnSignup;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Menghubungkan ID dari layout ke variabel Java
        etUsername = findViewById(R.id.username);
        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        btnSignup = findViewById(R.id.signupButton);
        dbHelper = new DatabaseHelper(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Memeriksa apakah kolom diisi
                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Signup.this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    // Menambahkan pengguna baru
                    if (dbHelper.addUser(username, password)) {
                        Toast.makeText(Signup.this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show();
                        finish(); // Kembali ke LoginActivity
                    } else {
                        Toast.makeText(Signup.this, "Username sudah digunakan", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
