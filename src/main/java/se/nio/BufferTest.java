package se.nio;

import scala.Array;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;

public class BufferTest {
    public static void main( String[] args ){
       byte[]bytes="112121212122333434".getBytes();
        ByteBuffer buffer=ByteBuffer.allocate(100);
        buffer.put(bytes);
        buffer.put(bytes);
        System.out.println(buffer);

        System.out.println((char)buffer.get(1));



        System.out.println(buffer);
        buffer.flip();
        buffer.put("abc".getBytes());

        System.out.println(buffer);

    }
}
