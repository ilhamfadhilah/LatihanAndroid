package com.example.latihanandroid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.latihanandroid.Adapter.sekolahAdapter;
import com.example.latihanandroid.R;
import com.example.latihanandroid.helper.DBHandler;
import com.example.latihanandroid.model.sekolah;

import java.util.List;

public class tambahitemsekolah extends AppCompatActivity {

    private EditText et_nama;
    private EditText et_alamat;
    private Button button_tambahdata;

    private DBHandler dbHandler;
    private sekolahAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahitemsekolah);
        dbHandler = new DBHandler(this);
        initComponents();
    }

    private void initComponents() {
        et_nama = findViewById(R.id.et_nama);
        et_alamat = findViewById(R.id.et_alamatsekolah);
        button_tambahdata = findViewById(R.id.button_tambahdata);

        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiForm();
            }
        });
    }
    // FUNGSI INI UNTUK MEMVALIDASI FORM JIKA ADA YANG KOSONG ATAU TIDAK
    // LALU DILANJUT UNTUK MENJALANKAN PERINTAH SELANJUTNYA
    private void validasiForm(){
        String form_nama = et_nama.getText().toString();
        String form_alamat = et_alamat.getText().toString();

        if (form_nama.isEmpty()){
            et_nama.setError("Isi nama Sekolah dulu");
            et_nama.requestFocus();
        } if (form_alamat.isEmpty()){
            et_alamat.setError("Isi Alamat Sekolah dulu");
            et_alamat.requestFocus();
        } else {
            dbHandler.tambaHSekolah(new sekolah(form_nama, form_alamat));
            List<sekolah> sekolahList = dbHandler.getSemuaSekolah();
            adapter = new sekolahAdapter(sekolahList);
            adapter.notifyDataSetChanged();

            Toast.makeText(tambahitemsekolah.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
        }
    }
}
