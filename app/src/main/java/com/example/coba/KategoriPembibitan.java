package com.example.coba;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class KategoriPembibitan extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kategori);

        // Inisialisasi BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set the selected item to 'Kategori' when Kategori activity is opened
        bottomNavigationView.setSelectedItemId(R.id.nav_artikel);

        // Set listener untuk item bottom navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Menggunakan if-else untuk menentukan item yang dipilih
                if (item.getItemId() == R.id.nav_home) {
                    // Navigasi ke Home activity
                    Intent homeIntent = new Intent(KategoriPembibitan.this, Home.class);
                    startActivity(homeIntent);
                    return true;
                } else if (item.getItemId() == R.id.nav_artikel) {
                    // Navigasi ke Artikel activity
                    Intent artikelIntent = new Intent(KategoriPembibitan.this, DetailArtikel.class);
                    startActivity(artikelIntent);
                    return true;
                } else if (item.getItemId() == R.id.nav_profil) {
                    // Menampilkan Toast jika Kategori dipilih
                    Toast.makeText(KategoriPembibitan.this, "You are already in Kategori", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false; // Default return false
            }
        });

        // Menangani window insets untuk mengatur padding agar tidak terhalang system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
