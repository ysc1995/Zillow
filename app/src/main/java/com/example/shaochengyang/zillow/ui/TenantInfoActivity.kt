package com.example.shaochengyang.zillow.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.shaochengyang.zillow.R
import com.example.shaochengyang.zillow.data.model.PropertyItem
import com.example.shaochengyang.zillow.data.model.PropertyItemAdapter
import com.example.shaochengyang.zillow.data.model.TenantItemAdapter
import com.example.shaochengyang.zillow.data.model.TenantsItem
import com.example.shaochengyang.zillow.databinding.ActivityTenantInfoBinding
import com.example.shaochengyang.zillow.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_property.*
import kotlinx.android.synthetic.main.activity_tenant_info.*

class TenantInfoActivity : AppCompatActivity() {

    var viewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenant_info)

        val binding: ActivityTenantInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_tenant_info)
        binding.viewmodel = viewModel

        val adapter = TenantItemAdapter(object : TenantItemAdapter.MyListener {
            override fun onItemClicked(tenantsItem: TenantsItem) {

            }
        }, object : TenantItemAdapter.MyListener {
            override fun onItemClicked(tenantsItem: TenantsItem) {
                Log.d("MyTag", "Remove")
                //viewModel.removeProperty(myProperty.id!!)
            }
        })
        recycler_tenant.adapter = adapter
        recycler_tenant.layoutManager = LinearLayoutManager(this)

        viewModel.initListTenant("3")

    }
}
