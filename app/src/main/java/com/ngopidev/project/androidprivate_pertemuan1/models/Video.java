package com.ngopidev.project.androidprivate_pertemuan1.models;

import com.google.gson.annotations.SerializedName;

/**
 * created by Irfan Assidiq on 2019-07-22
 * email : assidiq.irfan@gmail.com
 **/
public class Video {

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String titles;

    @SerializedName("subtitle")
    String subtitle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
