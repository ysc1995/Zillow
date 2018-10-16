package com.example.shaochengyang.zillow.map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.shaochengyang.zillow.R;
import com.example.shaochengyang.zillow.ui.AddPropertyActivity;
import com.example.shaochengyang.zillow.ui.PropertyActivity;

public class MapFragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_frag);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_map));

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
        }

        return true;
    }
}
