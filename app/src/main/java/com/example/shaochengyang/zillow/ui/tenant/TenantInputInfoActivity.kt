package com.example.shaochengyang.zillow.ui.tenant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shaochengyang.zillow.R
import com.example.shaochengyang.zillow.map.TestActivity
import com.example.shaochengyang.zillow.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_tenant_input_info.*
import java.util.regex.Pattern

class TenantInputInfoActivity : AppCompatActivity() {
    var viewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenant_input_info)


        var price = intent.getStringExtra("price")
        var address = intent.getStringExtra("address")
        var city = intent.getStringExtra("city")
        var state = intent.getStringExtra("state")
        var userid = intent.getStringExtra("userid")
        var propertyId = intent.getStringExtra("id")
        var country = intent.getStringExtra("country")
        var mortgage = intent.getStringExtra("mortgage")

        tv_address_input.text = address +", "+ city+", "+state+", "+country
        if(!mortgage.equals("no")) {
            tv_mortage_input.text = mortgage
        }
        tv_price_input.text = price




        bt_submitRent.setOnClickListener {
            var checkflag : Boolean = false
            var userName = et_name.text.toString()
            var userEmail = et_email.text.toString()
            var userAddress = et_address.text.toString()
            var userMobile = et_mobile.text.toString()
            if(!Pattern.matches("^[0-9]{3,16}$",userMobile)){
                Toast.makeText(this, "Invalidate Phone Number Input" , Toast.LENGTH_SHORT).show()
                checkflag = true
            }
            /*if(!Pattern.matches("^[0-9]{3,16}$",userEmail)){
                Toast.makeText(this, "Invalidate Phone Number Input" , Toast.LENGTH_SHORT).show()
                checkflag = true
            }*/
            if(checkflag ==false) {
                viewModel.addTenant(userName, userEmail, userAddress, userMobile, userid, propertyId, this)
            }
        }




    }

    fun successfullyAdded() {
        Toast.makeText(this, "Congregations! Successfully Rented the house!", Toast.LENGTH_LONG).show()
        val i = Intent(this@TenantInputInfoActivity, TestActivity::class.java)
        startActivity(i)
    }
}
