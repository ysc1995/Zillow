package com.example.shaochengyang.zillow.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    static Retrofit retrofit;

    //http://rjtmobile.com/aamir/property-mgmt/property.php?userid=3&usertype=landlord
    final static String BASE_URL ="http://rjtmobile.com/aamir/property-mgmt/";


    public static Retrofit getRetrofitInstance(){

        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
