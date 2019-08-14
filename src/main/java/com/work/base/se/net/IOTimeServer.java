package com.work.base.se.net;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class IOTimeServer {
    private static final int port = 7080;
    public static void main(String[] args) throws IOException {
        ServerSocket server =null;
        try{
            server=new ServerSocket(port);
            System.out.println("the server started in port : " + port);
            Socket socket=null;
            while (true){
                socket=server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server!=null){
                System.out.println("time server close");
                server.close();
                server=null;
            }
        }
    }
}
