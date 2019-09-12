package com.work.base.se.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainThread {
    public static void main(String[] args) {
        taskWithResult();
    }

    public static void mainThreadRun() {
        LiftOff luanch = new LiftOff();
        luanch.run();
    }

    public static void basicThreads() {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("waiting for thread");
    }

    public static void moreBasicThreads() {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new LiftOff());
            t.start();
            System.out.println("waiting for thread");
        }
    }

    public static void taskWithResult() {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<String>> rs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rs.add(executor.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs:rs){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
