package com.example.latihanandroid.model;

public class item {
    int id, prioritas;
    public String nama;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(int prioritas) {
        this.prioritas = prioritas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public item(int prioritas, String nama) {
        this.prioritas = prioritas;
        this.nama = nama;
    }

    public item(int id, int prioritas, String nama) {
        this.id = id;
        this.prioritas = prioritas;
        this.nama = nama;
    }

    /**
     * supaya bisa melakukan perintah Item item = new item();
     * item.setName("Nyoblos Presiden");
     * item.setPrioritas("2");
     */
    public item() {
    }
}
