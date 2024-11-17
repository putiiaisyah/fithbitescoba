package com.example.coba;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailPemesananProduk extends AppCompatActivity {
    private Spinner spinnerBank;
    private ImageButton btnMetodePembayaran;
    private String[] banks = {"Pilih Bank", "BCA"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan_produk);

        spinnerBank = findViewById(R.id.spinnerBank);
        btnMetodePembayaran = findViewById(R.id.btnmetodepmbyrn);

        // Membuat adapter untuk Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, banks);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBank.setAdapter(adapter);

        // Set onClickListener untuk button
        btnMetodePembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menampilkan spinner ketika tombol diklik
                spinnerBank.setVisibility(View.VISIBLE);
            }
        });

        // Set listener untuk item yang dipilih di Spinner
        spinnerBank.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedBank = parentView.getItemAtPosition(position).toString();
                // Menampilkan nama bank yang dipilih
                if (!selectedBank.equals("Pilih Bank")) {
                    Toast.makeText(DetailPemesananProduk.this, "Anda memilih: " + selectedBank, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Kosongkan jika tidak ada pilihan
            }
        });
    }
}