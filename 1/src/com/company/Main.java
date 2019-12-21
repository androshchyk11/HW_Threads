package com.company;

public class Main {


    public static void main(String[] args) {
        startProgram();
    }

    private static void bombMessage() {
        System.out.println("Bomb");
    }

    private static void startProgram() {
        Runnable runnable = () -> {
            for (int i = 0; i <= 10; i++) {
                System.out.println("counter to 10 = " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bombMessage();
        };
        Thread newThread = new Thread(runnable);
        newThread.start();
    }
}
