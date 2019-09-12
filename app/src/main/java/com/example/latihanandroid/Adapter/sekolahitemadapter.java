package com.example.latihanandroid.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihanandroid.R;
import com.example.latihanandroid.activity.AddEditActivity;
import com.example.latihanandroid.activity.Recycler2;
import com.example.latihanandroid.helper.DatabaseHelper;
import com.example.latihanandroid.model.item;

import java.util.List;

public class sekolahitemadapter extends RecyclerView.Adapter<sekolahitemadapter.sekolahviewHolder> {

Context context;
List<item>items;
DatabaseHelper db;

public sekolahitemadapter(Context context, List<item> items){
    this.context = context;
    this.items = items;
}

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public sekolahitemadapter.sekolahviewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.item,viewGroup,false);
        return new sekolahviewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull sekolahitemadapter.sekolahviewHolder sekolahviewHolder, final int i) {
        final item Item = items.get(i);

        db = new DatabaseHelper(context);
        sekolahviewHolder.name.setText(Item.nama);

        sekolahviewHolder.done.setOnClickListener(new View.OnClickListener() { // tombol done nya yang di klik
            @Override
            public void onClick(View view) {
                db.delete(Item);
                items.clear();
                items.addAll(db.getALL());
                notifyDataSetChanged();
            }
        });
        sekolahviewHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddEditActivity.class);
                intent.putExtra("ID",Item.getId());
                intent.putExtra("NAME",Item.getNama());
                intent.putExtra("PRIORITAS",Item.getPrioritas());
                context.startActivity(intent);
            }
        });

    }

    class sekolahviewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView edit,done;

        public sekolahviewHolder(View itemview){
            super(itemview);

            name = itemview.findViewById(R.id.tvtodo);
            edit = itemview.findViewById(R.id.ivedit);
            done = itemview.findViewById(R.id.ivdone);


        }
    }

}
