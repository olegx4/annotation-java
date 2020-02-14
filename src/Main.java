import annotationProcessors.GetPrivateFieldProcessor;

import java.lang.reflect.Constructor;
import java.util.Map;

public class Main {
    public static void printData(String name, String surname) {
        System.out.println(name + " " + surname);
    }

    public static void main(String[] args) {
        Person person = new Person(45_67_48, "Oleg", "ShapIK");
        String name = null;
        String surname = null;
        printData(name, surname);
        Map<String, String> tmp;
        GetPrivateFieldProcessor getPrivateFieldProcessor = new GetPrivateFieldProcessor();
        tmp = getPrivateFieldProcessor.process(person);
        surname = tmp.get("surname");
        name = tmp.get("name");
        printData(name, surname);

        try {
            Person person1;
            Class examplePerson = Class.forName(Person.class.getName());
            person1 = (Person) examplePerson.getDeclaredConstructor().newInstance();
            tmp = getPrivateFieldProcessor.process(person1);
            printData(tmp.get("name"), tmp.get("surname"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Person person2;
            Class<?> examplePerson = Class.forName(Person.class.getName());
            Class<?>[] params = {String.class, String.class};
            Constructor exampleConstructor = examplePerson.getDeclaredConstructor(params);
            exampleConstructor.setAccessible(true);
            person2 = (Person) exampleConstructor.newInstance("Vasya", "Pupkin");
            tmp = getPrivateFieldProcessor.process(person2);
            printData(tmp.get("name"), tmp.get("surname"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
