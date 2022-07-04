package com.yusif.nativeipcheck.utils;

import io.ipinfo.api.model.Privacy;

import java.util.HashMap;
import java.util.Map;

public class GetPrivacy {
    public Map<String,Boolean> parsePrivacy(Privacy privacy){
        Map<String,Boolean> map=new HashMap<>();
        map.put("Tor",privacy.getTor());
        map.put("Proxy",privacy.getProxy());
        map.put("Vpn",privacy.getVpn());
        map.put("Relay",privacy.getRelay());
        map.put("Hosting",privacy.getHosting());
        return  map;
    }
}
