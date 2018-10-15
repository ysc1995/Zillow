package com.example.shaochengyang.zillow.data.network


interface INetworkHelper {
    abstract fun getPropertyList(i: Int, s: String, viewModel: com.example.shaochengyang.zillow.viewmodel.ViewModel)
}