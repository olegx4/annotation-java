package annotationProcessors;

import customAnnotations.PrivateField;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

public class PrivateFieldProcessor {
    public static Map<String, String> process(Object ob) {
        Map<String, String> data = new TreeMap<>();
        try {
            Field[] fields = ob.getClass().getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(PrivateField.class)) {
                    f.setAccessible(true);
                    data.put(f.getDeclaredAnnotation(PrivateField.class).field(), (String) f.get(ob));
                }
            }
        } catch (IllegalAccessException e) {
            System.err.println(e);
        }
        return data;
    }
}
