package com.yusif.nativeipcheck.utils;

import java.util.LinkedList;
//多个byte 数组合并
public class BytesCombin {
    public LinkedList<Byte> bytescombin(byte[]...bs ){ //合并多个byte数组
        LinkedList<Byte> bytes=new LinkedList<>();
        for (byte[] b:bs){
            for (byte i:b){
                bytes.add(i);
            }
        }
        return  bytes;
    }
}
