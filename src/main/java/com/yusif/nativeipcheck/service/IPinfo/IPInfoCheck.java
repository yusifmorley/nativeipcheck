package com.yusif.nativeipcheck.service.IPinfo;

import io.ipinfo.api.IPinfo;
import io.ipinfo.api.cache.SimpleCache;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.ASNResponse;
import io.ipinfo.api.model.IPResponse;
import org.springframework.stereotype.Service;

import java.time.Duration;
@Service
public class IPInfoCheck {
    public  String checkip(String ip){

        // 5 Day Cache
        IPinfo ipInfo = new IPinfo.Builder()
                .setToken("7093f7182c3de5")
                .setCache(new SimpleCache(Duration.ofDays(5)))
                .build();
        try {
            IPResponse response = ipInfo.lookupIP(ip);
            // Print out the hostname
            System.out.println(response.getPrivacy());
            System.out.println(response.getAsn());
        } catch (RateLimitedException ex) {
            // Handle rate limits here.
        }
        return "";
    }

    public  String checkasn(String asn){
        // 5 Day Cache
        IPinfo ipInfo = new IPinfo.Builder()
                .setToken("7093f7182c3de5")
                .setCache(new SimpleCache(Duration.ofDays(5)))
                .build();
        try {
            ASNResponse response = ipInfo.lookupASN(asn);
            // Print out the hostname
            System.out.println(response.getCountry());
        } catch (RateLimitedException ex) {
            // Handle rate limits here.
        }
        return "";
    }
}
