package com.example.vedanta.fleavatest.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.vedanta.fleavatest.util.Constant.LOGIN_URL;

public class RestManager {

    private DataService mDataService;

    public DataService getDataService(String url) {
        if (mDataService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mDataService = retrofit.create(DataService.class);
        }
        return mDataService;
    }
}
