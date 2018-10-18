package com.example.shaochengyang.zillow.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.shaochengyang.zillow.R
import com.example.shaochengyang.zillow.ui.chat.SignInActivity
import kotlinx.android.synthetic.main.activity_tech.*

class TechActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tech)

        image_cog.setOnClickListener {
            var intent = Intent(this@TechActivity, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}
