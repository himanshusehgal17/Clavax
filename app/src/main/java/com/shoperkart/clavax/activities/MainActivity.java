package com.shoperkart.clavax.activities;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shoperkart.clavax.AppController;
import com.shoperkart.clavax.R;
import com.shoperkart.clavax.adapters.CityAdapter;
import com.shoperkart.clavax.base.BaseActivity;
import com.shoperkart.clavax.interfaces.Interfaces;
import com.shoperkart.clavax.managers.CityManager;
import com.shoperkart.clavax.models.Response;
import com.shoperkart.clavax.models.ZipCode;
import com.shoperkart.clavax.utils.UtilsFunctions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements Interfaces.OnGetResponse, Interfaces.RVItemOnClick {

    private final CityManager cityManager = AppController.getInstance().getCityManager();

    private List<ZipCode> list, filteredList;
    private TextView loadingTextView;
    private RecyclerView recyclerView;
    private CityAdapter cityAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        networkCall();
        searchListener();
    }

    private void searchListener() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList(query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String str) {
        filteredList.clear();
        for (ZipCode zipCode : list) {
            if (String.valueOf(zipCode.getZipcode()).contains(str))
                filteredList.add(zipCode);
        }
        cityAdapter.filteredList(filteredList);
    }

    private void networkCall() {
        if (isInternetConnected()) {
            cityManager.getZipCodes(this);
        } else {
            loadingTextView.setText("Please turn on the internet");
            showToast("Please turn on the internet");
        }
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);
        loadingTextView = findViewById(R.id.loadingTextView);

        list = new ArrayList<>();
        filteredList = new ArrayList<>();
        cityAdapter = new CityAdapter(this, list, this);
        recyclerView.setAdapter(cityAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onSuccess(Response response) {
        loadingTextView.setVisibility(View.GONE);
        list.addAll(response.getData().getList());
        cityAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String error) {
        loadingTextView.setVisibility(View.VISIBLE);
        loadingTextView.setText(error);

    }

    @Override
    public void onZipCodeClick(int zipCode) {

        String address = "United States zipcode 0" + zipCode;
         UtilsFunctions.getLocationFromAddress(this,address, addresses -> {
             if(addresses != null) {
                 logger("AddressPoint",addresses.getCountryName() + "\n" + addresses.getLatitude() + "\n" +  addresses.getLongitude());
             }
             startActivity(new Intent(this,MapActivity.class).putExtra("zipCode",String.valueOf(zipCode)));

        });

    }
}