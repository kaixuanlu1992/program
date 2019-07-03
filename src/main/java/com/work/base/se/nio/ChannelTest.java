package com.work.base.se.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.*;

@Slf4j
public class ChannelTest {
    public static void main( String[] args ) throws IOException {
        String file="D:/test.txt";
        File file1=new File(file);
        if (!file1.exists()){
            file1.createNewFile();
        }
        RandomAccessFile rf=new RandomAccessFile(file1,"rw");
        FileChannel fileChannel=rf.getChannel();
        byte[] src={1,2,3,4,5,6,7,8,8,9,9,9,9,9,9,9,9,9};
        ByteBuffer buf=ByteBuffer.allocate(100);
        buf.put(src);
        buf.flip();
        System.out.println(String.valueOf(fileChannel.write(buf)));
        System.out.println(fileChannel.position());
        fileChannel.force(false);
        //fileChannel.position(0);
        ByteBuffer dst=ByteBuffer.allocate(100);
        fileChannel.read(dst);
//        dst.flip();
        System.out.println(new String(dst.array()));
        System.out.println(new String(dst.array()));

    }
    void test() throws IOException{
        ReadableByteChannel source = Channels.newChannel (System.in);
        WritableByteChannel dest = Channels.newChannel (System.out);
        channelCopy1 (source, dest);
        source.close( );
        dest.close( );
    }

    private static void channelCopy1 (ReadableByteChannel src, WritableByteChannel dest) throws IOException
    {
        ByteBuffer buffer = ByteBuffer.allocateDirect (16 * 1024);
        while (src.read (buffer) != -1) {
            buffer.flip( );
            dest.write (buffer);
            buffer.compact( );
        }
        buffer.flip( );
        while (buffer.hasRemaining( )) {
            dest.write (buffer);
        }
    }
}
