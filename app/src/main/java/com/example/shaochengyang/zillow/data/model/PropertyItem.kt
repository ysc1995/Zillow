package com.example.shaochengyang.zillow.data.model

import com.google.gson.annotations.SerializedName


data class PropertyItem(

	@field:SerializedName("propertycountry")
	val propertycountry: String? = null,

	@field:SerializedName("propertypurchaseprice")
	val propertypurchaseprice: String? = null,

	@field:SerializedName("propertyuserid")
	val propertyuserid: String? = null,

	@field:SerializedName("propertystatus")
	val propertystatus: String? = null,

	@field:SerializedName("propertyusertype")
	val propertyusertype: String? = null,

	@field:SerializedName("propertymortageinfo")
	val propertymortageinfo: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("propertystate")
	val propertystate: String? = null,

	@field:SerializedName("propertylatitude")
	val propertylatitude: String? = null,

	@field:SerializedName("propertyaddress")
	val propertyaddress: String? = null,

	@field:SerializedName("propertycity")
	val propertycity: String? = null,

	@field:SerializedName("propertylongitude")
	val propertylongitude: String? = null
)