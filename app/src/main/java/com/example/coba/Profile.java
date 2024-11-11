package com.example.coba;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    // Deklarasi variabel untuk ImageButton dan BottomNavigationView
    private TextView editprofile,card, logout, history ;
    private BottomNavigationView bottomNavigationView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        // Inisialisasi BottomNavigationView
        logout = findViewById(R.id.logout);
        card = findViewById(R.id.card);
        bottomNavigationView1 = findViewById(R.id.bottom_navigation);
        editprofile = findViewById(R.id.editprofile);
        history = findViewById(R.id.history);

        // Set the selected item to 'Profil' when Profile activity is opened
        bottomNavigationView1.setSelectedItemId(R.id.nav_profil);

        editprofile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Profile.this, EditProfile.class);
                startActivity(intent);
            }
        });

        card.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Profile.this, Keranjang.class);
                startActivity(intent);
            }
        });

        history.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Profile.this, RiwayatPembelian.class);
                startActivity(intent);
            }
        });

        // Set onClickListener untuk buttonLogout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk membuka halaman Login
                Intent intent = new Intent(Profile.this, Login.class);

                // Hapus aktivitas Home dari back stack agar tidak bisa diakses kembali
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                // Mulai aktivitas Login
                startActivity(intent);

                // Tutup aktivitas Home
                finish();
            }
        });

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
