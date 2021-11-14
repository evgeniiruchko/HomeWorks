package ru.GeekBrains.gb.repetition.oop;

public class Triangle extends Shape{
    @Override
    void paint() {
        System.out.println("нарисовали треугольник");
    }

    @Override
    void erase() {
        System.out.println("Стёрли треугольник");
    }
}
