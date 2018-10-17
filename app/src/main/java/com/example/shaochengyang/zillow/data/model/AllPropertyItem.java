package com.example.shaochengyang.zillow.data.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AllPropertyItem implements Parcelable{

	@SerializedName("propertycountry")
	private String propertycountry;

	@SerializedName("propertypurchaseprice")
	private String propertypurchaseprice;

	@SerializedName("propertyuserid")
	private String propertyuserid;

	@SerializedName("propertystatus")
	private String propertystatus;

	@SerializedName("propertyusertype")
	private String propertyusertype;

	@SerializedName("propertymortageinfo")
	private String propertymortageinfo;

	@SerializedName("id")
	private String id;

	@SerializedName("propertystate")
	private String propertystate;

	@SerializedName("propertylatitude")
	private String propertylatitude;

	@SerializedName("propertyaddress")
	private String propertyaddress;

	@SerializedName("propertycity")
	private String propertycity;

	@SerializedName("propertylongitude")
	private String propertylongitude;

	protected AllPropertyItem(Parcel in) {
		propertycountry = in.readString();
		propertypurchaseprice = in.readString();
		propertyuserid = in.readString();
		propertystatus = in.readString();
		propertyusertype = in.readString();
		propertymortageinfo = in.readString();
		id = in.readString();
		propertystate = in.readString();
		propertylatitude = in.readString();
		propertyaddress = in.readString();
		propertycity = in.readString();
		propertylongitude = in.readString();
	}

	public static final Creator<AllPropertyItem> CREATOR = new Creator<AllPropertyItem>() {
		@Override
		public AllPropertyItem createFromParcel(Parcel in) {
			return new AllPropertyItem(in);
		}

		@Override
		public AllPropertyItem[] newArray(int size) {
			return new AllPropertyItem[size];
		}
	};

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

	public void setPropertyuserid(String propertyuserid){
		this.propertyuserid = propertyuserid;
	}

	public String getPropertyuserid(){
		return propertyuserid;
	}

	public void setPropertystatus(String propertystatus){
		this.propertystatus = propertystatus;
	}

	public String getPropertystatus(){
		return propertystatus;
	}

	public void setPropertyusertype(String propertyusertype){
		this.propertyusertype = propertyusertype;
	}

	public String getPropertyusertype(){
		return propertyusertype;
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

	public void setPropertylatitude(String propertylatitude){
		this.propertylatitude = propertylatitude;
	}

	public String getPropertylatitude(){
		return propertylatitude;
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

	public void setPropertylongitude(String propertylongitude){
		this.propertylongitude = propertylongitude;
	}

	public String getPropertylongitude(){
		return propertylongitude;
	}

	@Override
 	public String toString(){
		return 
			"PropertyItem{" + 
			"propertycountry = '" + propertycountry + '\'' + 
			",propertypurchaseprice = '" + propertypurchaseprice + '\'' + 
			",propertyuserid = '" + propertyuserid + '\'' + 
			",propertystatus = '" + propertystatus + '\'' + 
			",propertyusertype = '" + propertyusertype + '\'' + 
			",propertymortageinfo = '" + propertymortageinfo + '\'' + 
			",id = '" + id + '\'' + 
			",propertystate = '" + propertystate + '\'' + 
			",propertylatitude = '" + propertylatitude + '\'' + 
			",propertyaddress = '" + propertyaddress + '\'' + 
			",propertycity = '" + propertycity + '\'' + 
			",propertylongitude = '" + propertylongitude + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(propertycountry);
		dest.writeString(propertypurchaseprice);
		dest.writeString(propertyuserid);
		dest.writeString(propertystatus);
		dest.writeString(propertyusertype);
		dest.writeString(propertymortageinfo);
		dest.writeString(id);
		dest.writeString(propertystate);
		dest.writeString(propertylatitude);
		dest.writeString(propertyaddress);
		dest.writeString(propertycity);
		dest.writeString(propertylongitude);
	}
}