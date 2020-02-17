package person;

import customannotations.CreateInstanceOfPrivateConstructor;
import customannotations.GetPrivateField;

public class Person {
    private int phoneNumber;
    @GetPrivateField(field = "name")
    private final String name;
    @GetPrivateField(field = "surname")
    private final String surname;

    public Person() {
        this.phoneNumber = 11_22_33;
        this.name = "name";
        this.surname = "surname";
    }

    public Person(int phoneNumber, String name, String surname) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.surname = surname;
    }

    @CreateInstanceOfPrivateConstructor()
    private Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @CreateInstanceOfPrivateConstructor()
    private Person(int number) {
        this.phoneNumber = number;
        this.name = "name";
        this.surname = "surname";
    }

    @Override
    public String toString() {
        return "Person{" +
                "phoneNumber=" + phoneNumber +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
