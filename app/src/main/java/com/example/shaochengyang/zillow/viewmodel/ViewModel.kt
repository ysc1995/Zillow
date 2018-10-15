package com.example.shaochengyang.zillow.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.shaochengyang.zillow.BR
import com.example.shaochengyang.zillow.data.DataManager
import com.example.shaochengyang.zillow.data.IDataManager


import com.example.shaochengyang.zillow.data.model.PropertyItem

class ViewModel: BaseObservable() {

    @get: Bindable
    var propertylist :MutableList<PropertyItem> = mutableListOf()
        set(value) {
            field = value
            notifyPropertyChanged(BR.propertylist)
        }

    @get: Bindable
    var property_idx_change: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.property_idx_change)
        }

    var dataManager : IDataManager = DataManager()

    fun initList(){
          dataManager.getPropertyList(3,"landlord", this)
    }

    fun updateList(myProperty: PropertyItem){
        propertylist.add(myProperty)

        property_idx_change = 0

    }

}