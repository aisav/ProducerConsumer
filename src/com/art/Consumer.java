package com.art;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

/**
 * Created by art on 18.04.2017.
 */

class Consumer implements Runnable{

    private final BlockingQueue dataQueue;
    private final int number;

    public Consumer (BlockingQueue dataQueue, int i) {
        this.dataQueue = dataQueue;
        this.number = i;
    }

    @Override
    public void run() {
        while(true){
            try {
                sleep((int)(Math.random() * 100));
                System.out.println("Consumer#"+ number + " Value: " + dataQueue.take());
            } catch (InterruptedException ex) {}
        }
    }


}