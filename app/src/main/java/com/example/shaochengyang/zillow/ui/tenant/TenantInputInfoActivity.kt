package com.example.shaochengyang.zillow.ui.tenant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.shaochengyang.zillow.R

class TenantInputInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenant_input_info)

        var price = intent.getStringExtra("price")
        var address = intent.getStringExtra("address")
        var city = intent.getStringExtra("city")
        var state = intent.getStringExtra("state")
        var userid = intent.getStringExtra("userid")


    }
}
