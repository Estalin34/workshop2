package com.example.tallerBanco.Banco.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/informacion")
public class InformacionControlador {

    @GetMapping
    public String showInformacion() {
        return "Banco/informacion";
    }
}