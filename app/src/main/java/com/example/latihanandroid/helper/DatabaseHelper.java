package com.example.latihanandroid.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.latihanandroid.model.item;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "todo";
    private final static  int DATABASE_VERSION = 1; // final adalah perintah untuk memastikan tidak merubah variable

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE todo (id INTEGER PRIMARY KEY, "+" name TEXT, prioritas INTEGER)");

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS todo");
        onCreate(db);
    }

    public long add(item Item){ // memerlukan sesuatu
        ContentValues values = new ContentValues();
        values.put("name", Item.getNama());
        values.put("prioritas",Item.getPrioritas());

        return getReadableDatabase()
                .insert("todo",null,values);
    }

    public List<item> getALL(){
        List<item> Items = new ArrayList<>();

        Cursor cursor = getReadableDatabase() // cursor adalah tipe data kusus yang bisa mengetahui informasi sebuah tabel
                .rawQuery("SELECT * FROM todo", null);

        if (cursor.moveToFirst()){
            do{
                //perulangan
                item Item = new item();
                Item.setId(cursor.getInt(0));
                Item.setNama(cursor.getString(1));
                Item.setPrioritas(cursor.getInt(2));
                Items.add(Item);
            }while (cursor.moveToNext()); // kita memamnggil tiap kolonya
        }
        return Items;
    }
    public long delete(item Item){
        return getReadableDatabase()
                .delete("todo",
                        "id=?",
                        new String[]{String.valueOf(Item.getId())});
    }

    public long update(item Item){
        ContentValues values = new ContentValues();
        values.put("name", Item.getNama());
        values.put("prioritas",Item.getPrioritas());

        return getWritableDatabase()
                .update(
                        "todo"
                        ,values,
                        "id=?",
                        new String[]{String.valueOf(Item.getId())}
                );
    }
}
