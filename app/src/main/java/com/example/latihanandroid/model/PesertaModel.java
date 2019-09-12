package com.example.latihanandroid.model;

public class PesertaModel {
    int id;
    String nama;
    String alamat;

    public PesertaModel(int id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }
}
