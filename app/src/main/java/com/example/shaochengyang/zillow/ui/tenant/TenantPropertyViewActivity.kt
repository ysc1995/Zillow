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
import com.example.shaochengyang.zillow.data.model.AllPropertyItem
import com.example.shaochengyang.zillow.ui.MoreActivity
import com.example.shaochengyang.zillow.ui.property.PropertyActivity
import kotlinx.android.synthetic.main.activity_tenant_property_view.*
import java.util.ArrayList

class TenantPropertyViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenant_property_view)

        setSupportActionBar(findViewById<View>(R.id.toolbar_map) as Toolbar)

        showPriceChart()

        val list = intent.getParcelableArrayExtra("list")
        val count = intent.getStringExtra("count")
        val propertyItemList = ArrayList<AllPropertyItem>()
        for (i in list.indices) {

            propertyItemList.add(list[i] as AllPropertyItem)
        }


        var lati = propertyItemList[Integer.parseInt(count)].propertylatitude
        var long = propertyItemList[Integer.parseInt(count)].propertylongitude
        var item = propertyItemList[Integer.parseInt(count)]

        tv_address.text = propertyItemList[Integer.parseInt(count)].propertyaddress + ","
        tv_address2.text = propertyItemList[Integer.parseInt(count)].propertycity + "," + item.propertystate + ","+ item.propertycountry
        tv_payment.text = "Est.Refi.Payment: $"+item.propertypurchaseprice+"/mo"


        Img_map_marker.setOnClickListener {
            val i = Intent(this@TenantPropertyViewActivity, PropertyMapActivity::class.java)
        i.putExtra("lati",lati)
        i.putExtra("long",long)
        startActivity(i)
    }

        button_rentthis.setOnClickListener{
            addTenant();

        }
    }

    private fun addTenant() {
        //TODO add api
        //http://rjtmobile.com/aamir/property-mgmt/pro_mgt_add_tenants.php?
        // name=aam&email=aah@aah.com&address=complte address&mobile=9876543210&propertyid=1&landlordid=3
    }


    fun showPriceChart(){
        var anyChartView : AnyChartView = findViewById(R.id.anyChartView)
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
