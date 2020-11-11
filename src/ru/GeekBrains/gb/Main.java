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
            case 2:
                HomeWork2.RunHomeWork2();
                break;
            case 3:
                HomeWork3.RunHomeWork3();
                break;
            case 4:
                GameXO.runGameXO();
                break;
            case 5:
                Worker[] workArray = new Worker[5];
                workArray[0] = new Worker("Иванов Иван Иванович","Директор", "ivanovII@mail.ru", "9600000001", 100, 55);
                workArray[1] = new Worker("Петров Пётр Петрович","Зам директора", "PetrovPP@mail.ru", "9600000002", 90, 45);
                workArray[2] = new Worker("Складов Сергей Анатольевич","Кладовщик", "skladovSA@mail.ru", "9600000003", 70, 30);
                workArray[3] = new Worker("Колесов Владимир Владимирович","Водитель", "kolesovVV@mail.ru", "9600000004", 70, 40);
                workArray[4] = new Worker("Приносов Антон Антонович","Грузчик", "gruz@mail.ru", "9600000005", 40, 20);
                for (int i = 0; i < workArray.length; i++){
                    if (workArray[i].age > 40){
                        workArray[i].PrintInfo();
                    }
                }

                break;
            default:
                System.out.println("Такого ДЗ не существует");
        }
    }
}
