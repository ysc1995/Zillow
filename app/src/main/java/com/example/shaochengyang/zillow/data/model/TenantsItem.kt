package com.example.shaochengyang.zillow.data.model


import com.google.gson.annotations.SerializedName

data class TenantsItem(

	@field:SerializedName("tenantemail")
	var tenantemail: String? = null,

	@field:SerializedName("tenantmobile")
	var tenantmobile: String? = null,

	@field:SerializedName("tenantname")
	var tenantname: String? = null,

	@field:SerializedName("id")
	var id: String? = null,

	@field:SerializedName("landlordid")
	var landlordid: String? = null,

	@field:SerializedName("propertyid")
	var propertyid: String? = null,

	@field:SerializedName("tenantaddress")
	var tenantaddress: String? = null


)