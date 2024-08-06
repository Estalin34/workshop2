package com.example.tallerBanco.Banco.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PantallaControlador {

    @GetMapping("/pantalla")
    public String mostrarPantallaBien() {
        return "Banco/pantalla";
    }
}