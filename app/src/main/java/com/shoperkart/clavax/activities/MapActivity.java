package com.shoperkart.clavax.activities;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.shoperkart.clavax.R;
import com.shoperkart.clavax.base.BaseActivity;
import com.shoperkart.clavax.utils.UtilsFunctions;

public class MapActivity extends BaseActivity implements OnMapReadyCallback {

    private String zipCode;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getIntentValue();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    private void getIntentValue() {
        Intent intent = getIntent();
        if (intent.hasExtra("zipCode"))
            zipCode = intent.getStringExtra("zipCode");
        else {
            finish();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        Address address = UtilsFunctions.getLocationFromAddress(this, String.valueOf(zipCode));
        LatLng point = new LatLng(28.7801, 77.1025);
        mMap.addMarker(new MarkerOptions()
                .position(point)
                .title(String.valueOf(zipCode)));
//        if (address != null) {
//            point = new LatLng(address.getLatitude(),address.getLongitude());
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(point));
//        }else showToast("LATLNG NOT FOUND");
    }

}