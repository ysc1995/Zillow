package com.example.shaochengyang.zillow.viewmodel

import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v4.content.ContextCompat.startActivity
import com.example.shaochengyang.zillow.BR
import com.example.shaochengyang.zillow.data.DataManager
import com.example.shaochengyang.zillow.data.IDataManager
import com.example.shaochengyang.zillow.data.model.AllPropertyItem


import com.example.shaochengyang.zillow.data.model.PropertyItem
import com.example.shaochengyang.zillow.map.MapFragActivity
import com.example.shaochengyang.zillow.map.MapFragment
import com.example.shaochengyang.zillow.ui.PropertyActivity

class ViewModel : BaseObservable() {

    @get:Bindable
    var myAllPropList: MutableList<AllPropertyItem> = mutableListOf()
        set(value) {
            field = value
            notifyPropertyChanged(BR.myAllPropList)
        }

    @get: Bindable
    var mylist: MutableList<PropertyItem> = mutableListOf()
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

    fun initList(id: Int) {
        DataManager.getPropertyList(id, "landlord", this)
    }

    fun updateList(myProperty: PropertyItem) {
        mylist.add(myProperty)
        idx_change = 0
//        DataManager.addProperty(myProperty, this)
//
//        var add = myProperty?.propertyaddress
//        Log.d("MyTag", "hi "+add)
    }

    fun addList(myProperty: PropertyItem) {
        DataManager.addProperty(myProperty, this)
        DataManager.getPropertyList(50, "landlord", this)
    }

    fun removeProperty(id: String) {

        DataManager.removeProperty(id, this)
        idx_change = 0
    }

    fun refreshList() {
        mylist = mutableListOf()
        DataManager.getPropertyList(50, "landlord", this)
    }

    /*fun getALLPropertyInfo() {
        DataManager.getAllPropertyInfo(this);
    }*/


    /*fun updateAllList(list: MutableList<AllPropertyItem>) {


        *//*for (i in list) {
            if (!i.propertylatitude.equals("") && !i.propertylongitude.equals("")) {

                mapFragment.setLocation(i.propertylatitude, i.propertylongitude, i.propertypurchaseprice)
            }
        }*//*
    }
*/
}