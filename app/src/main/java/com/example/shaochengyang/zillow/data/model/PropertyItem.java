package com.example.shaochengyang.zillow.data.model;


import com.google.gson.annotations.SerializedName;


public class PropertyItem{

	@SerializedName("propertycountry")
	private String propertycountry;

	@SerializedName("propertypurchaseprice")
	private String propertypurchaseprice;

	@SerializedName("propertystatus")
	private String propertystatus;

	@SerializedName("propertymortageinfo")
	private String propertymortageinfo;

	@SerializedName("id")
	private String id;

	@SerializedName("propertystate")
	private String propertystate;

	@SerializedName("propertyaddress")
	private String propertyaddress;

	@SerializedName("propertycity")
	private String propertycity;

	public void setPropertycountry(String propertycountry){
		this.propertycountry = propertycountry;
	}

	public String getPropertycountry(){
		return propertycountry;
	}

	public void setPropertypurchaseprice(String propertypurchaseprice){
		this.propertypurchaseprice = propertypurchaseprice;
	}

	public String getPropertypurchaseprice(){
		return propertypurchaseprice;
	}

	public void setPropertystatus(String propertystatus){
		this.propertystatus = propertystatus;
	}

	public String getPropertystatus(){
		return propertystatus;
	}

	public void setPropertymortageinfo(String propertymortageinfo){
		this.propertymortageinfo = propertymortageinfo;
	}

	public String getPropertymortageinfo(){
		return propertymortageinfo;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPropertystate(String propertystate){
		this.propertystate = propertystate;
	}

	public String getPropertystate(){
		return propertystate;
	}

	public void setPropertyaddress(String propertyaddress){
		this.propertyaddress = propertyaddress;
	}

	public String getPropertyaddress(){
		return propertyaddress;
	}

	public void setPropertycity(String propertycity){
		this.propertycity = propertycity;
	}

	public String getPropertycity(){
		return propertycity;
	}

	@Override
 	public String toString(){
		return 
			"PropertyItem{" + 
			"propertycountry = '" + propertycountry + '\'' + 
			",propertypurchaseprice = '" + propertypurchaseprice + '\'' + 
			",propertystatus = '" + propertystatus + '\'' + 
			",propertymortageinfo = '" + propertymortageinfo + '\'' + 
			",id = '" + id + '\'' + 
			",propertystate = '" + propertystate + '\'' + 
			",propertyaddress = '" + propertyaddress + '\'' + 
			",propertycity = '" + propertycity + '\'' + 
			"}";
		}
}