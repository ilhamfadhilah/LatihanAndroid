package com.example.latihanandroid.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihanandroid.R;
import com.example.latihanandroid.model.sekolah;

import java.util.ArrayList;
import java.util.List;

public class sekolahAdapter extends RecyclerView.Adapter<sekolahAdapter.sekolahViewHolder> {

    private List<sekolah> sekolahList = new ArrayList<>();

    public sekolahAdapter(List<sekolah> sekolahList){
        this.sekolahList = sekolahList;
    }
    @Override
    public sekolahAdapter.sekolahViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sekolah, parent, false);
        sekolahViewHolder sekolahViewHolder = new sekolahViewHolder(view);
        return sekolahViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull sekolahAdapter.sekolahViewHolder holder, int position) {
        holder.txt_resultalamat.setText(sekolahList.get(position).getAlamat_sekolah());
        holder.txt_resultnama.setText(sekolahList.get(position).getNama_sekolah());
    }

    @Override
    public int getItemCount() {
        return sekolahList.size();
    }

    public static class sekolahViewHolder extends RecyclerView.ViewHolder {
        TextView txt_resultnama;
        TextView txt_resultalamat;

        public sekolahViewHolder(View itemView){
            super(itemView);

            txt_resultnama = itemView.findViewById(R.id.txt_resultnama_sekolah);
            txt_resultalamat = itemView.findViewById(R.id.txt_result_alamat);
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
