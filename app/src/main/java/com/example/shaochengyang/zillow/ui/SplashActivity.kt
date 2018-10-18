package com.example.shaochengyang.zillow.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.shaochengyang.zillow.R
import com.example.shaochengyang.zillow.ui.chat.SignInActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var t1: Thread = Thread() {
            Thread.sleep(2500)

            var i: Intent = Intent(this@SplashActivity, SignInActivity::class.java)
            startActivity(i)
            finish()
        }

        t1.start()

    }
}
