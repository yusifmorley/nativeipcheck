package com.yusif.nativeipcheck;

import com.yusif.nativeipcheck.service.IANA.IANACheckService;
import com.yusif.nativeipcheck.service.IPDateCheck.IPDateCheck;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NativeipcheckApplicationTests {


	 Logger LOGGER = LoggerFactory.getLogger(NativeipcheckApplicationTests.class);


@Autowired
	IPDateCheck ipDateCheck;



@Autowired
	IANACheckService ianaCheckService;
	@Test
	void contextLoads() throws Exception {

	//	System.out.println(ianaCheckService.ipquery("193.233.205.34"));
               LOGGER.error("hello");
	}

}
