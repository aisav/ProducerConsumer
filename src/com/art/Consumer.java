package com.art;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by art on 18.04.2017.
 */
class Consumer extends Thread {
    private Queue<Integer> dataQueue;
    private int number;

    public Consumer(LinkedList<Integer> c, int number) {
        dataQueue = c;
        this.number = number;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
            }
            if (dataQueue.isEmpty()) {
//                stay until
            }
            value = dataQueue.poll();
            System.out.println("Consumer #" + this.number + " got: " + value);

        }
    }
}
