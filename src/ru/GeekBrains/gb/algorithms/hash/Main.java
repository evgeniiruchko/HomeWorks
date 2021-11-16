package ru.GeekBrains.gb.algorithms.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ChainingHashMap<Integer, Integer> map = new ChainingHashMap<>(10);
        for (int i = 0; i < 9; i++) {
            map.put(i, random.nextInt(100));
        }
        System.out.println(map);
        map.remove(0);
        map.remove(5);
        System.out.println(map);
    }
}
