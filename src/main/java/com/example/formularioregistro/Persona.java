package com.example.formularioregistro;

import lombok.Data;
import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@Component
@SessionScope
public class Persona implements Serializable {
    private String nombre;
    private String apellidos;
    private String genero;
    private boolean casado;
    private int hijos;
    private String nacionalidad;
    private String departamento;
    private double salario;
    private String comentario;
    private int numeroCuenta;
}

