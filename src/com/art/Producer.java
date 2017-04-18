package com.art;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

/**
 * Created by art on 18.04.2017.
 */

class Producer implements Runnable {

    private final BlockingQueue dataQueue;
    private final int number;

    public Producer(BlockingQueue dataQueue, int i) {
        this.dataQueue = dataQueue;
        this.number = i;
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep((int)(Math.random() * 100));

                if(dataQueue.size()>=100)
                while(dataQueue.size()>=80)
                    sleep(10);

                int generatedValue = (int)(Math.random() * 100);
                dataQueue.put(generatedValue);
                System.out.println("Producer#" + number + " Value: "+ generatedValue);
            } catch (InterruptedException ex) {}
        }
    }

}
