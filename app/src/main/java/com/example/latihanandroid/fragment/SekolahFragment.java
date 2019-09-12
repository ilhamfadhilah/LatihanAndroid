package com.example.latihanandroid.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.latihanandroid.R;
import com.example.latihanandroid.activity.Recycler2;
import com.example.latihanandroid.activity.cobarecyclelagi;
import com.example.latihanandroid.activity.melihatsekolah;
import com.example.latihanandroid.activity.tambahitemsekolah;
import com.example.latihanandroid.helper.DBHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class SekolahFragment extends Fragment{

    private Button button_hapusdata;
    private Button button_datasekolah;
    private Button button_melihatsekolah;
    private Button button_Recyle2;
    private Button button_Recyle3;
    private DBHandler dbHandler;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sekolah_fragment, container, false);

        dbHandler = new DBHandler(getActivity());

       // FragmentManager fm = getFragmentManager();

//if you added fragment via layout xml
        initComponents(view);

        return view;


    }

    private void initComponents(View view) {

        button_datasekolah = view.findViewById(R.id.button_tambahdatasekolah);
        button_melihatsekolah = view.findViewById(R.id.button_melihat);
        button_Recyle2 = view.findViewById(R.id.button_RecyclerView2);
        button_Recyle3 = view.findViewById(R.id.button_RecyclerView3);
        button_hapusdata =  view.findViewById(R.id.button_hapusdata);




        button_datasekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), tambahitemsekolah.class));

            }
        });


        button_melihatsekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), melihatsekolah.class));

            }
        });

        button_Recyle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Recycler2.class));

            }
        });
        button_Recyle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), cobarecyclelagi.class));

            }
        });

        button_hapusdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.hapusSemuaDataSekolah();
                Toast.makeText(getActivity(), "Berhasil Menghapus Semua Data Sekolah", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
