package com.example.shaochengyang.zillow.ui.tenant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shaochengyang.zillow.R;

public class PropertyMapActivity extends AppCompatActivity {
    static String lati, longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_map);

        lati = getIntent().getExtras().getString("lati");
        longi = getIntent().getExtras().getString("longi");
    }

    public static String getLati(){
        return lati;
    }

    public static String getLongi(){
        return longi;
    }
}
