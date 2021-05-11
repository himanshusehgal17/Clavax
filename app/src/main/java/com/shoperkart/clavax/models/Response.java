package com.shoperkart.clavax.models;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("error")
    private int error;
    @SerializedName("data")
    private Data data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "error=" + error +
                ", data=" + data +
                '}';
    }
}
