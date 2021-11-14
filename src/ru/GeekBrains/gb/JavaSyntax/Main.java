package ru.GeekBrains.gb.JavaSyntax;
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
            case 2:
                HomeWork2.RunHomeWork2();
                break;
            case 3:
                HomeWork3.RunHomeWork3();
                break;
            case 4:
                GameXO.runGameXO();
                break;
            default:
                System.out.println("Такого ДЗ не существует");
        }
    }
}
