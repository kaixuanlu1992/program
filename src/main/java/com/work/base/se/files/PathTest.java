package com.work.base.se.files;

import org.apache.ibatis.annotations.SelectKey;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.InterruptibleChannel;
import java.nio.channels.SelectionKey;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

public class PathTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("PathTest.java");
        Path p = Paths.get("src/main/java/com/work/base/se/files","PathTest.java").toAbsolutePath();

        System.out.println(path.endsWith(".java"));

        System.out.println(p.endsWith(".java"));



//        testPathBases();
//        testPathModify();
    }


    private static void testPathBases() {
        System.out.println(System.getProperty("os.name"));
        Path path = Paths.get("D:", "program", "file");
        info(path);
        Path p = Paths.get("PathTest.java").toAbsolutePath();
        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
        }

        System.out.println(p.endsWith("files"));
        for(Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }

        System.out.println(Paths.get("PathTest.java").toAbsolutePath());

    }

    static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }

    static void info(Path p) {
        show("toString", p);
        show("Exists", Files.exists(p));
        show("RegularFile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("******************");
    }

    static void testPathModify(){

        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("src/main/java/com/work/base/se/files","PathTest.java").toAbsolutePath();
        show(1, p);
        Path convoluted = p.getParent().getParent()
                .resolve("strings").resolve("..")
                .resolve(p.getParent().getFileName());
        show(2, convoluted);
        show(3, convoluted.normalize());
        Path p2 = Paths.get("..", "..");
        show(4, p2);
        show(5, p2.normalize());
        show(6, p2.toAbsolutePath().normalize());
        Path p3 = Paths.get(".").toAbsolutePath();
        Path p4 = p3.resolve(p2);
        show(7, p4);
        show(8, p4.normalize());
        Path p5 = Paths.get("").toAbsolutePath();
        show(9, p5);
        show(10, p5.resolveSibling("strings"));
        show(11, Paths.get("nonexistent"));
    }

    static void show(int id, Path result) {
        Path base = Paths.get("..").toAbsolutePath().normalize();
        System.out.println(base);
        if(result.isAbsolute())
            System.out.println("(" + id + ")r " + base.relativize(result));
        else
            System.out.println("(" + id + ") " + result);
        try {
            System.out.println("RealPath: " + result.toRealPath());
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
