package com.example.coba;

import static android.widget.Toast.makeText;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class KategoriTawar extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ImageView imgviewtawarproduk;
    private ImageButton buttontawarkategori, buttonlautkategori, buttonpakankategori, buttonbibitkategori, imgbuttontawarproduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kategori_tawar);

        // Inisialisasi BottomNavigationView
        imgbuttontawarproduk = findViewById(R.id.imgbuttontawarproduk);
        imgviewtawarproduk = findViewById(R.id.imgviewtawarproduk);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        buttontawarkategori = findViewById(R.id.buttontawarkategori);
        buttonlautkategori = findViewById(R.id.buttonlautkategori);
        buttonpakankategori = findViewById(R.id.buttonpakankategori);
        buttonbibitkategori = findViewById(R.id.buttonbibitkategori);

        // Set listener untuk item bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        imgviewtawarproduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KategoriTawar.this, DetailProduk.class);
                startActivity(intent);
            }
        });

        imgbuttontawarproduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KategoriTawar.this, DetailProduk.class);
                startActivity(intent);
            }
        });

        buttontawarkategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(KategoriTawar.this, KategoriTawar.class);
                startActivity(intent);
            }
        });

        buttonlautkategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(KategoriTawar.this, KategoriLaut.class);
                startActivity(intent);
            }
        });

        buttonpakankategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(KategoriTawar.this, PakanIkan.class);
                startActivity(intent);
            }
        });

        buttonbibitkategori.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(KategoriTawar.this, KategoriPembibitan.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    makeText(KategoriTawar.this, "", Toast.LENGTH_SHORT).show();makeText(KategoriTawar.this, "Store selected", Toast.LENGTH_SHORT).show();
//                    bottomNavigationView.setSelectedItemId(R.id.menu_store);
                    return true;
                } else if (item.getItemId() == R.id.nav_artikel) {
                    Intent intent = new Intent(KategoriTawar.this, DetailArtikel.class);

                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.nav_profil) {
                    Intent intent = new Intent(KategoriTawar.this, Profile.class);
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
