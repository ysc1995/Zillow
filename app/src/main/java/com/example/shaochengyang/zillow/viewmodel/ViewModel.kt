package com.example.shaochengyang.zillow.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import com.example.shaochengyang.zillow.BR
import com.example.shaochengyang.zillow.data.DataManager
import com.example.shaochengyang.zillow.data.IDataManager
import com.example.shaochengyang.zillow.data.model.PropertyItem
import com.example.shaochengyang.zillow.data.model.TenantInfo
import com.example.shaochengyang.zillow.data.model.TenantsItem

class ViewModel: BaseObservable() {

    @get: Bindable
    var mylist :MutableList<PropertyItem> = mutableListOf()
        set(value) {
            field = value
            notifyPropertyChanged(BR.mylist)
        }

    @get: Bindable
    var mylist_tenant: MutableList<TenantsItem> = mutableListOf()
    set(value) {
        field = value
        notifyPropertyChanged(BR.mylist_tenant)
    }

    @get: Bindable
    var idx_change: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.idx_change)
        }


    val DataManager: IDataManager = DataManager()

    fun initList(id: Int){
        Log.d("MyTag","initlist")
        DataManager.getPropertyList(id,"landlord", this)
    }

    fun initListTenant(id: String){
        Log.d("MyTag","initlist")
        DataManager.getTenantList(id,  this)
        Log.d("MyTag","initlist2")

    }

    fun updateList(myProperty: PropertyItem){
        mylist.add(myProperty)
        idx_change = 0
//        DataManager.addProperty(myProperty, this)

    }

    fun updateListTenant(tenantsItem: TenantsItem){
        Log.d("MyTag", tenantsItem.id+ " "+tenantsItem.tenantaddress)
        mylist_tenant.add(tenantsItem)
        idx_change = 0
//        DataManager.addProperty(myProperty, this)

    }

    fun addList(myProperty: PropertyItem){
        DataManager.addProperty(myProperty, this)
        DataManager.getPropertyList(3,"landlord", this)
    }

    fun removeProperty(id: String){

        DataManager.removeProperty(id, this)
        idx_change = 0
    }

    fun refreshList(){
        mylist = mutableListOf()
        DataManager.getPropertyList(3,"landlord", this)
    }

}