package com.example.shaochengyang.zillow.data.network

import com.example.shaochengyang.zillow.data.model.Property
import com.example.shaochengyang.zillow.data.model.TenantInfo
import io.reactivex.Observable
import retrofit2.Call


import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.PUT
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

    /*http://rjtmobile.com/aamir/
    property-mgmt/property.php?
    userid=3&
    usertype=landlord
     */
    @GET("property.php")
    fun getPropertyListInfo(@Query("userid") userid: String,
                            @Query("usertype") usertype: String): Observable<Property>

    //rjtmobile.com/aamir/property-mgmt/pro_mgt_add_pro.php?%20address=fla1234&city=Noida&state=UP&country=India
    // &pro_status=tenants&purchase_price=12000&mortage_info=no&userid=3&usertype=landlord&latitude=12.4565656&longitude=3.5656565
    @PUT("pro_mgt_add_pro.php")
    fun addProperty( @Query("address") address: String,
                     @Query("city") city: String,
                     @Query("state") state: String,
                     @Query("country") country: String,
                     @Query("pro_status") pro_status: String,
                     @Query("purchase_price") purchase_price:String,
                     @Query("mortage_info") mortage_info: String,
                     @Query("userid") userid: String,
                     @Query("usertype") usertype: String,
                     @Query("latitude")  latitude: String,
                     @Query("longitude")  longitude: String): Call<String>

    @GET("remove-property.php")
    fun removeProperty(@Query("propertyid") propertyid: Int): Observable<String>

    //http://rjtmobile.com/aamir/property-mgmt/pro_mgt_add_tenants.php?name=aam&email=aah@aah.com
    // &address=complte address&mobile=9876543210&propertyid=1&landlordid=3
    @GET("pro_mgt_add_tenants.php")
    fun addTenant( @Query("name") name: String,
                   @Query("email") email: String,
                   @Query("address")   address: String,
                   @Query("mobile")  mobile: String,
                   @Query("propertyid")  propertyid: String,
                   @Query("landlordid")  landlordid: String
    ): Observable<String>

    //http://rjtmobile.com/aamir/property-mgmt/pro_mgt_tenent_details.php?landlordid=3
    @GET("pro_mgt_tenent_details.php")
    fun getTenantList( @Query("landlordid")  landlordid: String): Observable<TenantInfo>



}
