package com.work.base.se.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class IOTimeClient {
    private static final int port = 7080;
    public static void main(String[] args){
        Socket socket=null;
        BufferedReader in=null;
        PrintWriter out=null;
        try{
            socket=new Socket("127.0.0.1",port);
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            out.println("query time order");
            System.out.println("send order server succeed");
            String resp =in.readLine();
            System.out.println(resp);
        } catch (Exception e) {

        }finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out!=null){
                out.close();
                out=null;
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
