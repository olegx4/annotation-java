package annotationProcessors;

import customAnnotations.SetPrivateField;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class PrivateFieldProcessor {
    public Map<String, String> process(Object object) {
        Map<String, String> data = new HashMap<>();
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(SetPrivateField.class)) {
                    f.setAccessible(true);
                    data.put(f.getDeclaredAnnotation(SetPrivateField.class).field(), (String) f.get(object));
                }
            }
        } catch (IllegalAccessException e) {
            System.err.println(e);
        }
        return data;
    }
}
