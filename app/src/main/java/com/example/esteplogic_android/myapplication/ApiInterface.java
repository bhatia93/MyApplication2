package com.example.esteplogic_android.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("hotshel")
    Call<Movie> getMovies();
}