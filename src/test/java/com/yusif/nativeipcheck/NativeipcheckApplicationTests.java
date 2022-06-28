package com.yusif.nativeipcheck;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yusif.nativeipcheck.controller.Ipchecking;
import com.yusif.nativeipcheck.service.IANA.IANACheckService;
import com.yusif.nativeipcheck.service.FiveMainWhois.LacnicCheck;
import com.yusif.nativeipcheck.service.IPinfo.IPInfoCheck;
import com.yusif.nativeipcheck.service.QqwryISPCheck.QqwryCheck;
import com.yusif.nativeipcheck.service.WhoisQuery.WhoisInternic;
import com.yusif.nativeipcheck.utils.ReadStringFromFile;
import io.ipinfo.api.IPinfo;
import com.yusif.nativeipcheck.controller.Ipchecking;
import com.yusif.nativeipcheck.service.IANA.IANACheckService;
import com.yusif.nativeipcheck.service.FiveMainWhois.LacnicCheck;
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
	LacnicCheck lacnicCheck;
	@Test
	void contextLoads() throws Exception {

		String Gemany="2.16.6.0";//欧洲
        String afic="102.128.163.255";//非洲
		System.out.println(ianaCheckService.ipquery(afic));
		System.out.println(ReadStringFromFile.getstring("src/main/resources/lacnic.json").replaceAll(",",",\n"));
		//System.out.println(lacnicCheck.getjson(  ));


	}

}
