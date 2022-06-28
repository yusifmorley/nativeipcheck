package com.yusif.nativeipcheck.service.QqwryISPCheck;

import com.github.jarod.qqwry.QQWry;

import java.io.IOException;
import java.nio.file.Paths;

public class QqwryCheck {
   public  String Ispcheck(String ip) throws IOException {
       QQWry qqWry=new QQWry(Paths.get("src/main/resources/qqwry/qqwry.dat"));
//       System.out.println(qqWry.findIP(ip).getMainInfo());
//       System.out.println(qqWry.findIP(ip).getSubInfo());
       return String.valueOf(qqWry.findIP(ip));
   }
}
