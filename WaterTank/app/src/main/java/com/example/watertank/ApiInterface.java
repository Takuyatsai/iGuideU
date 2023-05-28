package com.example.watertank;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("temp.php")
    Call<List<Growth>> getGrowthInfo();
}
