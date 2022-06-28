package com.yusif.nativeipcheck.service.IANA;

import com.yusif.nativeipcheck.constant.AllServicesCons;
import com.yusif.nativeipcheck.service.FiveMainWhois.RipeCheck;
<<<<<<< HEAD
import com.yusif.nativeipcheck.service.WhoisQuery.WhoisInternic;
=======
>>>>>>> c1d9b9fc1f892b52a9c6089254fd9946749b50e8
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
//IANA 检测服务
@Service
public class IANACheckService{
    @Autowired
    OkHttpClient okHttpClient;
    @Autowired
    Request.Builder builder;
    @Autowired
    AllServicesCons allServicesCons;
    @Autowired
    RipeCheck ripeCheck;
<<<<<<< HEAD
    @Autowired
    WhoisInternic whoisInternic;
     public  String IANAapi ="https://www.iana.org/whois?q="; //IANA api

     public String ipquery(String ip) {
        Request request=builder
                .url(IANAapi+ip)    //构建  url
                .build();

=======

     public  String IANAapi ="https://www.iana.org/whois?q="; //IANA api

    public String ipquery(String ip) {
        Request request=builder
                .url(IANAapi+ip)    //构建  url
                .build();
>>>>>>> c1d9b9fc1f892b52a9c6089254fd9946749b50e8
        try(Response response=okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            String orgin=parsehtml(response.body().string());  //获取返回体
<<<<<<< HEAD

            String hostname = null;
            if(orgin.equals("0")){
                return  null;
            }

            if(orgin.equals("RIPE NCC")){//欧洲
                hostname = "whois.ripe.net";
            }

            if(orgin.equals("LACNIC")){ //拉丁美洲和加勒比群岛
                 hostname="whois.lacnic.net";
            }

            if(orgin.equals("ARIN")){ //北美
                 hostname="whois.arin.net";
            }

            if(orgin.equals("APNIC")){//亚太
                 hostname="whois.apnic.net";
            }

            if(orgin.equals("AFRINIC")){//非洲
                 hostname="whois.afrinic.net";
            }

            if (hostname!=null){

              return  whoisInternic.getwhois(ip,hostname);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

   protected    String parsehtml(String html){   //   抽取 所在 organisation （组织）
=======
            if(orgin.equals("0")){

            }

            if(orgin.equals("RIPE NCC")){//欧洲
                System.out.println("此IP为欧洲ip");
                System.out.println(ripeCheck.check(ip));
            }

            if(orgin.equals("LACNIC")){ //拉丁美洲和加勒比群岛

            }

            if(orgin.equals("ARIN")){ //北美

            }

            if(orgin.equals("APNIC")){//亚太

            }

            if(orgin.equals("AFRINIC")){//非洲

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public  String parsehtml(String html){   //   抽取 所在 organisation （组织）
>>>>>>> c1d9b9fc1f892b52a9c6089254fd9946749b50e8
        Document document= Jsoup.parse(html);
        Element element=document.body().getElementsByTag("pre").first();
        System.out.println();
        assert element != null;
        String [] sa=element.text().split("\n");
      for (String s:sa){
<<<<<<< HEAD
           if (s.startsWith("whois"))   //查找以whois 开头
=======
           if (s.startsWith("o"))   //查找以organization 开头
>>>>>>> c1d9b9fc1f892b52a9c6089254fd9946749b50e8
           {
               return s.substring(s.indexOf(":")+2);
           }
      }
      return "0";
    }
}
