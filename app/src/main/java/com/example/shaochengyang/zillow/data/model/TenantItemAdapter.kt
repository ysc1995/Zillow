package com.example.shaochengyang.zillow.data.model

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shaochengyang.zillow.R
import kotlinx.android.synthetic.main.property_item_layout.view.*
import kotlinx.android.synthetic.main.tenant_item_layout.view.*

class TenantItemAdapter(var listener_info: MyListener, var listener_remove: MyListener)  :
        RecyclerView.Adapter<TenantItemAdapter.MyViewHolder>(), BindableAdapter<TenantsItem>{
    var mylist = emptyList<TenantsItem>()

    override fun updateList(newList: List<TenantsItem>){
        mylist = newList
        notifyDataSetChanged()
        Log.d("MyTag","List Changed")
    }

    override fun idxChanged(idx: Int){
        notifyItemChanged(idx)
        Log.d("MyTag","idx Changed")
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.tenant_item_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mylist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var tenants = mylist.get(position)
        holder.bind(tenants, listener_info, listener_remove)
    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(tenantsItem: TenantsItem, listener_info: MyListener, listener_remove: MyListener){
               itemView.textView_tenant_name.text = "Name: "+tenantsItem.tenantname
               itemView.textView_tenant_address.text = "Address: "+tenantsItem.tenantaddress
               itemView.textView_tenant_email.text = "email: "+tenantsItem.tenantemail
               itemView.textView_tenant_mobile.text = "mobile: "+tenantsItem.tenantmobile
        }

    }

    interface MyListener{
        fun onItemClicked(tenantsItem: TenantsItem)
    }
}