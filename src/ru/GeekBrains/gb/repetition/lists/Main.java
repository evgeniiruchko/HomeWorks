package ru.GeekBrains.gb.repetition.lists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.insertFirst(1);
        myLinkedList.insertFirst(2);
        myLinkedList.insertLast(4);
        myLinkedList.insertLast(5);
        myLinkedList.insert(2, 9);
        myLinkedList.delete(4);

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }

        System.out.print(System.lineSeparator());

        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1,4);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
