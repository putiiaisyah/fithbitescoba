package com.example.coba;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Metode extends AppCompatActivity {
    private ImageButton bgbca;
    private TextView txtNomorRekening, txtNorek, txtViewPt;
    private ImageButton btnSalin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_metode);
        // Menemukan View dari layout
        bgbca = findViewById(R.id.bgbca);
        txtNomorRekening = findViewById(R.id.txtnomerrekening);
        txtNorek = findViewById(R.id.txtnorek);
        txtViewPt = findViewById(R.id.txtviewpt);
        btnSalin = findViewById(R.id.btnsalin);


        // Menyembunyikan tampilan ini ketika pertama kali
        txtNomorRekening.setVisibility(View.GONE);
        txtNorek.setVisibility(View.GONE);
        txtViewPt.setVisibility(View.GONE);
        btnSalin.setVisibility(View.GONE);

        // Menambahkan OnClickListener ke ImageButton bgbca
        bgbca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menampilkan tampilan saat image BCA diklik
                txtNomorRekening.setVisibility(View.VISIBLE);
                txtNorek.setVisibility(View.VISIBLE);
                txtViewPt.setVisibility(View.VISIBLE);
                btnSalin.setVisibility(View.VISIBLE);
            }
        });

        // OnClickListener untuk btnSalin
        btnSalin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil teks dari TextView
                String teksYangDisalin = txtNorek.getText().toString();

                // Menyalin teks ke clipboard
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                if (clipboard != null) {
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Nomor Rekening", teksYangDisalin);
                    clipboard.setPrimaryClip(clip);

                    // Menampilkan toast untuk memberi tahu pengguna
                    Toast.makeText(Metode.this, "Teks berhasil disalin", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}