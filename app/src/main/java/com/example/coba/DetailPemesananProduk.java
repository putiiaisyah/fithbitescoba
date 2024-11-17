package com.example.coba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailPemesananProduk extends AppCompatActivity {
    private ImageButton btnMetodePembayaran;
    private Spinner spinnerMetodePembayaran;
    private TextView txtKodeFA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan_produk);

        spinnerMetodePembayaran = findViewById(R.id.spinnerMetodePembayaran);
        txtKodeFA = findViewById(R.id.txtKodeFA);

        // Array pilihan metode pembayaran
        String[] metodePembayaran = {"BCA", "Mandiri", "BNI"};

        // Membuat adapter untuk spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, metodePembayaran);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMetodePembayaran.setAdapter(adapter);

        // Listener untuk menangani pilihan item di spinner
        spinnerMetodePembayaran.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String metode = parentView.getItemAtPosition(position).toString();
                if ("BCA".equals(metode)) {

                    // Redirect ke halaman BCA
                    Intent intent = new Intent(DetailPemesananProduk.this, Metode.class);
                    startActivity(intent);
                } else {
                    // Kosongkan kode FA jika memilih metode lain
                    txtKodeFA.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                txtKodeFA.setText("");
            }
        });
    }
}
