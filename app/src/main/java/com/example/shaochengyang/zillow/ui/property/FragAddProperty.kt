package com.example.shaochengyang.zillow.ui

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shaochengyang.zillow.R
import com.example.shaochengyang.zillow.data.model.PropertyItem
import com.example.shaochengyang.zillow.ui.property.PropertyActivity
import kotlinx.android.synthetic.main.frag_add_property.*
import kotlinx.android.synthetic.main.frag_add_property.view.*

class FragAddProperty: Fragment() {

    companion object {

        fun newInstance(): FragAddProperty {
            return FragAddProperty()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup,
                              savedInstanceState: Bundle?): View {

        var v = inflater.inflate(R.layout.frag_add_property, container, false)
        v.button_add.setOnClickListener {
            var propertyItem = PropertyItem(editText_country.text.toString(),editText_price.text.toString(),"",
                    "Tenant", "",  editText_mortgage.text.toString(),  "3", editText_state.text.toString(),
                    editText_lat.text.toString(), editText_address.text.toString(),editText_city.text.toString(), editText_long.text.toString())
            (activity as PropertyActivity).addProperty(propertyItem)
        }

        return v
    }


}