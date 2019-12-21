package com.company;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread counterThread = new Thread(counter);
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer);

        counterThread.start();
        printerThread.start();

    }
}
