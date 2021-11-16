package ru.GeekBrains.gb;

import java.util.Scanner;

public class MainAlg {
    public static void main(String[] args) {
        String s, newString = "";
        Scanner scanner = new Scanner(System.in);
        MyStack<String> myStackString = new MyStack<>();
        System.out.println("Введите строку: ");
        s = scanner.nextLine();
        //вариант 1 по теме урока
        for (int i = 0; i < s.length(); i++) {
            myStackString.push(s.substring(i, i + 1));
        }
        while (!myStackString.isEmpty()) {
            newString += myStackString.pop();
        }
        System.out.println(newString);

        //Вариант 2 без стека
        newString = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            newString += s.substring(i, i + 1);
        }
        System.out.println(newString);

        MyDec<Integer> myDec= new MyDec<>();
//        myDec.insertLeft(1);
//        myDec.insertLeft(2);
//        myDec.insertLeft(3);
        myDec.insertRight(13);
        myDec.insertRight(12);
        myDec.insertRight(11);
        myDec.insertLeft(1);
        myDec.insertLeft(2);
        myDec.insertLeft(3);
        System.out.println(myDec.removeRight());
        System.out.println(myDec.removeLeft());
        System.out.println(myDec.removeLeft());
        System.out.println(myDec.removeRight());
        System.out.println(myDec.removeLeft());
        System.out.println(myDec.removeLeft());
    }
}
