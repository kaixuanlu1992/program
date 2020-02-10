package com.work.base.se.annotation;

import com.process.TestAnnotation;

public class HelloSourceAnnotation {

    @TestAnnotation(value = 5,name = "my")
    private static String message = "Hello World";

    public static void main(String[] args) {
        System.out.println(message);
    }
}
