package com.example.formularioregistro.controller;

import com.example.formularioregistro.model.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("persona")
public class RegistroController {

    private final Persona persona;

    public RegistroController(Persona persona) {
        this.persona = persona;
    }

    @ModelAttribute("persona")
    public Persona getPersona(HttpSession sesion){
        Persona persona = (Persona) sesion.getAttribute("persona");
        if(persona == null){
            persona = new Persona();
        }
        return persona;

    }

    @GetMapping("/reinicio")
    public String redireccion(Model model, SessionStatus status, HttpSession sesion) {
        status.setComplete();
        sesion.invalidate();
        model.addAttribute("listaGeneros", Colecciones.devuelveListaGeneros());
        model.addAttribute("listaPaises", Colecciones.devuelveListaPaises());
        return "datosPersonales";
    }

    @GetMapping("/formularioPersonal")
    public String mostrarFormulario(Model model) {
        model.addAttribute("listaGeneros", Colecciones.devuelveListaGeneros());
        model.addAttribute("listaPaises", Colecciones.devuelveListaPaises());
        return "datosPersonales";
    }

    @PostMapping("/formularioPersonal")
    public String guardarDatosPersonales(@Validated(DatosPersonales.class) @ModelAttribute("persona") Persona persona,
                                         BindingResult result, HttpSession session, Model model) {

        model.addAttribute("listaGeneros", Colecciones.devuelveListaGeneros());
        model.addAttribute("listaPaises", Colecciones.devuelveListaPaises());

        if(result.hasErrors()){
            return "datosPersonales";

        }
        // Guardar los datos en la sesión1
        session.setAttribute("persona", persona);

        return "redirect:/formularioProfesional";
    }

    @GetMapping("/formularioProfesional")
    public String guardarDatosProfesionales(Model model) {
        model.addAttribute("listaDepartamentos", Colecciones.devuelveListaDepartamento());
        return "datosProfesionales";
    }

    @PostMapping("/formularioProfesional")
    public String guardarDatosProfesional(@Validated(DatosProfesionales.class) @ModelAttribute("persona") Persona persona,
                                          BindingResult result, HttpSession session, Model model) {

        model.addAttribute("listaDepartamentos", Colecciones.devuelveListaDepartamento());

        if(result.hasErrors()){
            return "datosProfesionales";
        }
        // Guardar los datos en la sesión
        session.setAttribute("persona", persona);

        return "redirect:/formularioBancario";
    }

    @GetMapping("/formularioBancario")
    public String guardarDatosBancarios() {
        return "datosBancarios";
    }

    @PostMapping("/formularioBancario")
    public String guardarDatosBancario(@Validated(DatosBancarios.class) @ModelAttribute("persona") Persona persona,
                                       BindingResult result, HttpSession session) {

        if(result.hasErrors()){
            return "datosBancarios";
        }
        // Guardar los datos en la sesión
        session.setAttribute("persona", persona);

        return "redirect:/total";
    }

    @GetMapping("/total")
    public String total(HttpSession session, Model model) {
        // Obtener persona de la sesión
        Persona persona = (Persona) session.getAttribute("persona");

        // Si persona es null, inicializarla para evitar el NullPointerException
        if (persona == null) {
            persona = new Persona();
            session.setAttribute("persona", persona); // Guardar en la sesión
        }

        // Modificar el nombre (si es necesario)
        if (persona.getNombre() == null || persona.getNombre().trim().isEmpty()){
            persona.setNombre(" ");
        }

        // Pasar la persona al modelo
        model.addAttribute("persona", persona);

        return "total";
    }


    @GetMapping("/volverInicio")
    public String volverInicio(SessionStatus status, HttpSession sesion) {
        status.setComplete(); // Borra el atributo persona de la sesión
        sesion.invalidate(); // Invalida completamente la sesión
        return "redirect:/reinicio";
    }

}
