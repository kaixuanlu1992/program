package com.work.base.se;

import org.apache.kafka.common.protocol.types.Field;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Consumer;

public enum  MyEnum {
    KK,MM;
    private String mkmk;
    MyEnum(String s){

    }
    MyEnum(){

    }
    public static void main(String[] args) {
        System.out.println(MyEnum.KK.compareTo(MyEnum.MM));
        System.out.println(MyEnum.KK.getDeclaringClass());
        System.out.println(MyEnum.valueOf("KK").ordinal());
        int [][][] a= {{{1,2,3}},{{4,5,6}}};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.deepToString(a));
        int [][] aa =new int[2][];

    }
}
