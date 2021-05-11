package com.shoperkart.clavax.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.shoperkart.clavax.interfaces.Interfaces;

import java.io.IOException;
import java.util.List;

public class UtilsFunctions {
    public static void getLocationFromAddress(Context context, String strAddress, Interfaces.OnGetAddress onGetAddress) {
        Geocoder coder = new Geocoder(context);
        List<Address> address;
        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                onGetAddress.ongetAddress(null);
            } else if (address.size() > 0)
                onGetAddress.ongetAddress(address.get(0));
        } catch (IOException e) {
            e.printStackTrace();
            onGetAddress.ongetAddress(null);
        }

    }

}
