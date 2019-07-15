package com.ngopidev.project.androidprivate_pertemuan1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ngopidev.project.androidprivate_pertemuan1.helpers.SampleBookHelper;

import java.util.ArrayList;

/**
 * created by Irfan Assidiq on 2019-07-15
 * email : assidiq.irfan@gmail.com
 **/
public class MainSqlite extends AppCompatActivity {
    ListView lv_forsqlite;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_for_sqlite);
        lv_forsqlite = findViewById(R.id.lv_forsqlite);

        SampleBookHelper bookHelper = new SampleBookHelper(this);
        SQLiteDatabase db = bookHelper.getWritableDatabase();

        String[] projection  = {"id", "title"};
        Cursor c = db.query("book_entries", projection, null, null, null, null, null);

        ArrayList<String> data = new ArrayList<>();
        c.moveToFirst();
        while (!c.isAfterLast()){
            String title = c.getString(c.getColumnIndex("title"));
            data.add(title);
            c.moveToNext();
        }

        if(data.isEmpty()){
            data.add("NO BOOK ENTRIES, PLEASE ADD");
        }

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lv_forsqlite.setAdapter(aa);
    }
}
