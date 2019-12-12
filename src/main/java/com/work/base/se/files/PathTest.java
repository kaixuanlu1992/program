package com.work.base.se.files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
        testPathBases();
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
}
