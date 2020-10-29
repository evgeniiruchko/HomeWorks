package ru.GeekBrains.gb;

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
}
