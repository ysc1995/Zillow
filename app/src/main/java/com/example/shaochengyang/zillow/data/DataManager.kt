package com.example.shaochengyang.zillow.data

import com.example.shaochengyang.zillow.data.network.NetworkHelper
import com.example.shaochengyang.zillow.viewmodel.ViewModel
class DataManager:IDataManager {
    companion object {
        val iNetworkHelper : NetworkHelper = NetworkHelper()
    }
    override fun getPropertyList(i: Int, s: String, viewModel: ViewModel) {
        iNetworkHelper.getPropertyList(i,s, viewModel)
    }


}