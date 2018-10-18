package com.example.shaochengyang.zillow.map;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shaochengyang.zillow.data.DataManager;
import com.example.shaochengyang.zillow.data.IDataManager;
import com.example.shaochengyang.zillow.data.model.AllPropertyItem;
import com.example.shaochengyang.zillow.viewmodel.ViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TestActivity extends AppCompatActivity implements IDataManager.onAllPropertyInfoListener {
    IDataManager iDataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_test);
        iDataManager = new DataManager();
        iDataManager.getAllPropertyInfo(this);
    }

    @Override
    public void passAllPropertyList(@NotNull List<AllPropertyItem> allPropertyList) {
        Parcelable[] parcelist = new Parcelable[allPropertyList.size()];
        for(int i = 0 ; i < allPropertyList.size(); i++){
            parcelist[i] = allPropertyList.get(i);
        }
        Intent i = new Intent(TestActivity.this,MapFragActivity.class);

        i.putExtra("list",parcelist);
        startActivity(i);



    }
}
