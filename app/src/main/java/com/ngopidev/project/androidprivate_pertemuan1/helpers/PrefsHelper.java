package com.ngopidev.project.androidprivate_pertemuan1.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * created by Irfan Assidiq on 2019-07-15
 * email : assidiq.irfan@gmail.com
 **/
//untuk membantu kita menyimpan value yg dibutuhkan oleh aplikasi
public class PrefsHelper {
    SharedPreferences prefs;
    Context ctx;
    private final String PREF_STATUS = "statusLogin";
    private final String PREF_NAMAUSER = "namauser";

    private static PrefsHelper instance;
    public static PrefsHelper sharedInstance(Context ctx){
        if(instance == null){
            instance = new PrefsHelper(ctx);
        }
        return instance;
    }

    private PrefsHelper(Context ctx){
        this.ctx = ctx;
        this.prefs = ctx.getSharedPreferences("LATIHANSHARED", Context.MODE_PRIVATE);
    }

    //method atau fungsi untuk menyimpan login status pada perangkat kita
    public void setStatusLogin(boolean status){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_STATUS, status);
        editor.apply();
    }

    //method atau fungsi untuk mengambil login status
    public boolean getStatusLogin(){
        return prefs.getBoolean(PREF_STATUS, false);
    }

    //method atau fungsi untuk menyimpan nama user yang melakukan login
    public void setNamaUser(String nama){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_NAMAUSER, nama);
        editor.apply();
    }

    //method untuk mengambil nama user
    public String getNamaUser(){
        return prefs.getString(PREF_NAMAUSER, "tanpanama");
    }
}
