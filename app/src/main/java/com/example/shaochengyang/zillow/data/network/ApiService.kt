package com.example.shaochengyang.zillow.data.network

import com.example.shaochengyang.zillow.data.model.Property

import io.reactivex.Observable


import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {

        val BASE_URL:String = "http://rjtmobile.com/aamir/property-mgmt/"

        fun create(): ApiService {

            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }

    @GET("property.php")
    fun getPropertyListInfo(@Query("userid") userid: Int,
                            @Query("usertype") usertype: String): Observable<Property>



}
