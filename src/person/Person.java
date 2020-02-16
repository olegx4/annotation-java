package person;

import customannotations.CreateInstanceOfPrivateConstructor;
import customannotations.GetPrivateField;

public class Person {
    private int phoneNumber;
    @GetPrivateField(field = "name")
    private String name;
    @GetPrivateField(field = "surname")
    private String surname;

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

    @CreateInstanceOfPrivateConstructor
    private Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "personInitializer.Person{" +
                "phoneNumber=" + phoneNumber +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
