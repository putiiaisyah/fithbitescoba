package com.example.coba;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button signupButton; // Tambahkan variabel untuk tombol signup
    private DatabaseHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Inisialisasi komponen UI
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton); // Inisialisasi tombol signup
        databaseHelper = new DatabaseHelper(this);

        // Mengatur padding untuk menghindari overlay dengan sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set listener untuk tombol login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil input pengguna
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (databaseHelper.checkUser(username, password)) {
                    // Jika berhasil login, arahkan ke activity Home
                    Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Home.class);
                    intent.putExtra("USERNAME", username); // Mengirim username ke Home
                    startActivity(intent);
                    finish(); // Tutup activity login
                } else {
                    // Jika gagal login, tampilkan pesan kesalahan
                    Toast.makeText(Login.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Set listener untuk tombol signup
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke activity Signup
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });
    }
}
