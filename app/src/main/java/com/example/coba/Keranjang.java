package com.example.coba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Keranjang extends AppCompatActivity {
    private ImageButton btnBack, icplus_keranjang, icminus_keranjang;
    private EditText editText_quantity;
    private int productQuantity = 1; // Jumlah produk awal
    private TextView texthargakeranjang, textkeranjang, txtquantity;// TextView untuk harga
    private Button btnpesansekarang;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);

        // Inisialisasi komponen UI
        btnBack = findViewById(R.id.backbutton); // Inisialisasi tombol back
        CheckBox checkboxkeranjang = findViewById(R.id.checkboxkeranjang);
        ImageButton minusButton = findViewById(R.id.icminus_keranjang);
        ImageButton plusButton = findViewById(R.id.icplus_keranjang);
        ImageButton deleteButton = findViewById(R.id.imgDelete);
        texthargakeranjang = findViewById(R.id.texthargakeranjang);
        TextView productName = findViewById(R.id.textproduk);
        TextView productLocation = findViewById(R.id.textalamatkeranjang);
        icplus_keranjang = findViewById(R.id.icplus_keranjang);
        icminus_keranjang = findViewById(R.id.icminus_keranjang);
        txtquantity = findViewById(R.id.txtquantity);
        CheckBox checkBoxkeranjang = findViewById(R.id.checkboxkeranjang);
        ImageView imageView7 = findViewById(R.id.imageView7);
        TextView txtsubharga = findViewById(R.id.txtsubharga);
        TextView txttotalsubharga = findViewById(R.id.txttotalsubharga);
        TextView txtbiayalayanan = findViewById(R.id.txtbiayalayanan);
        TextView txthargalayanan = findViewById(R.id.txthargalayanan);
        TextView txtgaris = findViewById(R.id.txtgaris);
        TextView totalhargatxt = findViewById(R.id.totalhargatxt);
        Button btnpesansekarang = findViewById(R.id.btnpesansekarang);

        // Set listener untuk checkbox
        checkboxkeranjang.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Jika checkbox dicentang, tampilkan elemen
            if (isChecked) {
                imageView7.setVisibility(View.VISIBLE);
                txtsubharga.setVisibility(View.VISIBLE);
                txttotalsubharga.setVisibility(View.VISIBLE);
                txtbiayalayanan.setVisibility(View.VISIBLE);
                txthargalayanan.setVisibility(View.VISIBLE);
                txtgaris.setVisibility(View.VISIBLE);
                totalhargatxt.setVisibility(View.VISIBLE);
                btnpesansekarang.setVisibility(View.VISIBLE);
            } else {
                // Jika checkbox tidak dicentang, sembunyikan elemen
                imageView7.setVisibility(View.GONE);
                txtsubharga.setVisibility(View.GONE);
                txttotalsubharga.setVisibility(View.GONE);
                txtbiayalayanan.setVisibility(View.GONE);
                txthargalayanan.setVisibility(View.GONE);
                txtgaris.setVisibility(View.GONE);
                totalhargatxt.setVisibility(View.GONE);
                btnpesansekarang.setVisibility(View.GONE);
            }
        });

        // Inisialisasi TextView
        textkeranjang = findViewById(R.id.textkeranjang);

        // Mendapatkan item dari MainActivity (misalnya melalui Intent)
        DetailProduk detailProduk = new DetailProduk();
        ArrayList<String> keranjang = detailProduk.getKeranjang();

        // Menampilkan item keranjang dalam TextView
        textkeranjang.setText("Keranjang:\n" + String.join("\n", keranjang));

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
        // Fungsi untuk tombol back
        btnpesansekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Keranjang.this, DetailPemesananProduk.class);
                startActivity(intent);
            }
        });


        // Set nilai awal
        txtquantity.setText("1");

        // Listener untuk tombol Plus
        icplus_keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nilai dari EditText, tambah 1, dan update kembali
                int currentValue = Integer.parseInt(txtquantity.getText().toString());
                currentValue++;
                txtquantity.setText(String.valueOf(currentValue));
            }
        });

        // Listener untuk tombol Minus
        icminus_keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nilai dari EditText, kurangi 1 jika nilainya lebih dari 1, lalu update kembali
                int currentValue = Integer.parseInt(txtquantity.getText().toString());
                if (currentValue > 1) { // Cegah nilai kurang dari 1
                    currentValue--;
                    txtquantity.setText(String.valueOf(currentValue));
                }
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