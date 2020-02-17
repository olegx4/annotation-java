package annotationprocessors;

import customannotations.CreateInstanceOfPrivateConstructor;
import customannotations.GetPrivateField;
import person.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PrivateConstructorProcessor {
    public Person process() {
        Person person2 = new Person();
        try {
            Class<?> examplePerson = Class.forName(Person.class.getName());
            Class<?>[] params = {String.class, String.class};
            Constructor<?> exampleConstructor = examplePerson.getDeclaredConstructor(params);
            exampleConstructor.setAccessible(true);
            //person2 = (Person) exampleConstructor.newInstance(name, surname);
            if (exampleConstructor.isAnnotationPresent(CreateInstanceOfPrivateConstructor.class)) {
                exampleConstructor.setAccessible(true);
                person2 =  (Person) exampleConstructor.newInstance( exampleConstructor.getDeclaredAnnotation(CreateInstanceOfPrivateConstructor.class).name(),
                        exampleConstructor.getDeclaredAnnotation(CreateInstanceOfPrivateConstructor.class).surname());
              //  i++;
            //}
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
        return person2;
    }
}
