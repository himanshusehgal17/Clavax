package com.shoperkart.clavax.models;

import com.google.gson.annotations.SerializedName;

public class ZipCode {

    @SerializedName("id")
    private int id;
    @SerializedName("zipcode")
    private int zipcode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "id=" + id +
                ", zipcode=" + zipcode +
                '}';
    }
}
