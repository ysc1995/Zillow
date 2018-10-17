package com.example.shaochengyang.zillow.data.network
import com.example.shaochengyang.zillow.data.IDataManager
import com.example.shaochengyang.zillow.data.model.PropertyItem
import com.example.shaochengyang.zillow.viewmodel.ViewModel

interface INetworkHelper {
    abstract fun getPropertyList(i: Int, s: String, viewModel: ViewModel)
    fun addProperty(propertyItem: PropertyItem, viewModel: ViewModel)
    fun removeProperty(propertyid: String, viewModel: ViewModel)
    fun getTenantList(id: String, viewModel: ViewModel)

    fun getAllPropertyInfo(listener : IDataManager.onAllPropertyInfoListener) {

    }
}