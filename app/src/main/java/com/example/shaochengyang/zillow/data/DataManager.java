package com.example.shaochengyang.zillow.data;

import android.content.Context;

import com.example.shaochengyang.zillow.data.network.INetworkHelper;
import com.example.shaochengyang.zillow.data.network.NetworkHelper;

public class DataManager implements IDataManager{

    INetworkHelper iNetworkHelper;

    public DataManager(Context context) {
        this.iNetworkHelper = new NetworkHelper();
    }

    @Override
    public void getPropertyList(onPropertyListListerner onPropertyListListerner, int i, String landlord) {
        iNetworkHelper.getPropertyList(onPropertyListListerner, 3, "landlord");
    }
}
