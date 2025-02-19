package com.example.formularioregistro.controller;

import com.example.formularioregistro.Persona;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String guardarDatosPersonales(@ModelAttribute Persona persona, HttpSession session) {
        // Guardar los datos en la sesión
        session.setAttribute("persona", persona);
        return "datosProfesionales";
    }

    @PostMapping("/formularioProfesional")
    public String guardarDatosProfesionales(@ModelAttribute Persona persona, HttpSession session) {
        // Guardar los datos en la sesión
        session.setAttribute("persona", persona);
        return "datosBancarios";
    }

    @PostMapping("/formularioBancario")
    public String guardarDatosBancarios(@ModelAttribute Persona persona, HttpSession session, Model model) {
        // Guardar los datos en la sesión
        session.setAttribute("persona", persona);

        persona = (Persona) session.getAttribute("persona");
        model.addAttribute("persona", persona);
        return "total";
    }

    @PostMapping("/volverInicio")
    public String volverInicio(HttpSession session) {
        session.invalidate();
        return "redirect:/formularioPersonal";
    }

}
