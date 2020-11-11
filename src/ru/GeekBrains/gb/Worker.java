/*
* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
* Конструктор класса должен заполнять эти поля при создании объекта;
* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
* Создать массив из 5 сотрудников

Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);
* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */

package ru.GeekBrains.gb;

public class Worker {
    String name;
    String job;
    String email;
    String phoneNumber;
    float pay;
    int age;

    Worker (String name, String job, String email, String phoneNumber, float pay, int age){
        this.name = name;
        this.job = job;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pay = pay;
        this.age = age;
    }

    void PrintInfo (){
        System.out.println("ФИО: " + name);
        System.out.println("Должность: " + job);
        System.out.println("e-mail: " + email);
        System.out.println("Номер телефона" + phoneNumber);
        System.out.println("Зарплата: " + pay);
        System.out.println("Возраст: " + age);
        System.out.println("=================");
    }

}
