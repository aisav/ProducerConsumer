package com.art;

import java.util.LinkedList;
import java.util.concurrent.*;

public class Main {
    public static void main(String args[]){

        BlockingQueue dataQueue = new LinkedBlockingQueue();

        cheduledPrintQueueSize(dataQueue);


        for(int i=1; i<=10; i++) {
            Thread prodThread = new Thread(new Producer(dataQueue, i));
            Thread consThread = new Thread(new Consumer(dataQueue, i));

            prodThread.start();
            consThread.start();
        }
    }

    private static void cheduledPrintQueueSize(BlockingQueue dataQueue){
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(dataQueue.size());
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
