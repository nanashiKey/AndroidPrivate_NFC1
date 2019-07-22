package com.ngopidev.project.androidprivate_pertemuan1.helpers;

import com.ngopidev.project.androidprivate_pertemuan1.models.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * created by Irfan Assidiq on 2019-07-22
 * email : assidiq.irfan@gmail.com
 **/
public interface ApiOnly {
    @GET("akses.php")
    Call<List<Video>> getVideo();
}
