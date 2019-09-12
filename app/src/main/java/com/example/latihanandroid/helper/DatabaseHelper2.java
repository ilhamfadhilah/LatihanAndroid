package com.example.latihanandroid.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.latihanandroid.model.PesertaModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper2 extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DBNAME = "db_peserta";
    private static final String TABLENAME = "peserta";

    private static String colID = "id";
    private static String colNama = "nama";
    private static String colAlamat = "alamat";

    public DatabaseHelper2(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLENAME + " (" +
                colID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + colNama + " TEXT," +
                colAlamat + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLENAME);
        onCreate(db);
    }

    public void insertData(String nama, String alamat){
        String insertData = "INSERT INTO "+ TABLENAME + " ("+ colNama +","+colAlamat+") VALUES ('"+nama +"', '"+alamat+"')";
        this.getWritableDatabase().execSQL(insertData);
    }

    public void updateData(int id, String nama, String alamat){
        String updateData = "UPDATE "+TABLENAME+ " SET "+ colNama + "= '"+nama +"', "+colAlamat + "= '"+alamat + "' WHERE "+colID +" ="+id;
        this.getWritableDatabase().execSQL(updateData);
    }

    public void deleteData(int id){
        String deleteData = "DELETE FROM "+TABLENAME +" WHERE id="+id;
        this.getWritableDatabase().execSQL(deleteData);
    }

    public PesertaModel getData(int id){
        PesertaModel model = null;
        String selectData = "SELECT * FROM "+TABLENAME + " WHERE id="+String.valueOf(id);
        Cursor data = this.getWritableDatabase().rawQuery(selectData, null);
        if(data.moveToFirst()){
            model = new PesertaModel(Integer.parseInt(data.getString(data.getColumnIndex(colID))),
                    data.getString(data.getColumnIndex(colNama)), data.getString(data.getColumnIndex(colAlamat)));
        }
        return model;
    }

    public List<PesertaModel> getAll(){
        List<PesertaModel> model = new ArrayList<>();
        String selectData = "SELECT * FROM "+TABLENAME;
        Cursor data = this.getWritableDatabase().rawQuery(selectData, null);
        if(data.moveToFirst()){
            do{
                model.add(new PesertaModel(Integer.parseInt(data.getString(data.getColumnIndex(colID))),
                        data.getString(data.getColumnIndex(colNama)), data.getString(data.getColumnIndex(colAlamat))));
            }while (data.moveToNext());
        }
        return model;
    }
}
