package com.yusif.nativeipcheck.service.IANA;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.net.whois.WhoisClient;
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

    private final String IANAapi ="https://www.iana.org/whois?q="; //IANA api
    public String ipquery(String ip) {
        Request request=builder
                .url(IANAapi+ip)    //构建  请求 url
                .build();
        try(Response response=okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            String orgin=parsehtml(response.body().string());  //获取返回体
            if(orgin.equals("0")){
                return  null;
            }

              return getwhois(ip,orgin);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }


    private   String parsehtml(String html){   //   抽取 所在 organisation （组织）
        Document document= Jsoup.parse(html);
        Element element=document.body().getElementsByTag("pre").first();
        System.out.println();
        assert element != null;
        String [] sa=element.text().split("\n");
      for (String s:sa){

           if (s.startsWith("whois"))   //查找以whois 开头
           {
             return s.substring(s.lastIndexOf("whois"));
           }
      }
      return "0";
    }

    private   String  getwhois(String ip,String hostname){
        System.out.println(hostname);
        WhoisClient whois=new WhoisClient();
        try {
            whois.connect(hostname);
            String result= whois.query(ip);
            whois.disconnect();
            return  result;
        } catch (IOException e) {
            System.err.println("Error I/O exception: " + e.getMessage());
        }
        return null;
    }
}
