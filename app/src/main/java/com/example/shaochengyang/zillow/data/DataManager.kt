package com.example.shaochengyang.zillow.data

import com.example.shaochengyang.zillow.data.network.NetworkHelper

class DataManager:IDataManager {
    companion object {
        val iNetworkHelper : NetworkHelper = NetworkHelper()
    }
    override fun getPropertyList(i: Int, s: String) {
        iNetworkHelper.getPropertyList(i,s)
    }


}