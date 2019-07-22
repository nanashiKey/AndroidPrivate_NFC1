package com.ngopidev.project.androidprivate_pertemuan1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ngopidev.project.androidprivate_pertemuan1.R;
import com.ngopidev.project.androidprivate_pertemuan1.models.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Irfan Assidiq on 2019-07-22
 * email : assidiq.irfan@gmail.com
 **/
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    private Context ctx;
    private List<Video> listVideo;
    public VideoAdapter(Context ctx, List<Video> listVideo){
        this.ctx = ctx;
        this.listVideo = listVideo;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_view_list, viewGroup, false);
        VideoViewHolder vv = new VideoViewHolder(v);
        return vv;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {
        Video video = listVideo.get(i);
        videoViewHolder.tv_title.setText(video.getTitles());
        videoViewHolder.tv_subtitle.setText(video.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return listVideo.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title, tv_subtitle;
        ImageView img_click;
        public VideoViewHolder(View itemview){
            super(itemview);
            tv_title = itemview.findViewById(R.id.tv_title);
            tv_subtitle = itemview.findViewById(R.id.tv_subtitle);
            img_click = itemview.findViewById(R.id.img_click);
        }
    }
}
