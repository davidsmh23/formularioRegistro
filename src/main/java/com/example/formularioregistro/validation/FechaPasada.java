package com.example.formularioregistro.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FechaPasadaValidator.class)
@Target(ElementType.FIELD) // Aplica a campos individuales
@Retention(RetentionPolicy.RUNTIME)
public @interface FechaPasada {
    String message() default "La fecha debe ser anterior a hoy"; // Mensaje de error
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

