package com.example.shaochengyang.zillow.ui

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.shaochengyang.zillow.R
import com.example.shaochengyang.zillow.data.model.PropertyItem
import com.example.shaochengyang.zillow.data.model.PropertyItemAdapter
import com.example.shaochengyang.zillow.databinding.ActivityPropertyBinding
import com.example.shaochengyang.zillow.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_property.*

class PropertyActivity : AppCompatActivity() , iPropertyActivity{

    var viewModel = ViewModel()
    var  fragaddproperty = FragAddProperty.newInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property)
        val binding: ActivityPropertyBinding = DataBindingUtil.setContentView(this, R.layout.activity_property)

        setSupportActionBar(toolbar_property)
        val adapter = PropertyItemAdapter()
        recycler_property.adapter = adapter
        recycler_property.layoutManager = LinearLayoutManager(this)

        binding.viewmodel = viewModel

        viewModel.initList(49)



    }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         getMenuInflater().inflate(R.menu.toolbar_property, menu)
         return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            R.id.add_icon -> {
                //fragaddproperty = FragAddProperty.newInstance()
                //fragaddproperty.view.setBackgroundColor(Color.WHITE)
                fragmentManager
                        .beginTransaction()
                        .add(R.id.property_layout,  fragaddproperty)
                        .commit()
            }
            R.id.done_icon->{
                fragmentManager
                        .beginTransaction()
                        .remove(fragaddproperty)
                        .commit()
            }
        }

        return true
    }

    override fun addProperty(propertyItem: PropertyItem) {
        //Log.d("MyTag","hi")
        viewModel.addList(propertyItem)
    }
}