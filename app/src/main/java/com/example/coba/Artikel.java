package com.example.coba;

import static android.widget.Toast.makeText;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Artikel extends AppCompatActivity {
    private ImageButton backbutton;
    private Button lihatSelengkapnya1, lihatSelengkapnya2,lihatSelengkapnya3;
    private BottomNavigationView bottomNavigationView1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_artikel);

        backbutton = findViewById(R.id.backbutton);
        lihatSelengkapnya1 = findViewById(R.id.lihatSelengkapnya1);
        lihatSelengkapnya2 = findViewById(R.id.lihatSelengkapnya2);
        lihatSelengkapnya3 = findViewById(R.id.lihatSelengkapnya3);

        backbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish(); // Menutup activity ini dan kembali ke activity sebelumnya
            }
        });

        // Set event listener untuk tombol "Lihat Selengkapnya" pertama
        lihatSelengkapnya1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika tombol "Lihat selengkapnya" pertama ditekan
                Intent intent = new Intent(Artikel.this, DetailArtikel.class);
                intent.putExtra("newsId", 1); // Kirim ID berita pertama
                intent.putExtra("IMAGE_RESOURCE", R.drawable.berita1); // Kirim gambar untuk berita pertama
                startActivity(intent);
            }
        });

        // Set event listener untuk tombol "Lihat Selengkapnya" kedua
        lihatSelengkapnya2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika tombol "Lihat selengkapnya" kedua ditekan
                Intent intent = new Intent(Artikel.this, DetailArtikel.class);
                intent.putExtra("newsId", 2); // Kirim ID berita kedua
                intent.putExtra("IMAGE_RESOURCE", R.drawable.berita2); // Kirim gambar untuk berita kedua
                startActivity(intent);
            }
        });

        // Set event listener untuk tombol "Lihat Selengkapnya" kedua
        lihatSelengkapnya3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika tombol "Lihat selengkapnya" kedua ditekan
                Intent intent = new Intent(Artikel.this, DetailArtikel.class);
                intent.putExtra("newsId", 2); // Kirim ID berita kedua
                intent.putExtra("IMAGE_RESOURCE", R.drawable.berita2); // Kirim gambar untuk berita kedua
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    Intent homeIntent = new Intent(Artikel.this, Home.class);
//                    bottomNavigationView.setSelectedItemId(R.id.menu_store);
                    return true;
                } else if (item.getItemId() == R.id.nav_artikel) {
                    Intent intent = new Intent(Artikel.this, Artikel.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.nav_profil) {
                    Intent intent = new Intent(Artikel.this, Profile.class);
                    startActivity(intent);
//                    bottomNavigationView.setSelectedItemId(R.id.menu_profile);
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
}