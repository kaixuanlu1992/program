package com.work.base.se.nio;


import javax.annotation.processing.AbstractProcessor;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class BufferTest {
    public static void main( String[] args ){
//       byte[]bytes="112121212122333434".getBytes();
//        ByteBuffer buffer=ByteBuffer.allocate(100);
//        buffer.put(bytes);
//        buffer.put(bytes);
//        System.out.println(buffer);
//
//        System.out.println((char)buffer.get(1));
//
//
//
//        System.out.println(buffer);
//        buffer.flip();
//        buffer.put("abc".getBytes());
//
//        System.out.println(buffer);
//
        ByteBuffer buffer1=ByteBuffer.allocate(10);
        buffer1.put("hello".getBytes());
        System.out.println(buffer1.hasArray());
        System.out.println(new String(buffer1.array()));

    }
}
