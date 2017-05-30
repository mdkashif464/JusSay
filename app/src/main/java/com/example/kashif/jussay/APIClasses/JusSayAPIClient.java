package com.example.kashif.jussay.APIClasses;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by kashif on 28/5/17.
 */

public class JusSayAPIClient {

    private static final String BASE_URL = "http://webandrioz.com/shwet/";

    public static JusSayAPI getClient(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(JusSayAPI.class);
    }
}
