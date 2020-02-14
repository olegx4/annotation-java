import customAnnotations.CteateInstanceOfPrivateConstructor;
import customAnnotations.GetPrivateField;

public class Person {
    private int phoneNumber;
    @GetPrivateField(field = "name")
    private String name;
    @GetPrivateField(field = "surname")
    private String surname;

    public Person() {
        this.phoneNumber = 11_22_33;
        this.name = "Person";
        this.surname = "Person";
    }

    public Person(int phoneNumber, String name, String surname) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.surname = surname;
    }

    @CteateInstanceOfPrivateConstructor
    private Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
