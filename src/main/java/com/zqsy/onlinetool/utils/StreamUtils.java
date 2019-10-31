package com.zqsy.onlinetool.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtils {

    public static byte[] toByteArray(InputStream in){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes;
        try {
            bytes = new byte[1024];
            int n;
            while ((n = in.read(bytes)) != -1){
                byteArrayOutputStream.write(bytes, 0, n);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e) {
        } finally {
            bytes = byteArrayOutputStream.toByteArray();
            if(null != byteArrayOutputStream){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }

}