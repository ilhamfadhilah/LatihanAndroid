package com.example.latihanandroid.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latihanandroid.Adapter.sekolahAdapter;
import com.example.latihanandroid.R;
import com.example.latihanandroid.helper.DBHandler;
import com.example.latihanandroid.helper.RecyclerItemClickListener;
import com.example.latihanandroid.model.sekolah;

import java.util.ArrayList;
import java.util.List;

public class melihatsekolah extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private sekolahAdapter adapter;
    private DBHandler dbHandler;
    private TextView txt_resultadapter;
    private List<sekolah> sekolahList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_melihatsekolah);
        initComponents();
        initRecyclerView();
        cekDataRecyclerView();
    }
    // FUNGSI INI UNTUK MENG-INIT RECYLERVIEW BESERTA ADAPTERNYA
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.recyclerview_sekolah2);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(melihatsekolah.this);
        recyclerView.setLayoutManager(layoutManager);

        dbHandler = new DBHandler(melihatsekolah.this);
        sekolahList = dbHandler.getSemuaSekolah();
        adapter = new sekolahAdapter(sekolahList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void initComponents(){
        txt_resultadapter = findViewById(R.id.txt_resultadapter2);
    }
    // FUNGSI INI UNTUK MENGECEK APAKAH ADA DATA DI DALEM RECYCLERVIEW ATAU TIDAK
    private void cekDataRecyclerView(){
        if (adapter.getItemCount()==0){
            txt_resultadapter.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else{
            txt_resultadapter.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            //TODO Handle item click
                            sekolah sekolaH = sekolahList.get(position);
                            String nama = sekolaH.getNama_sekolah();

                            Toast.makeText(melihatsekolah.this, "klik di "+ nama, Toast.LENGTH_SHORT).show();
                        }
                    })
            );

        }
    }
}
