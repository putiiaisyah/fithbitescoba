package com.example.coba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Keranjang extends AppCompatActivity {
    private ImageButton btnBack, icplus_keranjang, icminus_keranjang;
    private EditText editText_quantity;
    private int productQuantity = 1; // Jumlah produk awal
    private TextView texthargakeranjang, textkeranjang, txtquantity;// TextView untuk harga


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
