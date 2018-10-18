package com.example.shaochengyang.zillow.ui.tenant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.data.Set
import com.anychart.enums.Anchor
import com.anychart.enums.MarkerType
import com.anychart.enums.TooltipPositionMode
import com.anychart.graphics.vector.Stroke
import com.example.shaochengyang.zillow.R
import kotlinx.android.synthetic.main.activity_market.*
import java.util.ArrayList

class MarketActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market)

        val cartesian = AnyChart.line()

        cartesian.animation(true)

        cartesian.padding(10.0, 20.0, 5.0, 20.0)

        cartesian.crosshair().enabled(true)
        cartesian.crosshair()
                .yLabel(true)
                // TODO ystroke
                .yStroke(null as Stroke?, null, null, null as String?, null as String?)

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT)

        cartesian.title("Trend of Housing Price of Top Cities in US")

        cartesian.yAxis(0).title("Price Inflated (%)")
        cartesian.xAxis(0).labels().padding(5.0, 5.0, 5.0, 5.0)

        val seriesData = ArrayList<DataEntry>()

        seriesData.add(CustomDataEntry("2000", 10.1, 7.0, 3.5))
        seriesData.add(CustomDataEntry("2001", 15.6, 7.9, 8.0))
        seriesData.add(CustomDataEntry("2002", 13.4, 8.0, 5.0))
        seriesData.add(CustomDataEntry("2003", 18.0, 12.3, 8.3))
        seriesData.add(CustomDataEntry("2004", 13.2, 15.7, 6.2))
        seriesData.add(CustomDataEntry("2005", 16.0, 18.0, 7.4))
        seriesData.add(CustomDataEntry("2006", 16.2, 15.1, 5.2))
        seriesData.add(CustomDataEntry("2007", 10.1, 11.3, 3.9))
        seriesData.add(CustomDataEntry("2008", 4.3, 3.2, 1.2))
        seriesData.add(CustomDataEntry("2009", 6.4, 5.7, 2.7))
        seriesData.add(CustomDataEntry("2010", 11.5, 6.9, 2.2))
        seriesData.add(CustomDataEntry("2011", 13.5, 8.1, 1.2))
        seriesData.add(CustomDataEntry("2012", 14.8, 10.5, 2.4))
        seriesData.add(CustomDataEntry("2013", 20.6, 13.1, 5.3))
        seriesData.add(CustomDataEntry("2014", 28.1, 17.9, 8.9))
        seriesData.add(CustomDataEntry("2015", 27.0, 22.9, 6.1))
        seriesData.add(CustomDataEntry("2016", 30.6, 27.3, 4.5))
        seriesData.add(CustomDataEntry("2017", 35.1, 33.7, 8.2))
        seriesData.add(CustomDataEntry("2018", 39.7, 36.6, 10))


        val set = Set.instantiate()
        set.data(seriesData)
        val series1Mapping = set.mapAs("{ x: 'x', value: 'value' }")
        val series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }")
        val series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }")

        val series1 = cartesian.line(series1Mapping)
        series1.name("NY")
        series1.hovered().markers().enabled(true)
        series1.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4.0)
        series1.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5.0)
                .offsetY(5.0)

        val series2 = cartesian.line(series2Mapping)
        series2.name("San Francisco")
        series2.hovered().markers().enabled(true)
        series2.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4.0)
        series2.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5.0)
                .offsetY(5.0)

        val series3 = cartesian.line(series3Mapping)
        series3.name("St Charles")
        series3.hovered().markers().enabled(true)
        series3.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4.0)
        series3.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5.0)
                .offsetY(5.0)

        cartesian.legend().enabled(true)
        cartesian.legend().fontSize(13.0)
        cartesian.legend().padding(0.0, 0.0, 10.0, 0.0)

        any_chart_view.setChart(cartesian)
    }

    private inner class CustomDataEntry internal constructor(x: String, value: Number, value2: Number, value3: Number) : ValueDataEntry(x, value) {

        init {
            setValue("value2", value2)
            setValue("value3", value3)
        }

    }
}
