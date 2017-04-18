package com.art;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String args[]) {

        BlockingQueue dataQueue = new LinkedBlockingQueue();

        Scanner scan = new Scanner(System.in);
        int n, m;
        System.out.print("Please Enter the Producers count: ");
        try {
            n = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("You are input incorrect number.The value will be 10.");
            n = 10;
        }


        System.out.print("Please Enter the Consumers count: ");
        try {
            m = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("You are input incorrect number. The value will be 10.");
            m = 10;
        }


        cheduledPrintQueueSize(dataQueue);

        for (int i = 1; i <= n; i++) {
            Thread prodThread = new Thread(new Producer(dataQueue, i));
            prodThread.start();

        }
        for (int i = 1; i <= m; i++) {
            Thread consThread = new Thread(new Consumer(dataQueue, i));
            consThread.start();
        }


    }


    private static void cheduledPrintQueueSize(BlockingQueue dataQueue) {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(dataQueue.size());
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
