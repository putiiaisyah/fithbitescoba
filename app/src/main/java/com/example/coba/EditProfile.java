package com.example.coba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfile extends AppCompatActivity {
    private EditText usernameEditText, emailEditText; // Hanya username dan email
    private Button updateButton;
    private DatabaseHelper databaseHelper;
    private int userId; // ID pengguna yang sedang login

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // Inisialisasi komponen
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        updateButton = findViewById(R.id.updatebtn);
        databaseHelper = new DatabaseHelper(this);

        // Ambil ID pengguna dari intent
        userId = getIntent().getIntExtra("USER_ID", -1);

        if (userId == -1) {
            Toast.makeText(this, "ID pengguna tidak valid", Toast.LENGTH_SHORT).show();
            finish(); // Tutup activity jika ID tidak valid
            return;
        }

        // Mengisi formulir dengan data pengguna saat ini
        populateUserData(userId);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserProfile();
            }
        });
    }

    // Mengisi EditText dengan data pengguna saat ini
    private void populateUserData(int userId) {
        User user = databaseHelper.getUserById(userId); // Ambil data pengguna
        if (user != null) {
            usernameEditText.setText(user.getUsername());
            emailEditText.setText(user.getEmail());
        } else {
            Toast.makeText(this, "Pengguna tidak ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    // Mengupdate data pengguna
    private void updateUserProfile() {
        String username = usernameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();

        if (username.isEmpty() || email.isEmpty()) {
            Toast.makeText(EditProfile.this, "Semua field harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validasi email
        if (!isValidEmail(email)) {
            Toast.makeText(EditProfile.this, "Format email tidak valid", Toast.LENGTH_SHORT).show();
            return;
        }

        // Update data pengguna
        boolean isUpdated = databaseHelper.updateUser(userId, username, email);
        if (isUpdated) {
            Toast.makeText(EditProfile.this, "Profile berhasil diupdate", Toast.LENGTH_SHORT).show();
            // Kembali ke activity profile atau beranda
            Intent intent = new Intent(EditProfile.this, Home.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(EditProfile.this, "Gagal update profile", Toast.LENGTH_SHORT).show();
        }
    }

    // Method untuk validasi format email
    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
