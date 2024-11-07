package com.example.coba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    // Deklarasi variabel untuk elemen UI
    private TextView tvHelloCasie, tvWelcomeCasie;
    private EditText searchBar;
    private Button lihatSelengkapnya1, lihatSelengkapnya2, btnkirimfaq_home;
    private ImageButton imgbtnkategoritawar, imgbtnkategorilaut, imgbtnkategoripakan, imgbtnkategoribibit;
    private ImageView iconCart, iconProfile;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Pastikan ini sesuai dengan nama file XML Anda

        // Inisialisasi elemen UI
        tvHelloCasie = findViewById(R.id.tvHelloCasie);
        tvWelcomeCasie = findViewById(R.id.tvWelcomeCasie);
        lihatSelengkapnya1 = findViewById(R.id.lihatSelengkapnya1);
        lihatSelengkapnya2 = findViewById(R.id.lihatSelengkapnya2);
        imgbtnkategoritawar = findViewById(R.id.imgbtnkategoritawar);
        imgbtnkategorilaut = findViewById(R.id.imgbtnkategorilaut);
        imgbtnkategoripakan = findViewById(R.id.imgbtnkategoripakan);
        imgbtnkategoribibit = findViewById(R.id.imgbtnkategoribibit);
        btnkirimfaq_home = findViewById(R.id.btnkirimfaq_home);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        iconCart = findViewById(R.id.iconCart);
        iconProfile = findViewById(R.id.iconProfile);

        // Set event listener untuk tombol "Lihat Selengkapnya" pertama
        lihatSelengkapnya1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika tombol "Lihat selengkapnya" pertama ditekan
                Intent intent = new Intent(Home.this, DetailArtikel.class);
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
                Intent intent = new Intent(Home.this, DetailArtikel.class);
                intent.putExtra("newsId", 2); // Kirim ID berita kedua
                intent.putExtra("IMAGE_RESOURCE", R.drawable.berita2); // Kirim gambar untuk berita kedua
                startActivity(intent);
            }
        });

        // Set event listener untuk ikon keranjang
        iconCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika ikon keranjang ditekan
                Intent intent = new Intent(Home.this, Keranjang.class);
                startActivity(intent);
            }
        });

        // Set event listener untuk ikon profil
        iconProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika ikon profil ditekan
                Intent intent = new Intent(Home.this, EditProfile.class);
                startActivity(intent);
            }
        });

        // Set event listener untuk kategori ikan air tawar
        imgbtnkategoritawar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika ikon keranjang ditekan
                Intent intent = new Intent(Home.this, KategoriTawar.class);
                startActivity(intent);
            }
        });

        // Set event listener untuk kategori ikan air laut
        imgbtnkategorilaut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika ikon keranjang ditekan
                Intent intent = new Intent(Home.this, KategoriLaut.class);
                startActivity(intent);
            }
        });


        // Set event listener untuk kategori pakan ikan
        imgbtnkategoripakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika ikon keranjang ditekan
                Intent intent = new Intent(Home.this, PakanIkan.class);
                startActivity(intent);
            }
        });


        // Set event listener untuk kategori pembibitan ikan
        imgbtnkategoribibit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika ikon keranjang ditekan
                Intent intent = new Intent(Home.this, KategoriPembibitan.class);
                startActivity(intent);
            }
        });


        // Set event listener untuk kirim faq
        btnkirimfaq_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika ikon keranjang ditekan
                Intent intent = new Intent(Home.this, FormFaq.class);
                startActivity(intent);
            }
        });


    }
}