package com.shoperkart.clavax.interfaces;

import android.location.Address;

import com.shoperkart.clavax.models.Response;

public class Interfaces {

    public interface OnGetResponse {
        void onSuccess(Response response);

        void onFailure(String error);
    }

    public interface RVItemOnClick {
        void onZipCodeClick(int zipCode);
    }

    public interface OnGetAddress {
        void ongetAddress(Address address);
    }
}
