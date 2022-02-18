package com.example.card.network;

import com.example.card.model.ImageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApi {
    @GET("/api?key=25007027-7418deb977c638792f4bfb99f")
    Call<ImageResponse> getImageBySearch(@Query("q") String keyWord);
}
