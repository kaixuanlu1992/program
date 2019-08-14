package com.work.base.se.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class IOTimeServerWithThreadpool {
    private static final int port = 7080;
    private static final int maxPoolSize=50;
    private static final int queneSize=50;
    public static void main(String[] args) throws IOException {
        ServerSocket server =null;
        try{
            server=new ServerSocket(port);
            System.out.println("the server started in port : " + port);
            IOTimeServerHanderThreadpool serverHanderThreadpool=new IOTimeServerHanderThreadpool(maxPoolSize,queneSize);
            Socket socket=null;
            while (true){
                socket=server.accept();
                serverHanderThreadpool.execute(new TimeServerHandler(socket));
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
