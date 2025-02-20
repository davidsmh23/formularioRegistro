package com.example.formularioregistro.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class FechaPasadaValidator implements ConstraintValidator<FechaPasada, LocalDate> {

    @Override
    public boolean isValid(LocalDate fechaNacimiento, ConstraintValidatorContext context) {
        if (fechaNacimiento == null) {
            return true; // Se considera válido si es nulo (para permitir valores opcionales)
        }
        return fechaNacimiento.isBefore(LocalDate.now()); // Valida que sea anterior a hoy
    }
}

