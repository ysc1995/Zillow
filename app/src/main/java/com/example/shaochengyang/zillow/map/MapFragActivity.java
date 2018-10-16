package com.example.shaochengyang.zillow.map;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.shaochengyang.zillow.R;

public class MapFragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_frag);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_map));

    }

}
