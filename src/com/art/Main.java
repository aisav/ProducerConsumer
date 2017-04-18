package com.art;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String args[]){

        BlockingQueue dataQueue = new LinkedBlockingQueue();

        for(int i=1; i<=10; i++) {
            Thread prodThread = new Thread(new Producer(dataQueue, i));
            Thread consThread = new Thread(new Consumer(dataQueue, i));

            prodThread.start();
            consThread.start();
        }
    }
}
