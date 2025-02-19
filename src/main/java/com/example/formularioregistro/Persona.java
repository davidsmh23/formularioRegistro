package com.example.formularioregistro;

import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@Component
@SessionScope
public class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String genero;
    private boolean casado;
    private boolean hijos;
    private ArrayList<String> nacionalidad;
    private ArrayList<String> departamento;
    private double salario;
    private String comentario;
    private int numeroCuenta;
}

