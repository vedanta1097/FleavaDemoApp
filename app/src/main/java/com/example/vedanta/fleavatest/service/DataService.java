package com.example.vedanta.fleavatest.service;

import com.example.vedanta.fleavatest.model.Login;
import com.example.vedanta.fleavatest.model.SpiritResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataService {

    @FormUrlEncoded
    @POST("login")
    Call<Login> signIn(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("movie/popular")
    Call<SpiritResult> getSpirit(
            @Query("api_key") String api_key,
            @Query("page") int page
    );
}
