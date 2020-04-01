package com.work.base.se.jvm;

import java.util.ArrayList;
import java.util.List;

public class ConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        int i =0;
        try {
            while (true){
                list.add(String.valueOf(i++).intern());
            }
        }catch (Throwable e){
            System.out.println("----i"+i);
            throw e;
        }

    }
}
