package com.example.shaochengyang.zillow.data.network

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import  com.example.shaochengyang.zillow.viewmodel.ViewModel

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
                            for(item in result.property!!){
                                viewModel.updateList(item)
                            }


                        },
                        { error -> Log.d("thistag",error.message)}
                )
    }
}