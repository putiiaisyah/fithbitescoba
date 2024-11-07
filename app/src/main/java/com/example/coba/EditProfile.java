package com.example.coba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfile extends AppCompatActivity {
    private EditText etUsername, etEmail, etAddress, etPhone;
    private ImageButton btnSave, btnBack; // Tambahkan variabel untuk tombol kembali
    private DatabaseHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile); // Pastikan nama file XML sudah benar

        // Inisialisasi elemen UI
        etUsername = findViewById(R.id.username); // Sesuaikan ID dengan layout XML
        etEmail = findViewById(R.id.email);
        etAddress = findViewById(R.id.alamat);
        etPhone = findViewById(R.id.notelp);
        btnSave = findViewById(R.id.btnsimpan); // Sesuaikan ID untuk tombol Simpan
        btnBack = findViewById(R.id.backbutton); // Inisialisasi tombol kembali

        dbHelper = new DatabaseHelper(this);

        // Set aksi ketika tombol Simpan diklik
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();

                // Validasi input
                if (username.isEmpty() || email.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(EditProfile.this, "Semua field harus diisi", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Simpan data ke database
                boolean success = dbHelper.saveProfile(username, email, address, phone);

                if (success) {
                    Toast.makeText(EditProfile.this, "Berhasil mengedit profil", Toast.LENGTH_SHORT).show();
                    finish(); // Kembali ke activity sebelumnya
                } else {
                    Toast.makeText(EditProfile.this, "Gagal menyimpan profil", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set aksi ketika tombol Kembali diklik
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Menutup activity ini dan kembali ke activity sebelumnya
            }
        });
    }
}