package com.example.coba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Keranjang extends AppCompatActivity {
    private ImageButton btnBack;
    private int productQuantity = 1; // Jumlah produk awal
    private TextView texthargakeranjang; // TextView untuk harga

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);

        // Inisialisasi komponen UI
        btnBack = findViewById(R.id.backbutton); // Inisialisasi tombol back
        ImageButton minusButton = findViewById(R.id.icminus_keranjang);
        ImageButton plusButton = findViewById(R.id.icplus_keranjang);
        ImageButton deleteButton = findViewById(R.id.imgDelete);
        texthargakeranjang = findViewById(R.id.texthargakeranjang);
        TextView productName = findViewById(R.id.textproduk);
        TextView productLocation = findViewById(R.id.textalamatkeranjang);

        // Set nama produk dan lokasi
        productName.setText("Ikan Tuna");
        productLocation.setText("Jakarta Timur");
        updatePrice(); // Perbarui harga sesuai dengan jumlah produk

        // Fungsi untuk tombol back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Menutup activity ini dan kembali ke activity sebelumnya
            }
        });

        // Fungsi untuk tombol minus
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productQuantity > 1) {
                    productQuantity--;
                    updatePrice(); // Perbarui harga setelah jumlah produk diubah
                } else {
                    Toast.makeText(Keranjang.this, "Jumlah tidak bisa kurang dari 1", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Fungsi untuk tombol plus
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productQuantity++;
                updatePrice(); // Perbarui harga setelah jumlah produk diubah
            }
        });

        // Fungsi untuk tombol hapus
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Keranjang.this, "Item berhasil dihapus dari keranjang", Toast.LENGTH_SHORT).show();
                finish(); // Mengakhiri activity ini
            }
        });
    }

    // Fungsi untuk memperbarui harga berdasarkan jumlah produk
    private void updatePrice() {
        int pricePerItem = 50000; // Harga per item
        int totalPrice = productQuantity * pricePerItem; // Total harga
        texthargakeranjang.setText("Rp " + totalPrice); // Update TextView harga
    }
}
