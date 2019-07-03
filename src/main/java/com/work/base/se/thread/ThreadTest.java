package com.work.base.se.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    public static void main(String[] args){
        Lock lock=new ReentrantLock();

        class MyThread implements Runnable{
             int ticket=100;
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
//                    lock.lock();
                    if (ticket > 0) {
                        ticket=ticket-1;
                        System.out.println(Thread.currentThread().getName() + "------ticket:----" + (ticket));
                    }
//                    lock.unlock();
                }
            }
        }

        MyThread myThread=new MyThread();
        for (int i=0;i<10;i++){
            new Thread(myThread).start();
        }

    }





}


