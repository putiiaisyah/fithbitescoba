package com.example.coba;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Inisialisasi BottomNavigationView
        bottomNavigationView1 = findViewById(R.id.bottom_navigation);

        // Set the selected item to 'Profil' when Profile activity is opened
        bottomNavigationView1.setSelectedItemId(R.id.nav_profil);

        // Set listener untuk item bottom navigation
        bottomNavigationView1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Menggunakan if-else untuk menentukan item yang dipilih
                if (item.getItemId() == R.id.nav_home) {
                    // Navigasi ke Home activity
                    Intent homeIntent = new Intent(Profile.this, Home.class);
                    startActivity(homeIntent);
                    return true;
                } else if (item.getItemId() == R.id.nav_artikel) {
                    // Navigasi ke Artikel activity
                    Intent artikelIntent = new Intent(Profile.this, DetailArtikel.class);
                    startActivity(artikelIntent);
                    return true;
                } else if (item.getItemId() == R.id.nav_profil) {
                    // Menampilkan Toast jika Profil dipilih
                    Toast.makeText(Profile.this, "You are already in Profile", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false; // Default return false
            }
        });
    }
}
