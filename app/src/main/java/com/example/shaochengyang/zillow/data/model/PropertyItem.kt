package com.example.shaochengyang.zillow.data.model

import com.google.gson.annotations.SerializedName

class PropertyItem {



    @SerializedName("propertycountry")
    var propertycountry: String? = null

    @SerializedName("propertypurchaseprice")
    var propertypurchaseprice: String? = null

    @SerializedName("propertystatus")
    var propertystatus: String? = null

    @SerializedName("propertymortageinfo")
    var propertymortageinfo: String? = null

    @SerializedName("id")
    var id: String? = null

    @SerializedName("propertystate")
    var propertystate: String? = null

    @SerializedName("propertyaddress")
    var propertyaddress: String? = null

    @SerializedName("propertycity")
    var propertycity: String? = null

    constructor(propertyaddress: String?, propertycity: String?, propertystate: String?, propertycountry: String?, propertystatus: String?, propertypurchaseprice: String?, propertymortageinfo: String?) {
        this.propertycountry = propertycountry
        this.propertypurchaseprice = propertypurchaseprice
        this.propertystatus = propertystatus
        this.propertymortageinfo = propertymortageinfo
        this.propertystate = propertystate
        this.propertyaddress = propertyaddress
        this.propertycity = propertycity
    }


    override fun toString(): String {
        return "PropertyItem{" +
                "propertycountry = '" + propertycountry + '\''.toString() +
                ",propertypurchaseprice = '" + propertypurchaseprice + '\''.toString() +
                ",propertystatus = '" + propertystatus + '\''.toString() +
                ",propertymortageinfo = '" + propertymortageinfo + '\''.toString() +
                ",id = '" + id + '\''.toString() +
                ",propertystate = '" + propertystate + '\''.toString() +
                ",propertyaddress = '" + propertyaddress + '\''.toString() +
                ",propertycity = '" + propertycity + '\''.toString() +
                "}"
    }
}