package com.yusif.nativeipcheck.service.WhoisQuery;

import org.apache.commons.net.whois.WhoisClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WhoisInternic {
public String  getwhois(String ip,String hostname){
    WhoisClient whois=new WhoisClient();
    try {
        whois.connect(hostname);
        System.out.println();
       String result= whois.query(ip);
        whois.disconnect();
      return  result;
    } catch (IOException e) {
        System.err.println("Error I/O exception: " + e.getMessage());
    }
    return null;
}

}
