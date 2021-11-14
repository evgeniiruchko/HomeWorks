package ru.GeekBrains.gb.repetition.oop;

public class Main {
    public static void main(String[] args) {
        Person person = Person.builder("John", "Lee", "999-001-71-71")
                .withCountry("Russia")
                .withAge(34)
                .withGender("M").build();

        System.out.println(person.toString());

    }
}
