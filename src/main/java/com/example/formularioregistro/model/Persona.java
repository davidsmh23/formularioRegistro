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
    //@NotBlank(message = "El nombre no puede estar vacio", groups = DatosPersonales.class)
    @NotNull(message = "El nombre no puede estar vacio", groups = DatosPersonales.class)
    private String nombre = " ";
    private String apellidos;
    @FechaPasada(groups = DatosPersonales.class)
    @Pattern(regexp = "^(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}$",
            message = "Formato inválido. Use dd/MM/yyyy", groups = DatosPersonales.class)
    private String fechaNacimiento;
    private String genero;
    private boolean casado;
    private boolean hijos;
    @NotNull(message = "Debe seleccionar al menos un idioma", groups = DatosPersonales.class)
    @Size(min=2, message = "Debe seleccionar al menos dos nacionalidades", groups = DatosPersonales.class)
    private List<String> nacionalidad;

    //Grupo de validación para los datos profesionales
    private ArrayList<String> departamento;
    @NotNull(message = "El salario no puede estar vacío", groups = DatosProfesionales.class)
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "El salario debe ser un número válido con hasta dos decimales",
            groups = DatosProfesionales.class)
    private String salario;
    private String comentario;

    //Grupo de validación para los datos bancarios
    @NotNull(message = "El número de cuenta no puede estar vacío", groups = DatosBancarios.class)
    @Pattern(regexp = "\\d{20}", message = "El número de cuenta debe tener exactamente 20 dígitos",
            groups = DatosBancarios.class)
    private String numeroCuenta;
}

