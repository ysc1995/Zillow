package com.example.shaochengyang.zillow.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.shaochengyang.zillow.R
import com.example.shaochengyang.zillow.data.DataManager
import com.example.shaochengyang.zillow.data.IDataManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val iDataManager: IDataManager = DataManager()
        iDataManager.getPropertyList(3,"landlord")

    }
}