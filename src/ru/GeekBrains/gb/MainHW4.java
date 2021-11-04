package ru.GeekBrains.gb;

import java.util.ListIterator;

public class MainHW4 {
    public static void main(String[] args) {
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        ListIterator<Integer> listIterator = stack.listIterator();
        System.out.println(listIterator.hasNext());

        while (listIterator.hasNext()) {
            System.out.println("next index: " + listIterator.nextIndex() + " prev index: " + listIterator.previousIndex());
            System.out.println("next item: " + listIterator.next());
        }

        while (listIterator.hasPrevious()) {
            System.out.println("prev item: " + listIterator.previous());
            System.out.println("next index: " + listIterator.nextIndex() + " prev index: " + listIterator.previousIndex());
        }

        while (!stack.isEmpty()){
            System.out.println(stack.remove());
        }
    }
}
