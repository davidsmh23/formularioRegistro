package com.example.formularioregistro.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FechaPasadaValidator implements ConstraintValidator<FechaPasada, String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public boolean isValid(String fechaNacimiento, ConstraintValidatorContext context) {
        if (fechaNacimiento == null || fechaNacimiento.trim().isEmpty()) {
            return true; // Se considera válido si es nulo o vacío (para permitir valores opcionales)
        }

        try {
            LocalDate fecha = LocalDate.parse(fechaNacimiento, FORMATTER);
            return fecha.isBefore(LocalDate.now()); // Valida que sea anterior a hoy
        } catch (DateTimeParseException e) {
            return false; // Si la fecha no tiene el formato correcto, la validación falla
        }
    }
}
