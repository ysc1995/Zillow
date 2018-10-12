package com.example.shaochengyang.zillow.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Property {
    @SerializedName("Property")
    private List<PropertyItem> property;

    public void setProperty(List<PropertyItem> property){
        this.property = property;
    }

    public List<PropertyItem> getProperty(){
        return property;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "property = '" + property + '\'' +
                        "}";
    }
}
