package com.example.shaochengyang.zillow.data.network

import android.util.Log
import com.example.shaochengyang.zillow.data.model.PropertyItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.example.shaochengyang.zillow.viewmodel.ViewModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class NetworkHelper : INetworkHelper{

    var disposable : Disposable ?= null
    /*init {
        val apiService = ApiService.create()
    }*/
    val apiService by lazy { ApiService.create() }

    override fun getPropertyList(i: Int, s: String, viewModel: ViewModel) {
        disposable = apiService.getPropertyListInfo(i,s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {result -> //Log.d("thistag", result.property!![0].id)
                         //viewModel.updateList(result.property!![0])
                            viewModel.mylist = mutableListOf()
                            for(item in result.property!!){
                                viewModel.updateList(item)
                            }


                        },
                        { error -> Log.d("thistag",error.message)}
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
        var userid = ""+50
        var usertype = "landlord"

        //retrofit2.Call<String> call //call = apiService.addProperty(add, city, state, country, pro_status, price, mortgage, userid, usertype)
        var call = apiService.addProperty(add, city, state, country, pro_status, price, mortgage, userid, usertype)
        call . enqueue (object : retrofit2.Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d("MyTag", response.body()!!.toString())
                viewModel.refreshList()

            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("MyTag", t.toString())
                viewModel.refreshList()
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
}