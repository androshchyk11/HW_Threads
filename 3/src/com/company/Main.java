package com.company;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    private static int switcher;
    private static int setValue = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        switcher = scanner.nextInt();

        if (switcher == 10) {
            writeAndOutputOfHashMap();
        } else if (switcher == 20) {
            writeAndOutputOfConcurrentHashMap();
        }
    }

    private static void writeAndOutputOfConcurrentHashMap()  {
        Runnable runnable = () -> {
            Stream<ValuesForMap> first = Stream.of(new ValuesForMap(1, "1"), new ValuesForMap(2, "2"), new ValuesForMap(3, "3"));
            first.collect(Collectors.toConcurrentMap(ValuesForMap::getValue, ValuesForMap::getKey))
                    .forEach((integer, s) -> System.out.println("Key: " + integer + ", Value: " + s));
        };
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread1 = new Thread(runnable);
            thread1.start();
        }
    }

    private static void writeAndOutputOfHashMap() {
        Runnable runnable1 = () -> {
            Stream<ValuesForMap> first = Stream.of(new ValuesForMap(1, "1"), new ValuesForMap(2, "2"), new ValuesForMap(3, "3"));
            first.collect(Collectors.toMap(ValuesForMap::getValue, ValuesForMap::getKey))
                    .forEach((integer, s) -> System.out.println("Key: " + integer + ", Value: " + s));
        };
        for (int i = 0; i < 6; i++) {
            Thread thread = new Thread(runnable1);
            thread.start();

        }
    }
}
