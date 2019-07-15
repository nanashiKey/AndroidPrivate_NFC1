package com.ngopidev.project.androidprivate_pertemuan1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * created by Irfan Assidiq on 2019-07-15
 * email : assidiq.irfan@gmail.com
 **/
public class SampleList extends AppCompatActivity {

    ListView lv_sample;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_sample);
        lv_sample = findViewById(R.id.lv_sample);

        List<String> data = new ArrayList<>();
        data.add("sample data 1");
        data.add("sample data 2");
        data.add("sample data 3");
        data.add("sample data 4");
        data.add("sample data 5");
        data.add("sample data 6");
        data.add("sample data 7");
        data.add("sample data 8");
        data.add("sample data 9");
        data.add("sample data 10");

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lv_sample.setAdapter(aa);

        lv_sample.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SampleList.this, "sample list view", Toast.LENGTH_SHORT).show();
            }
        });
        // untuk mendaftarkan context menu kedalam list
        registerForContextMenu(lv_sample);
    }

    //untuk memanggil context menu kedalam activity
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menusample, menu);
    }

    //untuk memberikan onclick kedalam masing" context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.contextSample1 :{
                Toast.makeText(this, "sample context 1", Toast.LENGTH_SHORT).show();
            }break;
            case R.id.contextSample2 :{
                Toast.makeText(this, "sample context 2", Toast.LENGTH_SHORT).show();
            }break;
            default:
                //
        }
        return super.onContextItemSelected(item);
    }
}
