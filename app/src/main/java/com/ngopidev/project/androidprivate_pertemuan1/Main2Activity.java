package com.ngopidev.project.androidprivate_pertemuan1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button btn_3 , btn_4 , btn_5, btn_6, btn_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);

        //pembuatan objek anonymous inner class untuk beberapa eksekusi
        View.OnClickListener btn_listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn_3 :{
                        Toast.makeText(Main2Activity.this, "Tombol 3", Toast.LENGTH_SHORT).show();
                    }break;
                    case R.id.btn_4 :{
                        Toast.makeText(Main2Activity.this, "Tombol 4", Toast.LENGTH_SHORT).show();
                    }break;
                    default:
                        Toast.makeText(Main2Activity.this, "button ter klik", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btn_3.setOnClickListener(btn_listener);
        btn_4.setOnClickListener(btn_listener);
        //pembuatan inner class untuk sekali eksekusi
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "Tombol 5", Toast.LENGTH_SHORT).show();
            }
        });

        //memberikan onclick terhadap btn_6 dan btn_7
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_6:{
                Toast.makeText(this, "Tombol Terpencet", Toast.LENGTH_SHORT).show();
            }break;
            case R.id.btn_7:{
                //kita akan melakukan pindah activity
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
                finish();
            }break;
            default:
                //do nothing
        }
    }
}
