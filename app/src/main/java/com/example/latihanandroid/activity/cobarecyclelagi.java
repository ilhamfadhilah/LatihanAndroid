package com.example.latihanandroid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.latihanandroid.R;
import com.example.latihanandroid.helper.DatabaseHelper;
import com.example.latihanandroid.helper.DatabaseHelper2;

public class cobarecyclelagi extends AppCompatActivity {
    EditText etNama, etAlamat;
    Button btnSimpan, btnView;
    DatabaseHelper2 dbhelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobarecyclelagi);
        etNama = (EditText)findViewById(R.id.etNama);
        etAlamat = (EditText)findViewById(R.id.etAlamat);
        btnSimpan = (Button)findViewById(R.id.btnSimpan);
        btnView = (Button)findViewById(R.id.btnViewdata);
        btnSimpan.setOnClickListener(listener);
        btnView.setOnClickListener(listener);
        dbhelp = new DatabaseHelper2(this);
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnSimpan:
                    dbhelp.insertData(etNama.getText().toString(), etAlamat.getText().toString());
                    Toast.makeText(getApplicationContext(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
                    etNama.getText().clear();
                    etAlamat.getText().clear();
                    break;
                case R.id.btnViewdata:
                    startActivity(new Intent(cobarecyclelagi.this, ListActivity.class));
                    break;
            }
        }
    };
}
