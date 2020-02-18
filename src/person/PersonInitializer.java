package person;

import annotationprocessors.PrivateFieldProcessor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class PersonInitializer {
    private final PrivateFieldProcessor privateFieldProcessor;
    private final System.Logger logger = System.getLogger("PersonInitializerLogger");

    public PersonInitializer() {
        this.privateFieldProcessor = new PrivateFieldProcessor();
    }

    public Map<String, String> getPrivateFields(Person person) {
        return privateFieldProcessor.process(person);
    }

    public Map<String, String> defaultInitialization() {
        Person person = null;
        try {
            Class<?> classObject = Class.forName(Person.class.getName());
            person = (Person) classObject.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            logger.log(System.Logger.Level.ERROR, "Cannot create instance of the Person class");
        } catch (IllegalAccessException e) {
            logger.log(System.Logger.Level.ERROR, "IllegalAccessException is observed when creating instance of Person class");
        } catch (InvocationTargetException e) {
            logger.log(System.Logger.Level.ERROR, "Exception was thrown by an invoked method or constructor");
        } catch (NoSuchMethodException e) {
            logger.log(System.Logger.Level.ERROR, "Unable to find matching method");
        } catch (ClassNotFoundException e) {
            logger.log(System.Logger.Level.ERROR, "Unable to find Person class");
        }
        return privateFieldProcessor.process(person);
    }

    public Map<String, String> initializePerson(String name, String surname) {
        Person person = new Person();
        try {
            final Class<?> examplePerson = Class.forName(Person.class.getName());
            final Class<?>[] params = {String.class, String.class};
            final Constructor<?> exampleConstructor = examplePerson.getDeclaredConstructor(params);
            exampleConstructor.setAccessible(true);
            person = (Person) exampleConstructor.newInstance(name, surname);
        } catch (InstantiationException e) {
            logger.log(System.Logger.Level.ERROR, "Cannot create instance of the Person class");
        } catch (IllegalAccessException e) {
            logger.log(System.Logger.Level.ERROR, "IllegalAccessException is observed when creating instance of Person class");
        } catch (InvocationTargetException e) {
            logger.log(System.Logger.Level.ERROR, "Exception was thrown by an invoked method or constructor");
        } catch (NoSuchMethodException e) {
            logger.log(System.Logger.Level.ERROR, "Unable to find matching method");
        } catch (ClassNotFoundException e) {
            logger.log(System.Logger.Level.ERROR, "Unable to find Person class");
        }
        return privateFieldProcessor.process(person);
    }
}
