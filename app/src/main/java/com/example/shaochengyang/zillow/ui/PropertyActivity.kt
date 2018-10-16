package com.example.shaochengyang.zillow.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.shaochengyang.zillow.R
import com.example.shaochengyang.zillow.data.model.PropertyItemAdapter
import com.example.shaochengyang.zillow.databinding.ActivityPropertyBinding
import com.example.shaochengyang.zillow.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_property.*

class PropertyActivity : AppCompatActivity() {

    var viewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property)
        val binding: ActivityPropertyBinding = DataBindingUtil.setContentView(this, R.layout.activity_property)


        val adapter = PropertyItemAdapter()
        recycler_property.adapter = adapter
        recycler_property.layoutManager = LinearLayoutManager(this)

        binding.viewmodel = viewModel

        //viewModel.updateList()
        viewModel.initList()

//        val iDataManager: IDataManager = DataManager()
//        iDataManager.getPropertyList(3,"landlord", viewModel)


    }
}