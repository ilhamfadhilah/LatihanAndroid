package com.example.latihanandroid.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.latihanandroid.model.sekolah;

import java.util.ArrayList;
import java.util.List;

//created by ilham 9/11/2019

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_namasekolah"; // NAMA DATABASE
    private static final String TABLE_SEKOLAH = "table_sekolah"; // NAMA TABEL
    private static final String COLUMN_ID = "id"; // NAMA KOLOM ID Sekolah
    private static final String COLUMN_NAMA_SEKOLAH = "nama"; // NAMA KOLOM NAMA sekolah
    private static final String COLUMN_ALAMAT = "alamat"; // NAMA KOLOM alamat sekolah

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    // FUNGSI UNTUK MEMBUAT DATABASENYA
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_SEKOLAH + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAMA_SEKOLAH + " TEXT,"
                + COLUMN_ALAMAT + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    // FUNGSI UNTUK MENGECEK DATABASE ADA ATAU TIDAK.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEKOLAH);
        onCreate(db);
    }

    // FUNGSI UNTUK TAMBAH DATA SEKOLAH
    public void tambaHSekolah(sekolah Sekolah){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA_SEKOLAH, Sekolah.getNama_sekolah());
        values.put(COLUMN_ALAMAT, Sekolah.getAlamat_sekolah());

        db.insert(TABLE_SEKOLAH, null, values);
        db.close();
    }

    // FUNGSI UNTUK AMBIL 1 DATA MAHASISWA
    public sekolah getSekolah(int id_sekolah) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SEKOLAH, new String[]{COLUMN_ID, COLUMN_NAMA_SEKOLAH, COLUMN_ALAMAT},
                COLUMN_ID + "=?", new String[]{String.valueOf(id_sekolah)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        sekolah sekolaH = new sekolah(cursor.getString(1), cursor.getString(2));
        return sekolaH;

    }
        // FUNGSI UNTUK AMBIL SEMUA DATA SEKOLAH
        public List<sekolah> getSemuaSekolah(){
            List<sekolah> sekolahList = new ArrayList<>();
            String selectQuery = "SELECT * FROM " + TABLE_SEKOLAH;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()){
                do {
                    sekolah sekolaH = new sekolah(cursor.getString(1), cursor.getString(2));
                    sekolahList.add(sekolaH);
                } while (cursor.moveToNext());
            }
            return sekolahList;
        }
    // FUNGSI MENGHITUNG ADA BEBERAPA DATA
    public int getSekolahCount(){
        String countQuery = "SELECT * FROM " + TABLE_SEKOLAH;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // FUNGSI UPDATE DATA SEKOLAH
    public int updateDataSekolah(sekolah sekolaH) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA_SEKOLAH, sekolaH.getNama_sekolah());
        values.put(COLUMN_ALAMAT, sekolaH.getAlamat_sekolah());
        return db.update(TABLE_SEKOLAH, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(sekolaH.getId_sekolah())});
    }

    // FUNGSI HAPUS DATA 1 SEKOLAH
    public void hapusDataSekolah(sekolah sekolaH) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SEKOLAH, COLUMN_ID + " = ?",
                new String[]{String.valueOf(sekolaH.getId_sekolah())});
        db.close();
    }

    // FUNGSI UNTUK MENGHAPUS SEMUA DATA MAHASISWA
    public void hapusSemuaDataSekolah(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_SEKOLAH);
    }

}
