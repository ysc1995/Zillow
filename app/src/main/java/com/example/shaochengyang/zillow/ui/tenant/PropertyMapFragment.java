package com.example.shaochengyang.zillow.ui.tenant;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaochengyang.zillow.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.GeoApiContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PropertyMapFragment extends Fragment implements
        ActivityCompat.OnRequestPermissionsResultCallback {
    private static final String TAG = "MapViewFragment";

    MapView mMapView;
    private GoogleMap mMap;


    String departLati;
    String departLong;
    String price;


    String departCity = "Barcelona";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_map, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        PropertyMapActivity propertyMapActivity = (PropertyMapActivity) getActivity();
        departLati = propertyMapActivity.getLati();
        departLong = propertyMapActivity.getLongi();
        price = propertyMapActivity.getPrice();
        setLocation(departLati, departLong);


        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return rootView;
    }


    public GeoApiContext getGeoContext() {
        GeoApiContext geoApiContext = new GeoApiContext();
        return geoApiContext.setQueryRateLimit(3).setApiKey(getString(R.string.google_maps_key))
                .setConnectTimeout(1, TimeUnit.SECONDS).setReadTimeout(1, TimeUnit.SECONDS)
                .setWriteTimeout(1, TimeUnit.SECONDS);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


    public void setLocation(String fromCityLati, String fromCityLong
    ) {
        departLati = fromCityLati;
        departLong = fromCityLong;


        mMapView.getMapAsync(new OnMapReadyCallback() {
                                 @Override
                                 public void onMapReady(GoogleMap googleMap) {
                                     mMap = googleMap;


                                     LatLng fromCity = new LatLng(Double.parseDouble(departLati),
                                             Double.parseDouble(departLong));
                                     mMap.addMarker(new MarkerOptions().position(fromCity).title(price + "$"));


                                     mMap.getUiSettings().setZoomControlsEnabled(true);

                                     mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fromCity, 9));
                                 }
                             }
        );


    }
}
