package com.example.coba;

import static android.widget.Toast.makeText;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class KategoriLaut extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ImageButton buttontawarkategori, buttonlautkategori,buttonpakankategori, buttonbibitkategori;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kategori_laut);

        // Inisialisasi BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        buttontawarkategori = findViewById(R.id.buttontawarkategori);
        buttonlautkategori = findViewById(R.id.buttonlautkategori);
        buttonpakankategori = findViewById(R.id.buttonpakankategori);
        buttonbibitkategori = findViewById(R.id.buttonbibitkategori);

        // Set listener untuk item bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        buttontawarkategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(KategoriLaut.this, KategoriTawar.class);
                startActivity(intent);
            }
        });

        buttonlautkategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(KategoriLaut.this, KategoriLaut.class);
                startActivity(intent);
            }
        });

        buttonpakankategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(KategoriLaut.this, PakanIkan.class);
                startActivity(intent);
            }
        });

        buttonbibitkategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(KategoriLaut.this, KategoriPembibitan.class);
                startActivity(intent);
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    makeText(KategoriLaut.this, "", Toast.LENGTH_SHORT).show();makeText(KategoriLaut.this, "Store selected", Toast.LENGTH_SHORT).show();
//                    bottomNavigationView.setSelectedItemId(R.id.menu_store);
                    return true;
                } else if (item.getItemId() == R.id.nav_artikel) {
                    Intent intent = new Intent(KategoriLaut.this, DetailArtikel.class);

                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.nav_profil) {
                    Intent intent = new Intent(KategoriLaut.this, Profile.class);
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
