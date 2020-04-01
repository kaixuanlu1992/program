package com.work.base.se.jvm;

public class StackOOM {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    private void donotStop(){
        while (true){

        }
    }

    public void stackLeakByThread() {
        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    donotStop();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        StackOOM oom = new StackOOM();
        try {
//            oom.stackLeak();
            oom.stackLeakByThread();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
