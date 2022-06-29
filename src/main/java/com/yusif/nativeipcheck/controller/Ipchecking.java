package com.yusif.nativeipcheck.controller;


import com.yusif.nativeipcheck.Entity.IpLogo;
import com.yusif.nativeipcheck.service.IANA.IANACheckService;

import com.yusif.nativeipcheck.service.IPinfo.IPInfoCheck;
import com.yusif.nativeipcheck.utils.GetIp;
import io.ipinfo.api.model.ASNResponse;
import io.ipinfo.api.model.IPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin
public class Ipchecking {
    @Autowired
    IANACheckService ianaCheckService;
    @Autowired
    IPInfoCheck ipInfoCheck;
    @RequestMapping("/")
        public String getIRealIPAddr(HttpServletRequest request) {
        GetIp getIp=new GetIp();
        String ip=getIp.getIRealIPAddr(request);//ip
        String whois= ianaCheckService.ipquery(ip);//Whois 信息

        IPResponse ipResponse=ipInfoCheck.checkip(ip);
        ASNResponse asnResponse=ipInfoCheck.checkasn(ipResponse.getAsn().toString());
        IpLogo ipLogo=new IpLogo();

        ipLogo.setIp(ip);


    return "";
    }









}
