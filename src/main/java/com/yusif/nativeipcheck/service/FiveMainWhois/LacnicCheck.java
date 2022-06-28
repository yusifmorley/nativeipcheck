package com.yusif.nativeipcheck.service.FiveMainWhois;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
//拉丁美洲和加勒比群岛
public class LacnicCheck {
public String lacnicapi="https://rdap.registro.br/ip/";

    @Autowired
    OkHttpClient okHttpClient;
    @Autowired
    Request.Builder builder;
public String check(String ip){
    Request request=builder
            .url(lacnicapi+ip)
            .addHeader("Accept","application/json, text/plain, */*")//构建  url
            .build();
    try(Response response=okHttpClient.newCall(request).execute()) {
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        assert response.body() != null;
        System.out.println(response.body().string());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return  "";
}
public String getjson(String s ){
    JsonElement je= JsonParser.parseString(s).getAsJsonObject().getAsJsonObject("objects").getAsJsonArray("object");
    System.out.println(je);

    return "";
}


}
