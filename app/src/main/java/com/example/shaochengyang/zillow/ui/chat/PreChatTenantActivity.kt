package com.example.shaochengyang.zillow.ui.chat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.shaochengyang.zillow.R
import kotlinx.android.synthetic.main.activity_pre_chat_landlord.*
import kotlinx.android.synthetic.main.activity_pre_chat_tenant.*

class PreChatTenantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_chat_tenant)

        textView_tenant_header.text = "Dear Tenant,  \n\n" + "Which landlord do you want to chat with?"

        button_chat_tenant.setOnClickListener {
            var intent = Intent(this@PreChatTenantActivity, ChatActivity::class.java)
            intent.putExtra("landlord", editText_landlord_nm.text.toString())
            startActivity(intent)

        }
    }
}
