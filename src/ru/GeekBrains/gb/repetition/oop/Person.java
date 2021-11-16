package ru.GeekBrains.gb.repetition.oop;

/*
Создать builder для класса Person со следующими полями: String firstName, String lastName, String middleName,
String country, String address, String phone, int age, String gender.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public Person(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public static PersonBuilder builder(String firstName, String lastName, String phone) {
        return new PersonBuilder(firstName, lastName, phone);
    }

    public static class PersonBuilder {
        private final Person person;

        private PersonBuilder(String firstName, String lastName, String phone) {
            person = new Person(firstName, lastName, phone);
        }

        public PersonBuilder withMiddleName(String middleName) {
            person.middleName = middleName;
            return this;
        }

        public PersonBuilder withCountry(String country) {
            person.country = country;
            return this;
        }

        public PersonBuilder withAddress(String address) {
            person.address = address;
            return this;
        }

        public PersonBuilder withAge(int age) {
            person.age = age;
            return this;
        }

        public PersonBuilder withGender(String gender) {
            person.gender = gender;
            return this;
        }

        public Person build() {
            return person;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
