package com.example.shaochengyang.zillow.map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaochengyang.zillow.R;
import com.example.shaochengyang.zillow.data.model.AllProperty;
import com.example.shaochengyang.zillow.data.model.AllPropertyItem;
import com.example.shaochengyang.zillow.data.model.MapPassItem;
import com.example.shaochengyang.zillow.data.model.CustomObj;
import com.example.shaochengyang.zillow.ui.tenant.TenantPropertyViewActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.GeoApiContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MapFragment extends Fragment implements
        ActivityCompat.OnRequestPermissionsResultCallback {

    private static final String TAG = "MapViewFragment";

    MapView mMapView;
    private GoogleMap mMap;


    String departLati;
    String departLong;
    String price;
    int count;
    List<AllPropertyItem> list;

    private Marker marker;
    private AllPropertyItem customObj;

    /*IDataManager iDataManager;*/


    @Override
    public synchronized View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_map, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        /* iDataManager = new DataManager();*/
        /*iDataManager.getAllPropertyInfo(this);*/

        MapFragActivity mapFragActivity = (MapFragActivity) getActivity();
        list = mapFragActivity.getList();
        //List<MapPassItem> passList = new ArrayList<>();
        List<AllPropertyItem> passList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getPropertylatitude().equals("") && !list.get(i).getPropertylongitude().equals("")) {
                price = list.get(i).getPropertypurchaseprice();
                String lati = list.get(i).getPropertylatitude();
                String longi = list.get(i).getPropertylongitude();

                MapPassItem mapPassItem = new MapPassItem(lati, longi, i, price);
                AllPropertyItem allPropertyItem = list.get(i);
                //passList.add(mapPassItem);
                passList.add(allPropertyItem);
                //setLocation(list.get(i).getPropertylatitude(), list.get(i).getPropertylongitude(),price,i);
            }

            setLocation(passList);
        }


        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootView;
    }

    private void setLocation(final List<AllPropertyItem> passList) {


        mMapView.getMapAsync(new OnMapReadyCallback() {
                                 @Override
                                 public void onMapReady(GoogleMap googleMap) {
                                     mMap = googleMap;
                                     for (int i = 0; i < passList.size(); i++) {
                                         departLati = passList.get(i).getPropertylatitude();
                                         departLong = passList.get(i).getPropertylongitude();
                                         /*count = passList.get(i).getCount();*/
                                         price = passList.get(i).getPropertypurchaseprice();

                                         LatLng fromCity = new LatLng(Double.parseDouble(departLati),
                                                 Double.parseDouble(departLong));
                                         MarkerOptions markerOptions = new MarkerOptions().position(fromCity).title("$" + price + "/mo").snippet(passList.get(i).getPropertyaddress() + ", " + passList.get(i).getPropertycity() + ", " + passList.get(i).getPropertystate() + ", " + passList.get(i).getPropertycountry());

                                         marker = mMap.addMarker(markerOptions);
                                         if (!marker.isInfoWindowShown()) {
                                             marker.showInfoWindow();
                                         }
                                         customObj = passList.get(i);
                                         //customObj = new CustomObj(passList.get(i).getCount());
                                         marker.setTag(customObj);
                                     }


                                     mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                                         @Override
                                         public void onInfoWindowClick(Marker marker) {
                                             Intent i = new Intent(getActivity(), TenantPropertyViewActivity.class);
                                             /*i.putExtra("lati",marker.getPosition().latitude);
                                             i.putExtra("long",marker.getPosition().longitude);*/

                                             AllPropertyItem myCustomObj = (AllPropertyItem) marker.getTag();

                                             //i.putExtra("count",""+myCustomObj.getCount());

                                             /*Parcelable[] parcelist = new Parcelable[list.size()];
                                             for(int k = 0 ; k < list.size(); k++){
                                                 parcelist[k] = list.get(k);
                                             }*/

                                             //i.putExtra("list",parcelist);
                                             i.putExtra("price", myCustomObj.getPropertypurchaseprice());
                                             i.putExtra("address", myCustomObj.getPropertyaddress());
                                             i.putExtra("city", myCustomObj.getPropertycity());
                                             i.putExtra("state", myCustomObj.getPropertystate());
                                             i.putExtra("country", myCustomObj.getPropertycountry());
                                             i.putExtra("userid", myCustomObj.getPropertyuserid());
                                             i.putExtra("lati", myCustomObj.getPropertylatitude());
                                             i.putExtra("longi", myCustomObj.getPropertylongitude());
                                             i.putExtra("mortgage", myCustomObj.getPropertymortageinfo());
                                             i.putExtra("id", myCustomObj.getId());

                                             startActivity(i);
                                         }
                                     });


                                     mMap.setOnMarkerClickListener(new OnMarkerClickListener() {

                                         @Override
                                         public boolean onMarkerClick(Marker marker) {


                                             //Toast.makeText(getActivity(), ""+marker.getTitle()+marker.getPosition().latitude+marker.getPosition(), Toast.LENGTH_SHORT).show();
                                             return false;
                                         }
                                     });
                                     mMap.setOnInfoWindowLongClickListener(new GoogleMap.OnInfoWindowLongClickListener() {
                                         @Override
                                         public void onInfoWindowLongClick(Marker marker) {
                                             marker.hideInfoWindow();
                                         }
                                     });


                                     mMap.getUiSettings().setZoomControlsEnabled(true);

                                     //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fromCity, 6));
                                 }
                             }
        );
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


    /*public void setLocation(String fromCityLati, String fromCityLong, final String propertyPrice, final int count) {
        departLati = fromCityLati;
        departLong = fromCityLong;


        mMapView.getMapAsync(new OnMapReadyCallback() {
                                 @Override
                                 public void onMapReady(GoogleMap googleMap) {
                                     mMap = googleMap;


                                     List<LatLng> path = new ArrayList();

                                     LatLng fromCity = new LatLng(Double.parseDouble(departLati),
                                             Double.parseDouble(departLong));
                                     MarkerOptions marker = new MarkerOptions().position(fromCity).title(""+count);

                                     mMap.addMarker(marker);


                                     mMap.setOnMarkerClickListener(new OnMarkerClickListener(){

                                         @Override
                                         public boolean onMarkerClick(Marker marker) {


                                             Intent i = new Intent(getActivity(), TenantPropertyViewActivity.class);
                                             *//*i.putExtra("lati",marker.getPosition().latitude);
                                             i.putExtra("long",marker.getPosition().longitude);*//*
                                             i.putExtra("count",marker.getTitle());

                                             Parcelable[] parcelist = new Parcelable[list.size()];
                                             for(int k = 0 ; k < list.size(); k++){
                                                 parcelist[k] = list.get(k);
                                             }
                                             i.putExtra("list",parcelist);
                                             startActivity(i);
                                             //Toast.makeText(getActivity(), ""+marker.getTitle()+marker.getPosition().latitude+marker.getPosition(), Toast.LENGTH_SHORT).show();
                                             return false;
                                         }
                                     } );





                                     mMap.getUiSettings().setZoomControlsEnabled(true);

                                     mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fromCity, 6));
                                 }
                             }
        );


    }*/


}
