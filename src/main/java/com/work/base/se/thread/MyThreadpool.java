package com.work.base.se.thread;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.AbstractChannel;
import io.netty.util.concurrent.EventExecutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyThreadpool {
    public static void main(String[] args) {
        ExecutorService poolExecutor = Executors.newFixedThreadPool(5);
        Future future = poolExecutor.submit(() -> {
            try {
                System.out.println("线程开始执行");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程开始结束");
        },5);

        try {
            Object rs = future.get();
            System.out.println("结束:" + rs);
            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        poolExecutor.shutdown();


    }
}
