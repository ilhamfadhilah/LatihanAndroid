package com.example.latihanandroid.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.latihanandroid.R;
import com.example.latihanandroid.helper.DatabaseHelper;
import com.example.latihanandroid.helper.DatabaseHelper2;
import com.example.latihanandroid.model.PesertaModel;

import java.util.ArrayList;
import java.util.List;

public class List_activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<PesertaModel> list = new ArrayList<>();
    DatabaseHelper2 dbhelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity);
        dbhelp = new DatabaseHelper2(this);
        recyclerView = (RecyclerView)findViewById(R.id.recylerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    protected void onResume() {
        super.onResume();
        list = dbhelp.getAll();
        adapter = new ListAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder>{
        Context context;
        List<PesertaModel> list;

        public ListAdapter(Context context, List<PesertaModel> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
            return new ListHolder(v);
        }

        @Override
        public void onBindViewHolder(ListHolder holder, int position) {
            final PesertaModel model = list.get(position);
            holder.nama.setText(model.getNama());
            holder.alamat.setText(model.getAlamat());
            holder.update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(List_activity.this, UpdateActivity.class);
                    intent.putExtra("ID", model.getId());
                    startActivity(intent);
                }
            });
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Yakin Menghapus Data?");
                    builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dbhelp.deleteData(model.getId());
                            dialogInterface.dismiss();
                            notifyDataSetChanged();
                        }
                    });
                    builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ListHolder extends RecyclerView.ViewHolder{
            TextView nama, alamat;
            ImageButton update, delete;
            public ListHolder(View itemView) {
                super(itemView);
                nama = (TextView)itemView.findViewById(R.id.txtNama);
                alamat = (TextView)itemView.findViewById(R.id.txtAlamat);
                update = (ImageButton)itemView.findViewById(R.id.btnUpdate);
                delete = (ImageButton)itemView.findViewById(R.id.btnDelete);
            }
        }
    }

}
