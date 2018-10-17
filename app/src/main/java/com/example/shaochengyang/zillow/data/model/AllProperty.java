package com.example.shaochengyang.zillow.data.model;

import java.util.List;

import com.example.shaochengyang.zillow.data.model.AllPropertyItem;
import com.google.gson.annotations.SerializedName;


public class AllProperty{

	@SerializedName("Property")
	private List<AllPropertyItem> property;

	public void setProperty(List<AllPropertyItem> property){
		this.property = property;
	}

	public List<AllPropertyItem> getProperty(){
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