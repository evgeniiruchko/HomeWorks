package ru.GeekBrains.gb;
import java.util.Scanner;

public class HomeWork1 {

    public static float task3 (float a, float b, float c, float d) {
        float result = a * (b + (c / d));
        return result;
    }

    public static boolean task4 (int a, int b) {
        boolean result = true;
        if (a + b >=10 && a + b <=20)  // { } не ставлю потому что 1 действие, а так помню про них
            return result;
        else
            return !result;
    }

    public static String task5 (int a) {
        String str = "";
        if (a >= 0)
            str = "Положительное";
        else
            str = "отрицательное";
        return str;
    }

    public static boolean task6 (int a) {
        boolean result = true;
        if (a < 0)  // { } не ставлю потому что 1 действие, а так помню про них
            return result;
        else
            return !result;
    }

    public static String task7 (String name) {
        return "Привет, " + name + "!";
    }

    public static String task8 (int year) {
        String result = "Високосный";
        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))
        result = "Не високосный";
        if (year<0)
            result = "До нашей эры что ли?";
        return result;
    }

    public static void RunHomeWork1(){
        Scanner in = new Scanner(System.in);

        float a, b, c, d;
        int i, j;
        String name;
        short year;

        System.out.println("Задание №3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода");
        System.out.print("Введите a: ");
        a = in.nextFloat();
        System.out.print("Введите b: ");
        b = in.nextFloat();
        System.out.print("Введите c: ");
        c = in.nextFloat();
        System.out.print("Введите d: ");
        d = in.nextFloat();
        System.out.println("Результат = " + HomeWork1.task3(a, b, c, d));

        System.out.println("Задание №4: Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;");
        System.out.print("Введите первое число: ");
        i = in.nextInt();
        System.out.print("Введите второе число: ");
        j = in.nextInt();
        System.out.println("Результат = " + HomeWork1.task4(i, j));

        System.out.println("Задание №5: Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.");
        System.out.print("Введите целое число: ");
        i = in.nextInt();
        System.out.println("Результат = " + HomeWork1.task5(i));

        System.out.println("Задание №6: Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное");
        System.out.print("Введите целое число: ");
        i = in.nextInt();
        System.out.println("Результат = " + HomeWork1.task6(i));

        System.out.println("Задание №7: Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение 'Привет, указанное_имя!'");
        System.out.print("Введите имя: ");
        name = in.next();
        System.out.println(HomeWork1.task7(name));

        System.out.println("* Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный");
        System.out.print("Введите год: ");
        year = in.nextShort();
        System.out.println(HomeWork1.task8(year));
    }
}
