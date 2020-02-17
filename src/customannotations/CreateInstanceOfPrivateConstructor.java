package customannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateInstanceOfPrivateConstructor {
    int phoneNumber() default 55_55_55;
    String name() default "DefaultName";
    String surname() default "DefaultSurname";
}

