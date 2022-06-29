package com.yusif.nativeipcheck.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Map;
@Getter
@Setter
public class IpLogo {
    private  String ip;
    private  String ASN;
    private  String companytype;
    private  LinkedList<Map<String,Boolean>> privacy;
    private  String ASNcontry;
    private  String IpContry;
    private  String AbuseContry;
    private  String ASNtype;

}
