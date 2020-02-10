package com.work.base.se;

public class StringAndThread {
    private String str="abc";
    public static void main(String[] args) {
        StringAndThread stringAndThread=new StringAndThread();
        stringAndThread.test();
    }

    void test(){
        new Thread(()->{
            for (int i = 0;i< 10;i++){
                System.out.println(str);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0;i< 10;i++){
                str="00"+i;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
