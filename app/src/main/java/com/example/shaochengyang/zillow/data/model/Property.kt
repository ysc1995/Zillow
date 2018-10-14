package com.example.shaochengyang.zillow.data.model

import com.google.gson.annotations.SerializedName

class Property {
    @SerializedName("Property")
    var property: List<PropertyItem>? = null

    override fun toString(): String {
        return "RemovePropertyResponse{" +
                "property = '" + property + '\''.toString() +
                "}"
    }
}
