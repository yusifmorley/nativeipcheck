package com.yusif.nativeipcheck;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yusif.nativeipcheck.controller.Ipchecking;
import com.yusif.nativeipcheck.service.IANA.IANACheckService;

import com.yusif.nativeipcheck.service.IPinfo.IPInfoCheck;
import com.yusif.nativeipcheck.service.QqwryISPCheck.QqwryCheck;
import com.yusif.nativeipcheck.service.WhoisQuery.WhoisInternic;
import com.yusif.nativeipcheck.utils.ReadStringFromFile;
import io.ipinfo.api.IPinfo;
import com.yusif.nativeipcheck.controller.Ipchecking;
import com.yusif.nativeipcheck.service.IANA.IANACheckService;

import org.apache.commons.net.whois.WhoisClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NativeipcheckApplicationTests {
@Autowired
	IANACheckService ianaCheckService;
@Autowired
	Ipchecking ipchecking;
@Autowired
WhoisInternic whoisInternic;
	@Test
	void contextLoads() throws Exception {
		System.out.println(ianaCheckService.ipquery("2.16.6.0"));
	}

}
