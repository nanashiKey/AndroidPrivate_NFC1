package com.ngopidev.project.androidprivate_pertemuan1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ngopidev.project.androidprivate_pertemuan1.helpers.PrefsHelper;


/**
 * created by Irfan Assidiq on 2019-07-08
 * email : assidiq.irfan@gmail.com
 **/
public class LoginActivity extends AppCompatActivity {

    EditText et_nama, et_email, et_password;
    Button btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        et_nama = findViewById(R.id.et_nama);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        boolean cekStatusLogin = PrefsHelper.sharedInstance(this).getStatusLogin();

        if(cekStatusLogin){
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, email, password;
                nama = et_nama.getText().toString();
                email = et_email.getText().toString();
                password = et_password.getText().toString();
                if(!nama.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                    if(nama.equals("irfan") && email.equals("irfan@gmail.com") && password.equals("irfan123")){
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        PrefsHelper.sharedInstance(LoginActivity.this).setStatusLogin(true);
                        PrefsHelper.sharedInstance(LoginActivity.this).setNamaUser(nama);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "User Tidak Tersedia", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
