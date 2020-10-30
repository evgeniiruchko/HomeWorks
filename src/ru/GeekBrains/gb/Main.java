package ru.GeekBrains.gb;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int homeWorkNumber;

        System.out.print("Домашнее задание к какому номеру урока будем проверять? ");
        homeWorkNumber = in.nextInt();

        switch (homeWorkNumber) {
            case 1:
                HomeWork1.RunHomeWork1();
                break;
            default:
                System.out.println("Такого ДЗ не существует");
        }
    }
}
