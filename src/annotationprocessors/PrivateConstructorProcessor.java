package annotationprocessors;

import customannotations.CreateInstanceOfPrivateConstructor;
import person.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class PrivateConstructorProcessor {
    private final System.Logger logger = System.getLogger("PrivateConstructorProcessor");

    public ArrayList<Person> process() {
        ArrayList<Person> persons = new ArrayList<>();
        try {
            final Class<?> examplePerson = Class.forName(Person.class.getName());
            final Constructor<?>[] constructors = examplePerson.getDeclaredConstructors();
            final Class<?>[] params = {String.class, String.class};
            final Class<?>[] parameter = {int.class};
            final Class<CreateInstanceOfPrivateConstructor> instanceOfPrivateConstructor = CreateInstanceOfPrivateConstructor.class;
            for (Constructor<?> c : constructors) {
                if (c.isAnnotationPresent(instanceOfPrivateConstructor)) {
                    c.setAccessible(true);
                    if (c.equals(examplePerson.getDeclaredConstructor(parameter))) {
                        persons.add((Person) c.newInstance(c.getDeclaredAnnotation(instanceOfPrivateConstructor).phoneNumber()));
                    } else if (c.equals(examplePerson.getDeclaredConstructor(params))) {
                        persons.add((Person) c.newInstance(c.getDeclaredAnnotation(instanceOfPrivateConstructor).name(),
                                c.getDeclaredAnnotation(instanceOfPrivateConstructor).surname()));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            logger.log(System.Logger.Level.ERROR, "Constructor is inaccessible");
        } catch (InvocationTargetException e) {
            logger.log(System.Logger.Level.ERROR, "The constructor throws an Exception");
        } catch (InstantiationException e) {
            logger.log(System.Logger.Level.ERROR, "The class that declares the underlying constructor represents an abstract class");
        } catch (ClassNotFoundException e) {
            logger.log(System.Logger.Level.ERROR, "Unable to find method in the Person class");
        } catch (NoSuchMethodException e) {
            logger.log(System.Logger.Level.ERROR, "Cannot find a matching method");
        }
        return persons;
    }
}
