package com.work.base.se;

import java.util.Arrays;

public class Strings {
    private String string="this, year is a great, year";
    public static void main(String[] args){
        Strings strings = new Strings();
        strings.regex();
        strings.split();
    }
    void regex(){
        System.out.println("\\");
        System.out.println("1234".matches("-?\\d+"));
        System.out.println("+1234".matches("(-|\\+)?\\d+"));
    }

    //split:将字符串从正则表达式匹配的地方切开
    void split(){
        System.out.println(Arrays.toString(string.split(" ")));
        System.out.println(Arrays.toString(string.split("\\W+")));
        System.out.println(Arrays.toString(string.split(",\\W+")));
    }
}
