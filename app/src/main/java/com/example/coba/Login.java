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
    private EditText usernameEditText; // Mengubah nama variabel untuk username
    private EditText passwordEditText;
    private Button loginButton;
    private DatabaseHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Inisialisasi komponen UI
        usernameEditText = findViewById(R.id.username); // Mengambil username dari EditText
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
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
                String username = usernameEditText.getText().toString(); // Mengambil username
                String password = passwordEditText.getText().toString();

                // Verifikasi login
                if (databaseHelper.checkUser(username, password)) { // Menggunakan username untuk verifikasi
                    // Jika berhasil login, arahkan ke activity lain
                    Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class); // Ganti dengan activity yang sesuai
                    startActivity(intent);
                    finish(); // Tutup activity login
                } else {
                    // Jika gagal login, tampilkan pesan kesalahan
                    Toast.makeText(Login.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
