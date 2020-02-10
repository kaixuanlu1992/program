package com.work.base.se.collection;

import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class Test {
    static List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    static List<Integer> list1 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
    static List<Integer> list2 = new ArrayList<>(Arrays.asList(16, 17, 18, 19));


    public static void main(String[] args) {
        testList();
        testMap();
    }

    private static void testMap() {
        Map<String,String> map = new HashMap<>();
        new ArrayBlockingQueue<Integer>(3);
        map.put("name","123");
        map.put("age","23");
        System.out.println(map.getOrDefault("age1","111"));
    }

    private static void testList() {
        //retainAll
//        System.out.println(list.retainAll(list1) + "    " + list);
        System.out.println(list.retainAll(list2) + "    " + list);

    }
}
