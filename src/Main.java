import annotationprocessors.PrivateConstructorProcessor;
import person.Person;
import person.PersonInitializer;
import utils.PersonDataOutput;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    private static final String NAME = "name";
    private static final String SURNAME = "surname";

    public static void main(String[] args) {
        final PersonInitializer personInitializer = new PersonInitializer();
        final PersonDataOutput personDataOutput = new PersonDataOutput();
        final PrivateConstructorProcessor privateConstructorProcessor = new PrivateConstructorProcessor();
        Map<String, String> personPrivateFields;

        final Person person = new Person(45_67_48, "Oleg", "Shapik");
        personPrivateFields = personInitializer.getPrivateFields(person);
        personDataOutput.printData(personPrivateFields.get(SURNAME), personPrivateFields.get(NAME));

        personPrivateFields = personInitializer.defaultInitialization();
        personDataOutput.printData(personPrivateFields.get(SURNAME), personPrivateFields.get(NAME));

        personPrivateFields = personInitializer.initializePerson("Vasya", "Pupkin");
        personDataOutput.printData(personPrivateFields.get(SURNAME), personPrivateFields.get(NAME));

        final ArrayList<Person> persons = privateConstructorProcessor.process();
        for (Person p : persons)
            System.out.println(p.toString());
    }
}
