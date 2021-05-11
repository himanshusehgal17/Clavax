package com.shoperkart.clavax.managers;

import com.shoperkart.clavax.interfaces.Interfaces;
import com.shoperkart.clavax.networkCalls.ServerCalls;

public class CityManager {

    private final ServerCalls serverCalls;

    public CityManager(ServerCalls serverCalls) {
        this.serverCalls = serverCalls;
    }

    public void getZipCodes(Interfaces.OnGetResponse onGetResponse) {
        serverCalls.getZipCodes(onGetResponse);
    }

}
