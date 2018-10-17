package com.example.shaochengyang.zillow.ui.tenant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shaochengyang.zillow.R;

public class PropertyMapActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_map);



    }

    public String getLati(){
        String lati = getIntent().getExtras().getString("lati");
        return lati;
    }

    public String getLongi(){
        String longi = getIntent().getExtras().getString("long");
        return longi;
    }

    public String getPrice(){
        String price = getIntent().getExtras().getString("price");
        return price;
    }
}
