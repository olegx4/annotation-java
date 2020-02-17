package annotationprocessors;

import customannotations.CreateInstanceOfPrivateConstructor;
import person.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class PrivateConstructorProcessor {
    public ArrayList<Person> process() {
        ArrayList<Person> persons = null;
        try {
            Class<?> examplePerson = Class.forName(Person.class.getName());
            Constructor<?>[] constructors = examplePerson.getDeclaredConstructors();
            Class<?>[] params = {String.class, String.class};
            Class<?>[] parameter = {int.class};
            persons = new ArrayList<>();
            for (Constructor<?> c : constructors) {
                if (c.isAnnotationPresent(CreateInstanceOfPrivateConstructor.class)) {
                    c.setAccessible(true);
                    if (c.equals(examplePerson.getDeclaredConstructor(parameter))) {
                        persons.add((Person) c.newInstance(c.getDeclaredAnnotation(CreateInstanceOfPrivateConstructor.class).phoneNumber()));
                    } else if (c.equals(examplePerson.getDeclaredConstructor(params))) {
                        persons.add((Person) c.newInstance(c.getDeclaredAnnotation(CreateInstanceOfPrivateConstructor.class).name(),
                                c.getDeclaredAnnotation(CreateInstanceOfPrivateConstructor.class).surname()));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
