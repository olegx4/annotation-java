import annotationProcessors.PrivateFieldProcessor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void printData(String name, String surname) {
        System.out.println(name + " " + surname);
    }

    public static void main(String[] args) {
        Person person = new Person(45_67_48, "Oleg", "ShapIK");
        String name = null; //person.getName();
        String surname = null;
        printData(name, surname);
        Map<String, String> tmp = new TreeMap<>();
        PrivateFieldProcessor pFp = new PrivateFieldProcessor();
        tmp = pFp.process(person);
        surname = tmp.get("surname"); //getPrivateFieldValue(person, "surname");
        name = tmp.get("name");
        printData(name, surname);

        try {
            Method printMethod = person.getClass().getDeclaredMethod("output");
            printMethod.setAccessible(true);
            printMethod.invoke(person);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Person person1 = null;
            Class examplePerson = Class.forName(Person.class.getName());
            person1 = (Person) examplePerson.newInstance();
            tmp = pFp.process(person1);
            printData(tmp.get("name"), tmp.get("surname"));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        try {
            Person person2 = null;
            Class examplePerson = Class.forName(Person.class.getName());
            Class[] params = {String.class, String.class};
            Constructor exampleConstructor = examplePerson.getDeclaredConstructor(/*String.class, String.class*/params);
            exampleConstructor.setAccessible(true);
            person2 = (Person) exampleConstructor.newInstance("Vasya", "Pupkin");
            tmp = pFp.process(person2);
            printData(tmp.get("name"), tmp.get("surname"));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
