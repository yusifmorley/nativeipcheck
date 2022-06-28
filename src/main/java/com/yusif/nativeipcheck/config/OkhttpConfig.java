package com.yusif.nativeipcheck.config;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkhttpConfig {
@Bean
    public OkHttpClient getokhttp(){
    return  new OkHttpClient();
}
@Bean
    public Request.Builder getrequst(){
    return new Request.Builder();
}

}
