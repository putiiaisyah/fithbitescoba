package com.example.coba;

import static android.widget.Toast.makeText;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormFaq extends AppCompatActivity {
    private ImageButton backbutton, iconProfile, btnkirimfaq;
    private EditText editTextnamafaq, editTextemailfaq, editTextKatPertnyaanfaq, editTextDeskfaq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_faq);

        // Inisialisasi EditTexts dan Button
        editTextnamafaq = findViewById(R.id.editTextnamafaq);
        editTextemailfaq = findViewById(R.id.editTextemailfaq);
        editTextKatPertnyaanfaq = findViewById(R.id.editTextKatPertnyaanfaq);
        editTextDeskfaq = findViewById(R.id.editTextDeskfaq);
        btnkirimfaq = findViewById(R.id.btnkirimfaq);
        backbutton = findViewById(R.id.backbutton);
        iconProfile = findViewById(R.id.iconProfile);


        btnkirimfaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnkirimfaq();
            }
        });



        // Set aksi ketika tombol Kembali diklik
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Menutup activity ini dan kembali ke activity sebelumnya
            }
        });

        iconProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi ketika ikon profil ditekan
                Intent intent = new Intent(FormFaq.this, Profile.class);
                startActivity(intent);
            }
        });

    }
    private void btnkirimfaq(){
        // Ambil data dari EditTexts
        String nama = editTextnamafaq.getText().toString().trim();
        String email = editTextemailfaq.getText().toString().trim();
        String kategori = editTextKatPertnyaanfaq.getText().toString().trim();
        String deskripsi = editTextDeskfaq.getText().toString().trim();

        // Validasi input kosong
        if (TextUtils.isEmpty(nama)) {
            editTextnamafaq.setError("Nama harus diisi");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            editTextemailfaq.setError("Email harus diisi");
            return;
        }
        if (TextUtils.isEmpty(kategori)) {
            editTextKatPertnyaanfaq.setError("Kategori harus diisi");
            return;
        }
        if (TextUtils.isEmpty(deskripsi)) {
            editTextDeskfaq.setError("Deskripsi harus diisi");
            return;
        }

        // Kirim data (tampilkan Toast sebagai contoh sederhana)
        makeText(this, "FAQ Terkirim, Terima Kasih!", Toast.LENGTH_SHORT).show();

        // Membuat intent untuk redirect ke halaman Home
        Intent intent = new Intent(FormFaq.this, Home.class); // Pastikan 'Home' adalah nama kelas activity tujuan
        startActivity(intent); // Jalankan intent untuk pindah ke halaman Home

        // Menutup FormFaq agar tidak kembali ke halaman ini setelah redirect
        finish();


    }
}