package com.example.latihanandroid.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.latihanandroid.Adapter.sekolahitemadapter;
import com.example.latihanandroid.helper.DatabaseHelper;
import com.example.latihanandroid.model.item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import com.example.latihanandroid.R;

import java.util.ArrayList;
import java.util.List;

public class Recycler2 extends AppCompatActivity {

    RecyclerView recyclerView;
    sekolahitemadapter adapter;


    List<item> items = new ArrayList<>();

    DatabaseHelper db;

    protected void onResume(){
        super.onResume();
        items.clear(); // untuk menghapus data yang dilooping tapi sudah pernah di buat
        items.addAll(db.getALL());
        adapter = new sekolahitemadapter(this,items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Recycler2.this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.RecyclerView2);
        db = new DatabaseHelper(this);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recycler2.this, AddEditActivity.class);
                startActivity(intent);
            }
        });

    }

}
