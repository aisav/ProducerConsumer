package com.art;

import java.util.LinkedList;

public class Main {

    public static void main(String args[]) {
        LinkedList<Integer> c = new LinkedList<>();
        Producer p1 = new Producer(c, 1);
        Consumer c1 = new Consumer(c, 1);

        p1.start();
        c1.start();
    }
}
