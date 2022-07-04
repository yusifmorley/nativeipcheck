package com.yusif.nativeipcheck.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//封装 时间
public class MyDate {
    private String Pattern = "yyyy-MM-dd HH:mm:ss"; //时间格式

    public String getPattern() {
        return Pattern;
    }

    public void setPattern(String pattern) {
        Pattern = pattern;
    }



    public long getDuration(LocalDateTime start, LocalDateTime end) {//两个时间相减 返回天数
        Duration duration = Duration.between(start, end);
        return duration.toDays();
    }

    public LocalDateTime getTimeFromString(String time) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Pattern);
        return  LocalDateTime.parse(time,dtf);
    }
    public  String getNowTime(){
        return  LocalDateTime.now().format(DateTimeFormatter.ofPattern(Pattern));
    }




}
