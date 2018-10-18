package com.example.shaochengyang.zillow.ui.chat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.shaochengyang.zillow.R
import kotlinx.android.synthetic.main.activity_pre_chat_landlord.*

class PreChatLandlordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_chat_landlord)

        textView_landlord_header.text = "Dear Landlord,  \n\n" + "Which tenant do you want to chat with?"

        button_chat_landlord.setOnClickListener {
            var intent = Intent(this@PreChatLandlordActivity, ChatActivity::class.java)
            intent.putExtra("tenant", editText_tenant_nm.text.toString())
            startActivity(intent)
        }
    }
}
