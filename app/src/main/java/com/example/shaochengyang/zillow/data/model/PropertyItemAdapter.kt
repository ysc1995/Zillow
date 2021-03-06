package com.example.shaochengyang.zillow.data.model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shaochengyang.zillow.R
import kotlinx.android.synthetic.main.property_item_layout.view.*

class PropertyItemAdapter(var listener_info: MyListener, var listener_remove: MyListener) : RecyclerView.Adapter<PropertyItemAdapter.MyViewHolder>(), BindableAdapter<PropertyItem>{

    var mylist = emptyList<PropertyItem>()

    override fun updateList(newList: List<PropertyItem>){
        mylist = newList
        notifyDataSetChanged()
        //Log.d("MyTag","List Changed")
    }

    override fun idxChanged(idx: Int){
        notifyItemChanged(idx)
        //Log.d("MyTag","idx Changed")
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.property_item_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mylist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var property = mylist.get(position)
        holder.bind(property, listener_info, listener_remove)
    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(myProperty: PropertyItem, listener_info: MyListener, listener_remove: MyListener){
            itemView.textView_address.text = "Address: "+myProperty.propertyaddress
            itemView.textView_city.text = "City: "+myProperty.propertycity
            itemView.textView_state.text = "State: "+ myProperty.propertystate
            itemView.textView_country.text = "Country: "+ myProperty.propertycountry
            itemView.textView_pro_status.text = "Pro Status: "+myProperty.propertystatus
            itemView.textView_price.text = "Price: "+myProperty.propertypurchaseprice
            itemView.textView_mortgage.text = "Mortage Info: "+myProperty.propertymortageinfo
            itemView.button_remove.setOnClickListener{listener_remove.onItemClicked(myProperty)}
        }

    }

    interface MyListener{
        fun onItemClicked(myProperty: PropertyItem)
    }

}