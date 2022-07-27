package com.yusif.nativeipcheck.controller;


import com.yusif.nativeipcheck.Entity.IpLogo;
import com.yusif.nativeipcheck.service.IANA.IANACheckService;
import com.yusif.nativeipcheck.service.IPinfo.IPInfoCheck;
import com.yusif.nativeipcheck.utils.GetIp;
import com.yusif.nativeipcheck.utils.GetPrivacy;
import com.yusif.nativeipcheck.utils.MyDate;
import io.ipinfo.api.model.ASNResponse;
import io.ipinfo.api.model.IPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController  //包含 @ResponseBody
@CrossOrigin
public class Ipchecking {
    @Autowired
    IANACheckService ianaCheckService;
    @Autowired
    IPInfoCheck ipInfoCheck;
    @RequestMapping("/nativeipinfo/{ip}")
        public IpLogo getIRealIPAddr(@PathVariable String ip) {
//        GetIp getIp=new GetIp();
//        String ip=getIp.getIRealIPAddr(request);//ip地址

        IPResponse ipResponse=ipInfoCheck.checkip(ip);  //ip信息
        ASNResponse asnResponse=ipInfoCheck.checkasn(ipResponse.getAsn().toString()); //Asn信息
        IpLogo ipLogo=new IpLogo();

        ipLogo.setIp(ip);
        ipLogo.setASN(asnResponse.getAsn());
        ipLogo.setAbuseContry(ipResponse.getAbuse().getCountry());
        ipLogo.setASNcontry(asnResponse.getCountry());
        ipLogo.setCompanytype(ipResponse.getCompany().getType());
        ipLogo.setIpContry(ipResponse.getCountryCode());
        ipLogo.setASNtype(asnResponse.getType());
        ipLogo.setPrivacy(new GetPrivacy().parsePrivacy(ipResponse.getPrivacy()));
        ipLogo.setCurtime(new MyDate().getNowTime());

        return ipLogo;
    }
    @RequestMapping("/myipwhois/{ip}")
    public  String getMyWhois(@PathVariable String ip){
//        GetIp getIp=new GetIp();
//        String ip=getIp.getIRealIPAddr(request);
        return ianaCheckService.ipquery(ip);
    }
}
