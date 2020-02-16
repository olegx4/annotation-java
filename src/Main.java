import person.Person;
import person.PersonInitializer;
import utils.PersonDataOutput;

import java.util.Map;

public class Main {
    private static final String NAME = "name";
    private static final String SURNAME = "surname";

    public static void main(String[] args) {
        final PersonInitializer personInitializer = new PersonInitializer();
        final PersonDataOutput personDataOutput = new PersonDataOutput();
        Map<String, String> personPrivateFields;

        Person person = new Person(45_67_48, "Oleg", "Shapik");
        personPrivateFields = personInitializer.getPrivateFields(person);
        personDataOutput.printData(personPrivateFields.get(SURNAME), personPrivateFields.get(NAME));

        personPrivateFields = personInitializer.defaultInitialization();
        personDataOutput.printData(personPrivateFields.get(SURNAME), personPrivateFields.get(NAME));

        // TODO: 2020/15/01 ShapovalO move logic into a new method of PersonInitializer class
//        try {
//            Person person2;
//            Class<?> examplePerson = Class.forName(Person.class.getName());
//            Class<?>[] params = {String.class, String.class};
//            Constructor<?> exampleConstructor = examplePerson.getDeclaredConstructor(params);
//            exampleConstructor.setAccessible(true);
//            person2 = (Person) exampleConstructor.newInstance("Vasya", "Pupkin");
//            tmp = personInitializer.getPrivateFieldProcessor.process(person2);
//            printData(tmp.get("name"), tmp.get("surname"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
