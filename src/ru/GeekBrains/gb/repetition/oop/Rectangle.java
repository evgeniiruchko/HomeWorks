package ru.GeekBrains.gb.repetition.oop;

public class Rectangle extends Shape{
    @Override
    void paint() {
        System.out.println("нарисовали прямоугольник");
    }

    @Override
    void erase() {
        System.out.println("Стёрли прямоугольник");
    }
}
