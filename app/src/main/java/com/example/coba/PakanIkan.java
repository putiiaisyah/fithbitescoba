package com.example.coba;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PakanIkan extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ImageButton buttontawarkategori, buttonlautkategori, buttonpakankategori, buttonbibitkategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pakan_ikan);

        // Inisialisasi BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        buttontawarkategori = findViewById(R.id.buttontawarkategori);
        buttonlautkategori = findViewById(R.id.buttonlautkategori);
        buttonpakankategori = findViewById(R.id.buttonpakankategori);
        buttonbibitkategori = findViewById(R.id.buttonbibitkategori);

        buttontawarkategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(PakanIkan.this, KategoriTawar.class);
                startActivity(intent);
            }
        });

        buttonlautkategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(PakanIkan.this, KategoriLaut.class);
                startActivity(intent);
            }
        });

        buttonpakankategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(PakanIkan.this, PakanIkan.class);
                startActivity(intent);
            }
        });

        buttonbibitkategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(PakanIkan.this, KategoriPembibitan.class);
                startActivity(intent);
            }
        });

        // Set listener untuk item bottom navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Menggunakan if-else untuk menentukan item yang dipilih
                if (item.getItemId() == R.id.nav_home) {
                    // Navigasi ke Home activity
                    Intent homeIntent = new Intent(PakanIkan.this, Home.class);
                    startActivity(homeIntent);
                    return true;
                } else if (item.getItemId() == R.id.nav_artikel) {
                    // Navigasi ke Artikel activity
                    Intent artikelIntent = new Intent(PakanIkan.this, Artikel.class);
                    startActivity(artikelIntent);
                    return true;
                } else if (item.getItemId() == R.id.nav_profil) {
                    // Menampilkan Toast jika Kategori dipilih
                    Toast.makeText(PakanIkan.this, "You are already in Kategori", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false; // Default return false
            }
        });

    }
}
