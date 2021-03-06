package com.example.shaochengyang.zillow.ui.property



import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.shaochengyang.zillow.BuildConfig
import com.example.shaochengyang.zillow.R
import com.example.shaochengyang.zillow.data.model.PropertyItem
import com.example.shaochengyang.zillow.data.model.PropertyItemAdapter
import com.example.shaochengyang.zillow.databinding.ActivityPropertyBinding
import com.example.shaochengyang.zillow.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_property.*
import com.example.shaochengyang.zillow.data.model.PropertyItemAdapter.MyListener
import com.example.shaochengyang.zillow.ui.FragAddProperty
import com.example.shaochengyang.zillow.ui.TenantInfoActivity
import com.example.shaochengyang.zillow.ui.chat.ChatActivity
import com.example.shaochengyang.zillow.ui.chat.PreChatLandlordActivity
import com.example.shaochengyang.zillow.ui.chat.PreChatTenantActivity

class PropertyActivity : AppCompatActivity() , iPropertyActivity {

    var viewModel = ViewModel()
    var  fragaddproperty = FragAddProperty.newInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property)
        val binding: ActivityPropertyBinding = DataBindingUtil.setContentView(this, R.layout.activity_property)

        setSupportActionBar(toolbar_property)
        getSupportActionBar()?.setTitle(null)

        val adapter = PropertyItemAdapter(object : MyListener{
            override fun onItemClicked(myProperty: PropertyItem) {
                Log.d("MyTag", myProperty.id +" "+ myProperty.propertyaddress+" "+myProperty.propertycity)
                var intent = Intent(this@PropertyActivity, TenantInfoActivity::class.java)
                startActivity(intent)
            }
        }, object :MyListener{
            override fun onItemClicked(myProperty: PropertyItem) {
                Log.d("MyTag", "Remove")
                viewModel.removeProperty(myProperty.id!!)
            }
        })
        recycler_property.adapter = adapter
        recycler_property.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?

        binding.viewmodel = viewModel

        var id = 0


        viewModel.initList(3)

        //Log.d("MyFlavor", BuildConfig.FLAVOR)

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
            R.id.info_icon->{
                var intent = Intent(this@PropertyActivity, TenantInfoActivity::class.java)
                startActivity(intent)
            }
            R.id.chat_icon->{
                Log.d("MyFlavor",BuildConfig.FLAVOR)
                if(BuildConfig.FLAVOR.equals("landlord")) {
                    var intent = Intent(this@PropertyActivity, PreChatLandlordActivity::class.java)
                    startActivity(intent)
                }
                else{
                    var intent = Intent(this@PropertyActivity, PreChatTenantActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        return true
    }

    override fun addProperty(propertyItem: PropertyItem) {
        //Log.d("MyTag","hi")
        viewModel.addList(propertyItem)
    }
}