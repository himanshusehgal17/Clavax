package com.shoperkart.clavax.models;

import android.widget.ListView;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("list")
    private List<ZipCode> list;

    public List<ZipCode> getList() {
        return list;
    }

    public void setList(List<ZipCode> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Data{" +
                "list=" + list +
                '}';
    }
}
