package com.example.coba;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;

public class Keranjang extends AppCompatActivity {
    private ImageButton backbutton;
    private int productQuantity = 1; // Jumlah produk awal
    private TextView texthargakeranjang; // TextView untuk harga


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);

        // Inisialisasi komponen UI
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
                // Logika untuk menghapus item dari keranjang
                Toast.makeText(Keranjang.this, "Item berhasil dihapus dari keranjang", Toast.LENGTH_SHORT).show();
                // Kembali ke halaman sebelumnya atau melakukan tindakan lain
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