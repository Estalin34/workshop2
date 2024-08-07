package com.example.tallerBanco.Banco.Controlador;

import com.example.tallerBanco.Banco.Entidad.Formulario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pantalla")
public class PantallaControlador {

    @GetMapping
    public String mostrarPantallaBien() {
        return "Banco/pantalla";
    }

    @PostMapping
    public String procesarFormulario(@ModelAttribute("formulario") Formulario formulario) {
        // Aquí puedes agregar lógica para procesar el formulario si es necesario
        return "redirect:/pantalla";
    }
}
