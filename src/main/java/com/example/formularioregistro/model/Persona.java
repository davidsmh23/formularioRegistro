package com.example.formularioregistro.model;

import com.example.formularioregistro.validation.FechaPasada;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Data
@Component
@SessionScope
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    //Grupo de validación para los datos personales
    @NotNull(message = "El nombre no puede estar vacio", groups = DatosPersonales.class)
    private String nombre;
    private String apellidos;
    @FechaPasada(groups = DatosPersonales.class)
    private LocalDate fechaNacimiento;
    private String genero;
    private boolean casado;
    private boolean hijos;
    @NotNull(message = "Debe seleccionar al menos un idioma", groups = DatosPersonales.class)
    @Size(min=2, message = "Debe seleccionar al menos dos nacionalidades", groups = DatosPersonales.class)
    private List<String> nacionalidad;

    //Grupo de validación para los datos profesionales
    private ArrayList<String> departamento;
    @NotNull(message = "El salario no puede estar vacío", groups = DatosProfesionales.class)
    @Digits(integer = 10, fraction = 2, message = "El salario debe ser un número válido con hasta 10 dígitos enteros y 2 decimales",
            groups = DatosProfesionales.class)
    private double salario;
    private String comentario;

    //Grupo de validación para los datos bancarios
    @NotNull(message = "El número de cuenta no puede estar vacío", groups = DatosBancarios.class)
    @Digits(integer = 20, fraction = 0, message = "El número de cuenta debe tener exactamente 20 dígitos",
            groups = DatosBancarios.class)
    private int numeroCuenta;
}

