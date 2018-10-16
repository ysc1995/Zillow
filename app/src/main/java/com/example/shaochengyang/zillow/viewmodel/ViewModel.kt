package com.example.shaochengyang.zillow.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import com.example.shaochengyang.zillow.BR
import com.example.shaochengyang.zillow.data.DataManager
import com.example.shaochengyang.zillow.data.IDataManager


import com.example.shaochengyang.zillow.data.model.PropertyItem

class ViewModel: BaseObservable() {

    @get: Bindable
    var mylist :MutableList<PropertyItem> = mutableListOf()
        set(value) {
            field = value
            notifyPropertyChanged(BR.mylist)
        }

    @get: Bindable
    var idx_change: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.idx_change)
        }

    val DataManager: IDataManager = DataManager()

    fun initList(id: Int){
          DataManager.getPropertyList(id,"landlord", this)
    }

    fun updateList(myProperty: PropertyItem){
        mylist.add(myProperty)
        idx_change = 0
//        DataManager.addProperty(myProperty, this)
//
//        var add = myProperty?.propertyaddress
//        Log.d("MyTag", "hi "+add)
    }

    fun addList(myProperty: PropertyItem){
        DataManager.addProperty(myProperty, this)
        DataManager.getPropertyList(50,"landlord", this)
    }

    fun removeProperty(id: String){

        DataManager.removeProperty(id, this)
        idx_change = 0
    }

    fun refreshList(){
        mylist = mutableListOf()
        DataManager.getPropertyList(50,"landlord", this)
    }

}