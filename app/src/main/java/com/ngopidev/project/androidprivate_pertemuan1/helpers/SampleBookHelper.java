package com.ngopidev.project.androidprivate_pertemuan1.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * created by Irfan Assidiq on 2019-07-15
 * email : assidiq.irfan@gmail.com
 **/
public class SampleBookHelper extends SQLiteOpenHelper {

    final static String namadb = "buku_";
    final static int dbversion = 1;

    public SampleBookHelper(Context context){
        super(context, namadb, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE book_entries(id integer PRIMARY KEY AUTOINCREMENT, title text, author text);";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            String drop = "DROP TABLE IF EXISTS book_entries";
            sqLiteDatabase.execSQL(drop);
            onCreate(sqLiteDatabase);
    }
}
