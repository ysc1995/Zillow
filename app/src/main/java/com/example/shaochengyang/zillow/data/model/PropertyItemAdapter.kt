package com.example.shaochengyang.zillow.data.model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shaochengyang.zillow.R
import kotlinx.android.synthetic.main.property_item_layout.view.*

class PropertyItemAdapter : RecyclerView.Adapter<PropertyItemAdapter.MyViewHolder>(), BindableAdapter<PropertyItem>{

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
        holder.bind(property)
    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(myProperty: PropertyItem){
            itemView.textView_id.text = myProperty.id
            itemView.textView_address.text = myProperty.propertyaddress
            itemView.textView_city.text = myProperty.propertycity
        }

    }

}