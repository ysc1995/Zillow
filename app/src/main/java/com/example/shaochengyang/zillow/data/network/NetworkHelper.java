package com.example.shaochengyang.zillow.data.network;

import android.util.Log;

import com.example.shaochengyang.zillow.data.IDataManager;
import com.example.shaochengyang.zillow.data.model.Property;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkHelper implements INetworkHelper {
    private static final String TAG = "NetworkHelper";
    ApiService apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
    @Override
    public void getPropertyList(IDataManager.onPropertyListListerner onPropertyListListerner, int i, String landlord) {
        Call<Property> call = apiService.getPropertyListInfo(i,landlord);
        call.enqueue(new Callback<Property>() {
            @Override
            public void onResponse(Call<Property> call, Response<Property> response) {
                Log.d(TAG, "onResponse: "+response.body().getProperty().get(0).getId());
            }

            @Override
            public void onFailure(Call<Property> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
