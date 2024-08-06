package com.example.tallerBanco.Banco.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InicioControlador {

    @GetMapping
    public String showInicio() {
        return "Banco/inicio";
    }
}
