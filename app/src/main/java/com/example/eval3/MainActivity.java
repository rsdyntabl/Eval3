package com.example.eval3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    private EditText txtNama, txtStb;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen-komponen
        txtNama = findViewById(R.id.txtNama);
        txtStb = findViewById(R.id.txtStb);
        spinner = findViewById(R.id.spinner);
        radioGroup = findViewById(R.id.radioGroup);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);

        // Inisialisasi Spinner dan isi dengan data angkatan 2018-2023
        String[] angkatanList = {"-Pilih Angkatan", "2018", "2019", "2020", "2021", "2022", "2023"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, angkatanList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button tampilkanRingkasan = findViewById(R.id.button);
        tampilkanRingkasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengambil nilai dari EditText, Spinner, dan CheckBox
                String nama = txtNama.getText().toString();
                String stb = txtStb.getText().toString();

                // Mengambil nilai dari Spinner
                String angkatan = spinner.getSelectedItem().toString();

                // Mengambil nilai dari RadioButton yang dipilih
                int selectedId = radioGroup.getCheckedRadioButtonId();

                boolean minat1 = checkBox1.isChecked();

                boolean minat2 = checkBox2.isChecked();
                boolean minat3 = checkBox3.isChecked();
                boolean minat4 = checkBox4.isChecked();
                boolean minat5 = checkBox5.isChecked();
                boolean minat6 = checkBox6.isChecked();

                // Membuat Intent untuk membuka MainActivity2 dan mengirim data
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                System.out.println("ini select radio button : " + selectedId);
                intent.putExtra("nama", nama);
                intent.putExtra("stb", stb);
                intent.putExtra("prodi", selectedId == R.id.radioButton1 ? "Teknik Infomatika" : "Sistem Informasi");
                intent.putExtra("angkatan", angkatan);
                intent.putExtra("minat1", minat1);
                intent.putExtra("minat2", minat2);
                intent.putExtra("minat3", minat3);
                intent.putExtra("minat4", minat4);
                intent.putExtra("minat5", minat5);
                intent.putExtra("minat6", minat6);

                startActivity(intent);
            }
        });
    }
}