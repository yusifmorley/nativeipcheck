package com.yusif.nativeipcheck.controller;


import com.yusif.nativeipcheck.Entity.IpLogo;
import com.yusif.nativeipcheck.service.IANA.IANACheckService;
import com.yusif.nativeipcheck.service.IPDateCheck.IPDateCheck;
import com.yusif.nativeipcheck.service.IPinfo.IPInfoCheck;
import com.yusif.nativeipcheck.utils.GetIp;
import com.yusif.nativeipcheck.utils.GetPrivacy;
import com.yusif.nativeipcheck.utils.GsonUtil;
import com.yusif.nativeipcheck.utils.MyDate;
import io.ipdata.client.error.IpdataException;
import io.ipdata.client.model.IpdataModel;
import io.ipinfo.api.model.ASNResponse;
import io.ipinfo.api.model.IPResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController  //包含 @ResponseBody
@CrossOrigin
public class Ipchecking {

    Logger LOGGER = LoggerFactory.getLogger(Ipchecking.class);

    @Autowired
    IANACheckService ianaCheckService;

    @Autowired
    IPDateCheck ipDateCheck;

    @RequestMapping("/nativeipdate/{ip}")
        public IpdataModel getIRealIPAddr(@PathVariable("ip") String ip) throws IpdataException, MalformedURLException {
        LOGGER.info("来自"+ip+"的 ipdate 请求");
        return ipDateCheck.IpdateCheck(ip);//序列化为 json

    }
    @RequestMapping("/myipwhois/{ip}")
    public  String[] getMyWhois(@PathVariable String ip){
        LOGGER.info("来自"+ip+"的 whois 请求");
        return ianaCheckService.ipquery(ip).split("\n");

    }

    @RequestMapping("/try")
    public  String[] mytry(){

        return  new String[]{"hello","hello"};

    }

}
