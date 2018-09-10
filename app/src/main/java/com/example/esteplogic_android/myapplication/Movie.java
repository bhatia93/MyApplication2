package com.example.esteplogic_android.myapplication;


import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class Movie
{
    @SerializedName("salary")
    private String title;

    @SerializedName("registered")
    private String imageUrl;

    public Movie(String title, String imageUrl)
    {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title) {
        Log.d("title","RESPONSE ==="+title);

        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}