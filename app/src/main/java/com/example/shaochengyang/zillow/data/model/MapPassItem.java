package com.example.shaochengyang.zillow.data.model;

public class MapPassItem {
    String longi, lati;
    int count;

    public MapPassItem(String longi, String lati, int count) {
        this.longi = longi;
        this.lati = lati;
        this.count = count;
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
}
