package com.example.latihanandroid.activity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.latihanandroid.R;
import com.example.latihanandroid.helper.DatabaseHelper;
import com.example.latihanandroid.model.item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddEditActivity extends AppCompatActivity {

    EditText etName, etPriority;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DatabaseHelper(this);

        etName = findViewById(R.id.editKegiatan);
        etPriority = findViewById(R.id.editPrioritas);

        final int id = getIntent().getIntExtra("ID", 0);
        String name = getIntent().getStringExtra("NAME");
        int priority = getIntent().getIntExtra("PRIORITAS",0);

        if (id != 0){
            etName.setText(name);
            etPriority.setText(String.valueOf(priority));
        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item Item = new item();
                Item.setNama(etName.getText().toString());
                Item.setPrioritas(Integer.parseInt(etPriority.getText().toString()));
                if (id !=0){  // jika id ada maka akan menampilkan update
                    Item.setId(id); //
                    db.update(Item);
                    Toast.makeText(AddEditActivity.this, "Sudah Terupdate", Toast.LENGTH_SHORT).show();
                }else
                {  // jika idnya kosong maka menambah tabel
                    db.add(Item);
                    Toast.makeText(AddEditActivity.this, "Data Sudah Di Input", Toast.LENGTH_SHORT).show();
                }
                finish(); // berfungsi untuk menutup activity sama seperti memanggil onDestroy();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
