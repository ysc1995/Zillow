package com.example.shaochengyang.zillow.data.network;

import com.example.shaochengyang.zillow.data.IDataManager;

public interface INetworkHelper {
    void getPropertyList(IDataManager.onPropertyListListerner onPropertyListListerner, int i, String landlord);
}
