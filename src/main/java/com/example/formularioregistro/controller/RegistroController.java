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

@Controller
@SessionAttributes("persona")
public class RegistroController {

    @ModelAttribute("persona")
    public Persona getPersona(HttpSession sesion){
        Persona persona = (Persona) sesion.getAttribute("persona");
        if(persona == null){
            persona = new Persona();
        }
        return persona;

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
    public String total(HttpSession session, Model model){

        Persona persona = (Persona) session.getAttribute("persona");
        model.addAttribute("persona", persona);
        return "total";
    }

    @GetMapping("/volverInicio")
    public String volverInicio(HttpSession session) {
        session.invalidate();
        return "redirect:/formularioPersonal";
    }

}
