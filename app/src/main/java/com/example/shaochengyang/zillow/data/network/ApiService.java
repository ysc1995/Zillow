package com.example.shaochengyang.zillow.data.network;

import com.example.shaochengyang.zillow.data.model.Property;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    //http://rjtmobile.com/aamir/property-mgmt/property.php?userid=3&usertype=landlord
    @GET("property.php")
    Call<Property> getPropertyListInfo(@Query("userid") int userid,
                                       @Query("usertype") String usertype);

}
