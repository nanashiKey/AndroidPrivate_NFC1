package com.ngopidev.project.androidprivate_pertemuan1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ngopidev.project.androidprivate_pertemuan1.adapters.VideoAdapter;
import com.ngopidev.project.androidprivate_pertemuan1.helpers.ApiOnly;
import com.ngopidev.project.androidprivate_pertemuan1.helpers.Const;
import com.ngopidev.project.androidprivate_pertemuan1.models.Video;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * created by Irfan Assidiq on 2019-07-22
 * email : assidiq.irfan@gmail.com
 **/
public class ListVideoActivity extends AppCompatActivity {

    RecyclerView rcView;
    VideoAdapter adapterV;
    List<Video> listVideo;
    Retrofit retrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datashow_layout);

        rcView = findViewById(R.id.rcView);
        rcView.setLayoutManager(new LinearLayoutManager(this));
        rcView.setHasFixedSize(true);

        retrofit = new Retrofit.Builder()
                .baseUrl(Const.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiOnly apiOnly = retrofit.create(ApiOnly.class);
        Call<List<Video>> result = apiOnly.getVideo();
        result.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                listVideo = response.body();
                adapterV = new VideoAdapter(ListVideoActivity.this, listVideo);
                rcView.setAdapter(adapterV);
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Toast.makeText(ListVideoActivity.this, "data gagal diambil", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
