package com.example.shaochengyang.zillow.data

import com.example.shaochengyang.zillow.data.model.AllPropertyItem
import com.example.shaochengyang.zillow.data.network.INetworkHelper

interface IDataManager : INetworkHelper {
    interface onAllPropertyInfoListener{
        fun passAllPropertyList(allPropertyList: MutableList<AllPropertyItem>)


    }
}