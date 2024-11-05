package com.example.coba;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signup extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signupButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        // Inisialisasi komponen UI
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        signupButton = findViewById(R.id.signupButton);
        databaseHelper = new DatabaseHelper(this);

        // Mengatur padding untuk menghindari overlay dengan sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set listener untuk tombol signup
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil input pengguna
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validasi input
                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Signup.this, "Harap lengkapi semua field", Toast.LENGTH_SHORT).show();
                } else {
                    // Simpan data pengguna ke database
                    boolean isInserted = databaseHelper.addUser(username, email, password);
                    if (isInserted) {
                        Toast.makeText(Signup.this, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();
                        finish(); // Tutup activity signup setelah pendaftaran berhasil
                    } else {
                        Toast.makeText(Signup.this, "Pendaftaran Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
