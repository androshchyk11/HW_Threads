package com.company;

public class Printer implements Runnable {
    private Counter counter = new Counter();

    @Override
    public void run() {
        int i = 0;
        while (i < 1_000_000) {
            counter.run();
            System.out.println("value = " + counter.countValue);
            i += 1;
        }
    }
}
