package com.example.shaochengyang.zillow.data.network

import android.util.Log
import com.example.shaochengyang.zillow.data.IDataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NetworkHelper : INetworkHelper{
    var disposable : Disposable ?= null
    /*init {
        val apiService = ApiService.create()
    }*/
    val apiService by lazy { ApiService.create() }

    override fun getPropertyList(i: Int, s: String) {
        disposable = apiService.getPropertyListInfo(i,s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {result -> Log.d("thistag", result.property!![0].id)},
                        { error -> Log.d("thistag",error.message)}
                )
    }
}