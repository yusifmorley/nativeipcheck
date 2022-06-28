package com.yusif.nativeipcheck.service.FiveMainWhois;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.yusif.nativeipcheck.utils.GsonUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

//欧洲、中东和中亚
@Service
public class RipeCheck {

public  static String ripeapi="http://rest.db.ripe.net/search?query-string=";
@Autowired
OkHttpClient okHttpClient;
@Autowired
Request.Builder builder;
public String check(String ip) throws IOException {    //开始请求
Request request=builder
//        .addHeader("Accept-Encoding","gzip, deflate")
        .addHeader("Accept","application/json")
        .url(ripeapi+ip)
        .build();

    //System.out.println(request.headers());
    try(Response response=okHttpClient.newCall(request).execute()) {
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        assert response.body() != null;
        return getjson(response.body().string());
    }
}


//    public  void write(byte [] bb) throws IOException {
//        FileOutputStream fileOutputStream=new FileOutputStream(new File("src/main/resources/hello"));
//        fileOutputStream.write(bb);
//        fileOutputStream.close();
//    }


    public String  getjson(String s) throws FileNotFoundException { //获取 返回体的json符串形式
//        Scanner scanner=new Scanner(new File("src/main/resources/hello.txt"));
//        while (scanner.hasNext()) s += scanner.next();
        //getAsJsonObject("objects"); 从对象中取出 objects 的值 作为 JsonObject
        JsonElement je= JsonParser.parseString(s).getAsJsonObject().getAsJsonObject("objects").getAsJsonArray("object");
//				for(Map.Entry<String,JsonElement> entry :je.getAsJsonObject().entrySet()){
//					System.out.println(entry);
//				}
        int flag =0;
        String  [] fls=new String[]{":",","};
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("{");
        for (JsonElement j:je.getAsJsonArray()) {
            for (Map.Entry<String, JsonElement> entry : j.getAsJsonObject().entrySet()) {
                if("attributes".equals((String)entry.getKey() ))	{
//			System.out.println(entry.getValue().getAsJsonObject().getAsJsonArray("attribute"));
                    for(JsonElement li: entry.getValue().getAsJsonObject().getAsJsonArray("attribute")){
//				System.out.println(li.getAsJsonObject());
                        for(Map.Entry<String, JsonElement> i:li.getAsJsonObject().entrySet())
                        {
                            if("name".equals((String)i.getKey())|"value".equals((String)i.getKey() )) {
//			           System.out.println(i.getValue().getAsString());
                                stringBuilder.append("\"").append(i.getValue().getAsString()).append("\"").append(fls[flag=flag==1?0:1]);  //0 1 循环遍历
                            }
//					System.out.println(i);
                        }
                    }
                }
            }
        }
        stringBuilder.append("}");
        return  GsonUtil.toJsonString(stringBuilder);//返回 json形式

    }


}
