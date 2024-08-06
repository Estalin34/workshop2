package com.example.tallerBanco.Banco.Controlador;

import com.example.tallerBanco.Banco.Entidad.Formulario;
import com.example.tallerBanco.Banco.Servicio.FormularioServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormularioControlador {

    @Autowired
    private FormularioServicio formularioServicio;

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        // Añade un nuevo objeto Formulario al modelo para mostrar el formulario vacío.
        model.addAttribute("formulario", new Formulario());
        return "Banco/formulario"; // Retorna la vista del formulario.
    }

    @PostMapping("/formulario")
    public String procesarFormulario(@Valid Formulario formulario, BindingResult result, Model model) {
        // Verifica si hay errores de validación en el formulario.
        if (result.hasErrors()) {
            // Si hay errores, vuelve a mostrar el formulario para que el usuario los corrija.
            return "Banco/formulario";
        }

        // Si no hay errores, guarda el formulario en la base de datos.
        formularioServicio.guardar(formulario);

        // Redirige a la pantalla de éxito o confirmación.
        return "redirect:/pantalla";
    }
}
