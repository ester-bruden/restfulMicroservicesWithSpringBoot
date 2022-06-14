package com.myplantdiary.enterprise.dao;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    // singleton dessign pattern. One static method thar returns an instance of Retrofit
    //we create a static member variable of this class
    private static Retrofit retrofit;
    private static String BASE_URL = "https://www.plantplaces.com";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            // builder pattern
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //will return the only instance either because it created it or it has it from before
        return retrofit;
    }
}
