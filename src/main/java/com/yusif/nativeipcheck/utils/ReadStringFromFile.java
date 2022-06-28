package com.yusif.nativeipcheck.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//从文件中读取所有字符串

public class ReadStringFromFile {

    public static String getstring(String ps) throws FileNotFoundException {
        Scanner scanner =new Scanner(new File(ps));
        StringBuilder stringBuilder=new StringBuilder();
        while (scanner.hasNextLine()){
            stringBuilder.append(scanner.nextLine()).append("\n");
        }
        return  stringBuilder.toString();
    }

}
