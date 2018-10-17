package com.example.shaochengyang.zillow.data

import android.util.Log
import com.example.shaochengyang.zillow.data.model.PropertyItem
import com.example.shaochengyang.zillow.data.network.NetworkHelper
import com.example.shaochengyang.zillow.viewmodel.ViewModel
class DataManager :IDataManager {

    companion object {
        val NetworkHelper : NetworkHelper = NetworkHelper()
    }
    override fun getPropertyList(i: Int, s: String, viewModel: ViewModel) {
        Log.d("MyTag","datamanager")
        NetworkHelper.getPropertyList(i,s, viewModel)
    }

    override fun addProperty(propertyItem: PropertyItem, viewModel: ViewModel) {
        NetworkHelper.addProperty(propertyItem, viewModel)
    }

    override fun removeProperty(propertyid: String, viewModel: ViewModel) {
        NetworkHelper.removeProperty(propertyid, viewModel)
    }
    override fun getTenantList(id: String, viewModel: ViewModel) {
        NetworkHelper.getTenantList(id, viewModel)
    }

    override fun getAllPropertyInfo(listener : IDataManager.onAllPropertyInfoListener) {
        NetworkHelper.getAllPropertyInfo(listener)
    }



}