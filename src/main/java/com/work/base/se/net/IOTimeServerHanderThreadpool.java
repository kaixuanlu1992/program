package com.work.base.se.net;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class IOTimeServerHanderThreadpool {
    private ExecutorService executorService;

    public IOTimeServerHanderThreadpool(int maxSize, int queneSize){
        executorService=new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxSize,
                120L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queneSize));
    }
    public void execute(Runnable task){
        executorService.execute(task);
    }
}
