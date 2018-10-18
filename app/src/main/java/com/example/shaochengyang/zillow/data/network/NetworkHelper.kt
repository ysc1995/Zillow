package com.example.shaochengyang.zillow.data.network

import android.util.Log
import com.example.shaochengyang.zillow.data.IDataManager
import com.example.shaochengyang.zillow.data.model.AllPropertyItem
import com.example.shaochengyang.zillow.data.model.PropertyItem
import com.example.shaochengyang.zillow.ui.tenant.TenantInputInfoActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.example.shaochengyang.zillow.viewmodel.ViewModel
import retrofit2.Call
import retrofit2.Response

class NetworkHelper : INetworkHelper {

    var disposable: Disposable? = null
    /*init {
        val apiService = ApiService.create()
    }*/
    val apiService by lazy { ApiService.create() }

    override fun addTenant(userName: String, userEmail: String, userAddress: String, userMobile: String, userid: String, propertyId: String, tenantInputInfoActivity: TenantInputInfoActivity) {
        var call = apiService.addTenantonServer(userName,userEmail,userAddress,userMobile,propertyId,userid)
        call . enqueue (object : retrofit2.Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {

                Log.d("MyTag","Success")
            }

            override fun onFailure(call: Call<String>, t: Throwable) {

                tenantInputInfoActivity.successfullyAdded()
                Log.d("MyTag","Fail")
            }
        })


    }


    override fun getAllPropertyInfo(listener : IDataManager.onAllPropertyInfoListener) {
        disposable = apiService.getAllPropertyInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            Log.d("thistag", result.property[0].id)
                            var allPropertyList: MutableList<AllPropertyItem> = mutableListOf()
                            for (item in result.property!!){
                                allPropertyList.add(item)
                            }
                            listener.passAllPropertyList(allPropertyList)



                        },
                        { error ->
                            Log.d("thistag", error.message)
                        }
                )
    }

    override fun getPropertyList(i: Int, s: String, viewModel: ViewModel) {
        Log.d("MyTag","network")
        disposable = apiService.getPropertyListInfo(i.toString(),s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {result ->
                            Log.d("MyTag", "hi")
                            Log.d("MyTag", result.property.toString())
                         //viewModel.updateList(result.property!![0])
                            viewModel.mylist = mutableListOf()
                            for(item in result.property!!){
                                viewModel.updateList(item!!)
                            }


                        },
                        { error -> Log.d("MyTag",error.message)}
                )
    }

    override fun addProperty(propertyItem: PropertyItem, viewModel: ViewModel) {

        var add  = propertyItem.propertyaddress!!
        var city = propertyItem.propertycity!!
        var state = propertyItem.propertystate!!
        var country = propertyItem.propertycountry!!
        var pro_status = propertyItem.propertystatus!!
        var price = propertyItem.propertypurchaseprice!!
        var mortgage = propertyItem.propertymortageinfo!!
        var userid = ""+3
        var usertype = "landlord"
        var lat = propertyItem.propertylatitude!!
        var long = propertyItem.propertylongitude!!

        //retrofit2.Call<String> call //call = apiService.addProperty(add, city, state, country, pro_status, price, mortgage, userid, usertype)
        var call = apiService.addProperty(add, city, state, country, pro_status, price, mortgage, userid, usertype, lat, long)
        call . enqueue (object : retrofit2.Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                viewModel.refreshList()
                Log.d("MyTag","Success")
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                viewModel.refreshList()
                Log.d("MyTag","Fail")
            }
        })

    }

    override fun removeProperty(propertyid: String, viewModel: ViewModel) {
        disposable = apiService. removeProperty(propertyid.toInt())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {result -> Log.d("thistag", "Success")
                          viewModel.refreshList()
                        },
                        { error -> Log.d("thistag",error.message)
                            viewModel.refreshList()
                        }
                )
    }

    override fun getTenantList(id: String, viewModel: ViewModel) {
        Log.d("MyTag", "Get Tenant")
        disposable = apiService.getTenantList(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {result ->
                            //Log.d("MyTag", "hi")
                            //Log.d("MyTag", result.tenants.toString())
                            viewModel.mylist_tenant = mutableListOf()
                            for(tenantItem in result.tenants!!){
                                //Log.d("MyTag", tenantItem.toString())
                                viewModel.updateListTenant(tenantItem!!)
                            }

                        },
                        { error -> Log.d("MyTag",error.message)}
                )
    }

}