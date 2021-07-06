package com.example.practicespringboot.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = { EmailUnusedValidator.class })
@Target({TYPE})
@Retention(RUNTIME)
public @interface EmailUnused {
    String message() default "{com.example.practicespringboot.validations.EmailUnused.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
