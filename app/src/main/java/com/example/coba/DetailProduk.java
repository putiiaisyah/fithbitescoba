package com.example.coba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DetailProduk extends AppCompatActivity {
    private ImageButton backbutton;
    private ArrayList<String> keranjang = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_produk);

        backbutton = findViewById(R.id.backbutton);

        // Set aksi ketika tombol Kembali diklik
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Menutup activity ini dan kembali ke activity sebelumnya
            }
        });

        // Menyambungkan ImageView dengan kode Java
        ImageView imgviewmasukkeranjang = findViewById(R.id.imgviewmasukkeranjang);

        // Menambahkan OnClickListener untuk menangani klik pada ImageView
        imgviewmasukkeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menambahkan item ke keranjang
                addToCart("Item 1");

                // Menampilkan Toast bahwa item telah ditambahkan ke keranjang
                Toast.makeText(getApplicationContext(), "Item ditambahkan ke keranjang!", Toast.LENGTH_SHORT).show();

                // Redirect ke halaman keranjang (KeranjangActivity)
                Intent intent = new Intent(DetailProduk.this, Keranjang.class);
                startActivity(intent);
            }
        });
    }

    // Metode untuk menambahkan item ke keranjang
    private void addToCart(String item) {
        keranjang.add(item);
    }

    // Menampilkan daftar keranjang (opsional)
    public ArrayList<String> getKeranjang() {
        return keranjang;

    }

}