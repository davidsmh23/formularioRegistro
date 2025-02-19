package com.example.formularioregistro.controller;

import com.example.formularioregistro.Persona;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("persona")
public class RegistroController {

    @GetMapping("/formularioPersonal")
    public String mostrarFormulario(Model model) {
        model.addAttribute("persona", new Persona());
        return "datosPersonales";
    }

    @PostMapping("/formularioPersonal")
    public String guardarDatosPersonales(@Valid @ModelAttribute Persona persona,
                                         HttpSession session, BindingResult result) {

        if(result.hasErrors()){
            return "datosPersonales";
        }
        // Guardar los datos en la sesión
        session.setAttribute("persona", persona);

        return "redirect:/formularioProfesional";
    }

    @GetMapping("/formularioProfesional")
    public String guardarDatosProfesionales(@ModelAttribute Persona persona) {
        return "datosProfesionales";
    }

    @PostMapping("/formularioProfesional")
    public String guardarDatosProfesional(@Valid @ModelAttribute Persona persona,
                                         HttpSession session, BindingResult result) {

        if(result.hasErrors()){
            return "datosProfesionales";
        }
        // Guardar los datos en la sesión
        session.setAttribute("persona", persona);

        return "redirect:/formularioBancario";
    }

    @GetMapping("/formularioBancario")
    public String guardarDatosBancarios(@ModelAttribute Persona persona) {
        return "datosBancarios";
    }

    @PostMapping("/formularioBancario")
    public String guardarDatosBancario(@Valid @ModelAttribute Persona persona,
                                          HttpSession session, BindingResult result) {

        if(result.hasErrors()){
            return "datosBancarios";
        }
        // Guardar los datos en la sesión
        session.setAttribute("persona", persona);

        return "redirect:/total";
    }

    @PostMapping("/total")
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
