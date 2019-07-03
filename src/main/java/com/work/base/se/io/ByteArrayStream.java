//package com.work.base.se.io;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.*;
//
//@Slf4j
//public class ByteArrayStream {
//    public static void main(String[] args) throws IOException {
//        byte[] b = {'a', 'c', 'c', 'd', 'f', 'r', 'e', 'q', 'j', 'i', 23, 34, 67};
//        InputStream byteArrayInputStream = new ByteArrayInputStream(b);
//        log.info(String.valueOf(byteArrayInputStream.read()));
//        byteArrayInputStream.skip(5);
//        log.info(String.valueOf(byteArrayInputStream.read()));
//        byte[] temp=new byte[5];
//        byteArrayInputStream.read(temp,0,2);
//        log.info(new String(temp));
//        byteArrayInputStream.close();
//
//        OutputStream out=new ByteArrayOutputStream(64);
//        out.write(66);
//        out.write(b,0,8);
//        log.info(out.toString());
//
//
//    }
//}
