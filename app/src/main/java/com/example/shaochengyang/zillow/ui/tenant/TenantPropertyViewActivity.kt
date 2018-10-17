package com.example.shaochengyang.zillow.ui.tenant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.enums.Anchor
import com.anychart.enums.HoverMode
import com.anychart.enums.Position
import com.anychart.enums.TooltipPositionMode
import com.example.shaochengyang.zillow.R
import com.example.shaochengyang.zillow.data.IDataManager
import com.example.shaochengyang.zillow.data.model.AllPropertyItem
import com.example.shaochengyang.zillow.map.MapFragActivity
import com.example.shaochengyang.zillow.ui.MoreActivity
import com.example.shaochengyang.zillow.ui.property.PropertyActivity
import com.example.shaochengyang.zillow.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_tenant_property_view.*
import java.util.ArrayList

class TenantPropertyViewActivity : AppCompatActivity() {

    var viewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenant_property_view)

        setSupportActionBar(findViewById<View>(R.id.toolbar_map) as Toolbar)

        showPriceChart()

        /*val list = intent.getParcelableArrayExtra("list")
        val count = intent.getStringExtra("count")
        val propertyItemList = ArrayList<AllPropertyItem>()
        for (i in list.indices) {

            propertyItemList.add(list[i] as AllPropertyItem)
        }*/


        var price = intent.getStringExtra("price")
        var address = intent.getStringExtra("address")
        var city = intent.getStringExtra("city")
        var state = intent.getStringExtra("state")
        var country = intent.getStringExtra("country")
        var userid = intent.getStringExtra("userid")
        var lati = intent.getStringExtra("lati")
        var longi = intent.getStringExtra("longi")
        var mortgage = intent.getStringExtra("mortgage")
        var id = intent.getStringExtra("id")



        tv_address.text = address + ","
        tv_address2.text = city + ", " + state + ", " + country
        tv_payment.text = "Est.Refi.Payment: $" + price + "/mo"
        tv_mortage.text = mortgage

        Img_map_marker.setOnClickListener {
            val i = Intent(this@TenantPropertyViewActivity, PropertyMapActivity::class.java)
            i.putExtra("lati", lati)
            i.putExtra("long", longi)
            i.putExtra("price", price)
            startActivity(i)
        }

        button_contactOwner.setOnClickListener{

        }


        button_rentthis.setOnClickListener {
            val i = Intent(this@TenantPropertyViewActivity, TenantInputInfoActivity::class.java)
            i.putExtra("price",price)
            i.putExtra("address",address)
            i.putExtra("city",city)
            i.putExtra("state",state)
            i.putExtra("userid",userid)
            startActivity(i)

        }
    }




    fun showPriceChart() {
        var anyChartView: AnyChartView = findViewById(R.id.anyChartView)
        val cartesian = AnyChart.column()
        val data = ArrayList<DataEntry>()

        data.add(ValueDataEntry("2014", 650))
        data.add(ValueDataEntry("2015", 720))
        data.add(ValueDataEntry("2016", 830))
        data.add(ValueDataEntry("2017", 950))
        data.add(ValueDataEntry("2018", 1100))

        val column = cartesian.column(data)

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0.0)
                .offsetY(5.0)
                .format("\${%Value}{groupsSeparator: }")

        cartesian.animation(true)
        cartesian.title("Rental Price for Last 5 Years")

        cartesian.yScale().minimum(0.0)

        cartesian.yAxis(0).labels().format("\${%Value}{groupsSeparator: }")

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT)
        cartesian.interactivity().hoverMode(HoverMode.BY_X)

        cartesian.xAxis(0).title("Year")
        cartesian.yAxis(0).title("Price")

        anyChartView.setChart(cartesian)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.property_icon -> {
                val i_property = Intent(this@TenantPropertyViewActivity, PropertyActivity::class.java)
                startActivity(i_property)
            }
            R.id.more_icon -> {
                val i = Intent(this@TenantPropertyViewActivity, MoreActivity::class.java)
                startActivity(i)
            }

        }

        return true
    }
}
