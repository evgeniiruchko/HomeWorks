package ru.GeekBrains.gb.algorithms.tree;

public class Main {
    public static void main(String[] args) {
        int value;
        int balance = 0, notBalance = 0;
        for (int i = 0; i < 1000000; i++) {
            Tree tree = new Tree();
            while (true) {
                value = (int) (Math.random() * 200 - 100);
                tree.insert(value);
                if (tree.getHeight(tree.getRoot()) == 7) {
                    tree.delete(value);
                    break;
                }
            }
            if (tree.isBalance(tree.getRoot())) balance++;
            else notBalance++;
        }

        System.out.println("Сбалансированных " + balance + "; Не сбалансированных " + notBalance);
    }
}
