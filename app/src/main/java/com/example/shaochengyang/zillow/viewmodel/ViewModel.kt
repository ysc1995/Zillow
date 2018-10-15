package com.example.shaochengyang.zillow.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.shaochengyang.zillow.BR


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

    fun initList(){

    }

    fun updateList(myProperty: PropertyItem){
        mylist.add(myProperty)

        idx_change = 0

    }

}