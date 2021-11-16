package ru.GeekBrains.gb.repetition.oop;

public class Circle extends Shape{
    @Override
    void paint() {
        System.out.println("нарисовали круг");
    }

    @Override
    void erase() {
        System.out.println("Стёрли круг");
    }
}
