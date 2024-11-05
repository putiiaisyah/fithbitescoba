package com.example.coba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton; // Ganti ImageView dengan ImageButton

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    private ImageButton iconProfile; // Ganti dari ImageView menjadi ImageButton
    private int userId; // Variabel untuk menyimpan ID pengguna

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Ambil ID pengguna dari intent (dari activity sebelumnya)
        userId = getIntent().getIntExtra("USER_ID", -1); // Pastikan USER_ID diterima

        // Inisialisasi ImageButton untuk ikon profil
        iconProfile = findViewById(R.id.iconProfile); // Tidak ada perubahan di sini

        // Menambahkan listener klik pada iconProfile
        iconProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke EditProfile activity dan kirimkan ID pengguna
                Intent intent = new Intent(Home.this, EditProfile.class);
                intent.putExtra("USER_ID", userId); // Kirimkan USER_ID ke EditProfile
                startActivity(intent); // Mulai activity EditProfile
            }
        });
    }
}
