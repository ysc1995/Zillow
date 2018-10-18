package com.example.shaochengyang.zillow.data.model;

public class MapPassItem {
    String longi, lati,price;
    int count;

    public MapPassItem(String longi, String lati, int count, String price) {
        this.longi = longi;
        this.lati = lati;
        this.count = count;
        this.price = price;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
