package com.yusif.nativeipcheck.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
//把二进制文件转 byte数组
public class ReadBinFromFile {
    public  static byte[] binfiletobyte(String fp) throws IOException {
        FileInputStream fi=new FileInputStream(new File(fp));
        LinkedList<Integer> ints=new LinkedList<>();
        int value;
        while ((value=fi.read())!=-1){
            ints.add(value);
        }
        byte[] bys=new byte[ints.size()];
        int i=0;
        for (int s:ints) bys[i++] = (byte) s;
        return  bys;
    }
}
