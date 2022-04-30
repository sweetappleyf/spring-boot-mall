package com.yfmal.service.util;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class LogUtil {

    private static String path = "d:/aaa.log";

    private static FileOutputStream fos;

    static {
        try {
            fos = new FileOutputStream(path);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void log(String msg){
        try {
            fos.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
