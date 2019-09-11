package com.example.latihanandroid.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latihanandroid.R;
import com.example.latihanandroid.activity.MainActivity;
import com.example.latihanandroid.activity.lihatSekolah;
import com.example.latihanandroid.activity.tambahSekolah;
import com.example.latihanandroid.helper.DBHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class SekolahFragment extends Fragment{
    private Button button_tambahdata;
    private Button button_lihatdata;
    private Button button_hapusdata;
    private DBHandler dbHandler;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sekolah_fragment, container, false);

        dbHandler = new DBHandler(getActivity());

        FragmentManager fm = getFragmentManager()

//if you added fragment via layout xml
        SekolahFragment fragment = (SekolahFragment) fm.findFragmentById(R.id.activity_sekolah_fragment);
        fragment.initComponents();

        return view;


    }





    // fungsi onClick component
 /*
    public void initComponents(View view){
        button_tambahdata =  view.findViewById(R.id.button_tambahdata);
        button_lihatdata =  view.findViewById(R.id.button_lihatdata);
        button_hapusdata =  view.findViewById(R.id.button_hapusdata);

        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), tambahSekolah.class));
            }
        });

        button_lihatdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), lihatSekolah.class));
            }
        });

        button_hapusdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.hapusSemuaDataSekolah();
                Toast.makeText(getActivity(), "Berhasil Menghapus Semua Data Sekolah", Toast.LENGTH_SHORT).show();
            }
        });
    } */
}
