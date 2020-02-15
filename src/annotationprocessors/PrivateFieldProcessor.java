package annotationprocessors;

import customannotations.GetPrivateField;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class PrivateFieldProcessor {
    public Map<String, String> process(Object object) {
        Map<String, String> data = new HashMap<>();

        if (object == null) {
            return new HashMap<>();
        }

        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(GetPrivateField.class)) {
                    f.setAccessible(true);
                    data.put(f.getDeclaredAnnotation(GetPrivateField.class).field(), (String) f.get(object));
                }
            }
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return data;
    }
}
