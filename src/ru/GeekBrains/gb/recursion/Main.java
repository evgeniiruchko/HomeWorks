package ru.GeekBrains.gb.recursion;

public class Main {
    static int[] costs = new int[]{10, 18, 3, 10, 20};
    static int[] weights = new int[]{8, 6, 4, 3, 21};
    static final int TOTAL_WEIGHT = 30;

    public static void main(String[] args) {
        System.out.println(exponentiation(3, 3));
        System.out.println(rucksack(costs.length - 1, TOTAL_WEIGHT));
    }

    public static long exponentiation(int number, int exp) {
        long result = 1;
        if (exp == 1) {
            return number;
        }
        result *= exponentiation(number, exp - 1) * number;
        return result;
    }

    private static int rucksack(int cost, int TOTAL_WEIGHT) {
        if (cost < 0) {
            return 0;
        }
        if (weights[cost] > TOTAL_WEIGHT) {
            return rucksack(cost - 1, TOTAL_WEIGHT);
        } else {
            return Math.max(rucksack(cost - 1, TOTAL_WEIGHT), rucksack(cost - 1, TOTAL_WEIGHT - weights[cost]) + costs[cost]);
        }
    }
}


