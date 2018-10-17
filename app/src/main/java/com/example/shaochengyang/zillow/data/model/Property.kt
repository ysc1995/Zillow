package com.example.shaochengyang.zillow.data.model


import com.google.gson.annotations.SerializedName


data class Property(

	@field:SerializedName("Property")
	val property: List<PropertyItem?>? = null
)