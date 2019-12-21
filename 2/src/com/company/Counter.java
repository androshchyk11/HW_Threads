package com.company;

public class Counter implements Runnable {
    int countValue = 0;

    @Override
    public void run() {
        countValue++;
    }
}
