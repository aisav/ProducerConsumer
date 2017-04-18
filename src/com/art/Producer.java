package com.art;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by art on 18.04.2017.
 */
class Producer extends Thread {
    private Queue<Integer> dataQueue;
    private int number;

    public Producer(LinkedList<Integer> c, int number) {
        dataQueue = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
            }
            if (dataQueue.size()>=100){
//                sleep until 80
            }
            int generatedValue = (int)(Math.random() * 100);
            System.out.println("Producer #" + this.number + " put: " + generatedValue);
            dataQueue.add(generatedValue);

        }
    }
}
