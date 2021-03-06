package com.work.base.se.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;//需要在构造函数初始化

    public EvenChecker(IntGenerator g, int ident){
        generator=g;
        id=ident;
    }
    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val = generator.next();
            if (val%2!=0){
                System.out.println(val+ " not even!");
                generator.cancel();
            }
        }
    }
    public static void test(IntGenerator gp, int count){
        System.out.println("press control-c to exit");
        ExecutorService exce = Executors.newCachedThreadPool();
        for (int i=0;i<count;i++){
            exce.execute(new EvenChecker(gp,count));
        }
        exce.shutdown();
    }

    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
