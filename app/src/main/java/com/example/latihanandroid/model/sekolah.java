package com.example.latihanandroid.model;

public class sekolah {
    private int id_sekolah;
    private String nama_sekolah;
    private String alamat_sekolah;

    public sekolah() {
    }

    public sekolah(int id_sekolah, String nama_sekolah, String alamat_sekolah) {
        this.id_sekolah = id_sekolah;
        this.nama_sekolah = nama_sekolah;
        this.alamat_sekolah = alamat_sekolah;
    }

    public sekolah(String string, String string1) {

    }

    public int getId_sekolah() {
        return id_sekolah;
    }

    public void setId_sekolah(int id_sekolah) {
        this.id_sekolah = id_sekolah;
    }

    public String getNama_sekolah() {
        return nama_sekolah;
    }

    public void setNama_sekolah(String nama_sekolah) {
        this.nama_sekolah = nama_sekolah;
    }

    public String getAlamat_sekolah() {
        return alamat_sekolah;
    }

    public void setAlamat_sekolah(String alamat_sekolah) {
        this.alamat_sekolah = alamat_sekolah;
    }
}
