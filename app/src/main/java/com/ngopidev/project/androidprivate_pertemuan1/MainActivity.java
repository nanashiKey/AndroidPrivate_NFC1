package com.ngopidev.project.androidprivate_pertemuan1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.ngopidev.project.androidprivate_pertemuan1.helpers.PrefsHelper;

public class MainActivity extends AppCompatActivity {

    TextView textView; // deklarasi textview
    Button btn_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nama = PrefsHelper.sharedInstance(this).getNamaUser();

        textView = findViewById(R.id.tv_1); //lakukan inisialisasi terhadap textview
        btn_2 = findViewById(R.id.btn_2);
        textView.setText(nama);
    }

    public void pencet(View v){
        switch (v.getId()){
            case R.id.btn_1 :{
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                PrefsHelper.sharedInstance(MainActivity.this).setStatusLogin(false);
                startActivity(i);
                finish();
            }break;
            case R.id.btn_2 :{
//                Toast.makeText(this, "Tombol 2", Toast.LENGTH_SHORT).show();
//                textView.setText("Tombol 2");
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btn_2);
                popupMenu.getMenuInflater().inflate(R.menu.pop_upsample, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.popsample1:{
                                Toast.makeText(MainActivity.this, "pop up sample 1", Toast.LENGTH_SHORT).show();
                            }break;
                            case  R.id.popsample2:{
                                Toast.makeText(MainActivity.this, "pop up sample 2", Toast.LENGTH_SHORT).show();
                            }break;
                            default:
                                //
                        }
                        return true;
                    }
                });
            }break;
            default:
                Toast.makeText(this, "Hai ini Tombol Pencet", Toast.LENGTH_SHORT).show();
                Log.e("TAG_ERROR", "berhasil");
                Log.i("TAG_INFO", "berhasil");
                Log.w("TAG_WARN", "Berhasil");

        }

    }

    //mendaftarkan options menu ke dalam aplikasi
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opt_menu, menu);
        return true;
    }

    //untuk memanggil option menu yang di klik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting :{
                Toast.makeText(this, "Hai Saya Setting", Toast.LENGTH_SHORT).show();
            }break;
            case R.id.sample :{
//                Toast.makeText(this, "Sai Saya Sample Option menu", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, SampleList.class);
                startActivity(i);
            }break;
            default:
                //
        }
        return super.onOptionsItemSelected(item);
    }
}
