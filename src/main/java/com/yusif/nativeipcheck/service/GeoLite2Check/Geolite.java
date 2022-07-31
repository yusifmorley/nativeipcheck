//package com.yusif.nativeipcheck.service.GeoLite2Check;
//
//import com.maxmind.geoip2.WebServiceClient;
//import com.maxmind.geoip2.exception.GeoIp2Exception;
//import com.maxmind.geoip2.model.CountryResponse;
//import com.maxmind.geoip2.record.Country;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//@Service
//public class Geolite {
//
//    public  Country getCountry() throws IOException, GeoIp2Exception {
//        WebServiceClient client = new WebServiceClient.Builder(747781, "NlLi8hHWI2NAH7Yg")
//                .host("geolite.info").build();
//
//        InetAddress ipAddress = InetAddress.getByName("128.101.101.101");
//        // Do the lookup
//        CountryResponse response = client.country(ipAddress);
//        Country country = response.getCountry();
//        System.out.println(country.getIsoCode());            // 'US'
//        System.out.println(country.getName());               // 'United States'
//        System.out.println(country.getNames().get("zh-CN")); // '美国'
//
//        return country;
//    }
//
//
//
//}
