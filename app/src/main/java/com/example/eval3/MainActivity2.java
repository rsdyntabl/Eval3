package com.example.eval3;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private int selectedId;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Mengambil data yang dikirim melalui Intent
        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String stb = intent.getStringExtra("stb");
        String angkatan = intent.getStringExtra("angkatan");
        String prodi = intent.getStringExtra("prodi");

        boolean minat1 = intent.getBooleanExtra("minat1", false);
        boolean minat2 = intent.getBooleanExtra("minat2", false);
        boolean minat3 = intent.getBooleanExtra("minat3", false);
        boolean minat4 = intent.getBooleanExtra("minat4", false);
        boolean minat5 = intent.getBooleanExtra("minat5", false);
        boolean minat6 = intent.getBooleanExtra("minat6", false);

        // Menampilkan data di TextView atau komponen lainnya
        TextView txtNama = findViewById(R.id.txtNama1);
        TextView txtStb = findViewById(R.id.txtStb);
        TextView txtAngkatan = findViewById(R.id.txtAngkatan);
        TextView txtProdi = findViewById(R.id.txtProdi1);
        TextView txtMinat = findViewById(R.id.txtMinatt);

        // Menampilkan data dengan rapih
        txtNama.setText(String.format("Nama:   %s", nama));
        txtStb.setText(String.format("Stambuk:   %s", stb));
        txtAngkatan.setText(String.format("Angkatan:   %s", angkatan));
        txtProdi.setText(String.format("Program Studi:   %s", prodi));

        // Menampilkan minat yang dipilih dengan rapih
        StringBuilder minatText = new StringBuilder("Minat:\n");
        if (minat1) {
            minatText.append("- Badan Eksekutif Mahasiswa\n");
        }
        if (minat2) {
            minatText.append("- Penulisan Karya Ilmiah\n");
        }
        if (minat3) {
            minatText.append("- Kewirausahaan\n");
        }
        if (minat4) {
            minatText.append("- Kesenian\n");
        }
        if (minat5) {
            minatText.append("- Jurnalistik\n");
        }
        if (minat6) {
            minatText.append("- Olahraga\n");
        }
        txtMinat.setText(minatText.toString());
    }
}
