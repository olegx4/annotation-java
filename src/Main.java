import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void printData(String name, String surname) {
        System.out.println(name + " " + surname);
    }

    public static String getPrivateFieldValue(Object ob, String fieldName ) {
        //Get private field in class Person
        try {
            Field fieldSurname = ob.getClass().getDeclaredField(fieldName);
            fieldSurname.setAccessible(true);
            return (String) fieldSurname.get(ob);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.err.println(e);
            return "";
        }
    }

    public static void main(String[] args) {
        Person person = new Person(45_67_48, "Oleg", "ShapIK");
        String name = person.getName();
        String surname = null;
        printData(name, surname);

         surname = getPrivateFieldValue(person, "surname");
        printData(name, surname);

        //Call private method in class Person
        try {
            Method printMethod = person.getClass().getDeclaredMethod("output");
            printMethod.setAccessible(true);
            printMethod.invoke(person);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //Create instance of Person
        try {
            Person person1 = null;
            Class examplePerson = Class.forName(Person.class.getName());
            person1 = (Person) examplePerson.newInstance();
            printData(person1.getName(), getPrivateFieldValue(person1, "surname"));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        //Create instance with private constructor of class Person
        try {
            Person person2 = null;
            Class examplePerson = Class.forName(Person.class.getName());
            Class[] params = {String.class, String.class};

            Constructor exampleConstructor = examplePerson.getDeclaredConstructor(/*String.class, String.class*/params);
            exampleConstructor.setAccessible(true);
            person2 = (Person) exampleConstructor.newInstance("Vasya", "Pupkin");
            printData(person2.getName(), getPrivateFieldValue(person2, "surname"));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
