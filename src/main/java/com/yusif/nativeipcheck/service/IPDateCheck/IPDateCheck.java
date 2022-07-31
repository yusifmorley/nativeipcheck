package com.yusif.nativeipcheck.service.IPDateCheck;

import io.ipdata.client.Ipdata;
import io.ipdata.client.error.IpdataException;
import io.ipdata.client.model.IpdataModel;
import io.ipdata.client.service.IpdataService;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Service
public class IPDateCheck {

    public  IpdataModel  IpdateCheck( String ip) throws MalformedURLException, IpdataException {
        URL url = new URL("https://api.ipdata.co");
        String key="ac1ae96f49cc53dc6c630663048f679a2923d1a104dabd8686de300c";
        IpdataService ipdataService = Ipdata.builder().url(url)
                .withCache()
                .timeout(30, TimeUnit.MINUTES) //ttl after first write
                .maxSize(8 * 1024) //no more than 8*1024 items shall be stored in cache
                .registerCacheConfig()
                .key(key)
                .get();

        IpdataModel model = ipdataService.ipdata(ip); //cache miss here
        ipdataService.ipdata(ip); //cache hit from now on on ip address "1.1.1.1"

        return model;

    }
}
