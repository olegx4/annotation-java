@MyAnnotations.Test
public class Person {

    private int phoneNumber;

    @MyAnnotations.PrivateField(field = "name")
    private String name;

    @MyAnnotations.PrivateField(field = "surname")
    private String surname;

    @MyAnnotations.DefaultConstructor
    public Person() {
        phoneNumber = 11_22_33;
        name = "Person";
        surname = "Person";
    }

    public Person(int phoneNumber, String name, String surname) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.surname = surname;
    }

    @MyAnnotations.PrivateConstructor
    private Person(String name, String surname) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
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

    private void output() {
        System.out.println("Surname: " + surname + " Name: " + name + " Phone: " + phoneNumber);
    }
}
