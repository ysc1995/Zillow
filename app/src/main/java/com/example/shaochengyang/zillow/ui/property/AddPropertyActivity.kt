package com.example.shaochengyang.zillow.ui.property

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.shaochengyang.zillow.R
import com.example.shaochengyang.zillow.ui.MoreActivity

class AddPropertyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_property)

        setSupportActionBar(findViewById<View>(R.id.toolbar_map) as Toolbar)


    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.property_icon -> {
                val i_property = Intent(this@AddPropertyActivity, PropertyActivity::class.java)
                startActivity(i_property)
            }
            R.id.more_icon -> {
                val i = Intent(this@AddPropertyActivity, MoreActivity::class.java)
                startActivity(i)
            }

        }

        return true
    }
}
