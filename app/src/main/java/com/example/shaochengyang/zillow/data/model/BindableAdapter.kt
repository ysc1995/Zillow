package com.example.shaochengyang.zillow.data.model

interface BindableAdapter<T> {
    fun updateList(items: List<T>)
    fun idxChanged(positions: Int)
}