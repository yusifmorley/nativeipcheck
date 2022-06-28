package com.yusif.nativeipcheck.controller;


import com.yusif.nativeipcheck.service.IANA.IANACheckService;

import com.yusif.nativeipcheck.utils.GetIp;
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

    @RequestMapping("/")
        public String getIRealIPAddr(HttpServletRequest request) {
        GetIp getIp=new GetIp();
        return   ianaCheckService.ipquery(getIp.getIRealIPAddr(request));
    }









}
