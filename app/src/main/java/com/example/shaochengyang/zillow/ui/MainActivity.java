package com.example.shaochengyang.zillow.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shaochengyang.zillow.R;
import com.example.shaochengyang.zillow.data.DataManager;
import com.example.shaochengyang.zillow.data.IDataManager;

public class MainActivity extends AppCompatActivity implements IDataManager.onPropertyListListerner {

    IDataManager iDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iDataManager = new DataManager(this);
        //iDataManager.getPropertyList(this,3,"landlord");
        

    }
}
