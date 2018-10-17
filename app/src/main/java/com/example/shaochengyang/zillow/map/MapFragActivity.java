package com.example.shaochengyang.zillow.map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.example.shaochengyang.zillow.R;
import com.example.shaochengyang.zillow.data.model.AllPropertyItem;
import com.example.shaochengyang.zillow.ui.MoreActivity;
import com.example.shaochengyang.zillow.ui.property.AddPropertyActivity;
import com.example.shaochengyang.zillow.ui.property.PropertyActivity;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class MapFragActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());


        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_map));


        setContentView(R.layout.activity_map_frag);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.property_icon:
                Intent i_property = new Intent(MapFragActivity.this, PropertyActivity.class);
                startActivity(i_property);
                break;
            case R.id.yourhome_icon:
                Intent i_addProperty = new Intent(MapFragActivity.this,AddPropertyActivity.class);
                startActivity(i_addProperty);
                break;
            case R.id.more_icon:
                Intent i = new Intent(MapFragActivity.this,MoreActivity.class);
                startActivity(i);
                break;
        }

        return true;
    }


    public List<AllPropertyItem> getList(){
        Parcelable[] list = getIntent().getExtras().getParcelableArray("list");
        List<AllPropertyItem> propertyItemList = new ArrayList<>();
        for(int i = 0 ; i < list.length; i++){

            propertyItemList.add((AllPropertyItem) list[i]);
        };

        return propertyItemList;
    }


}
