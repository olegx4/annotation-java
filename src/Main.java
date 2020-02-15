import Person.Person;
import Person.PersonInitializer;

import java.lang.reflect.Constructor;
import java.util.Map;

public class Main {
    public static void printData(String name, String surname) {
        System.out.println(name + " " + surname);
    }

    public static void main(String[] args) {
        Person person = new Person(45_67_48, "Oleg", "ShapIK");
        PersonInitializer personInitializer = new PersonInitializer();
        Map<String, String> tmp = personInitializer.getPrivateFieldProcessor.process(person);
        printData(tmp.get("surname"), tmp.get("name"));

        try {
            Person person1;
            Class<?> examplePerson = Class.forName(Person.class.getName());
            person1 = (Person) examplePerson.getDeclaredConstructor().newInstance();
            tmp = personInitializer.getPrivateFieldProcessor.process(person1);
            printData(tmp.get("name"), tmp.get("surname"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Person person2;
            Class<?> examplePerson = Class.forName(Person.class.getName());
            Class<?>[] params = {String.class, String.class};
            Constructor<?> exampleConstructor = examplePerson.getDeclaredConstructor(params);
            exampleConstructor.setAccessible(true);
            person2 = (Person) exampleConstructor.newInstance("Vasya", "Pupkin");
            tmp = personInitializer.getPrivateFieldProcessor.process(person2);
            printData(tmp.get("name"), tmp.get("surname"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
