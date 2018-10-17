package com.example.shaochengyang.zillow.data.model


import com.google.gson.annotations.SerializedName


data class TenantInfo(

	@field:SerializedName("Tenants")
	val tenants: List<TenantsItem?>? = null
)