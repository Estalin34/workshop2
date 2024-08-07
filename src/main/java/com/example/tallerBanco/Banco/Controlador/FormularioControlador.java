package com.example.tallerBanco.Banco.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.tallerBanco.Banco.Entidad.Formulario;
import com.example.tallerBanco.Banco.Servicio.FormularioServicio;

@Controller
@RequestMapping("/formularios")
public class FormularioControlador {

    @Autowired
    private FormularioServicio formularioServicio;

    @GetMapping
    public String listarFormularios(Model model) {
        model.addAttribute("formularios", formularioServicio.listarTodos());
        return "banco/formulario"; // Asegúrate de que este archivo exista en la ruta src/main/resources/templates/banco/formulario.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("formulario", new Formulario());
        return "banco/formulario";
    }

    @PostMapping
    public String guardarFormulario(@ModelAttribute("formulario") Formulario formulario) {
        formularioServicio.guardar(formulario);
        return "redirect:/formularios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Formulario formulario = formularioServicio.obtenerPorId(id);
        model.addAttribute("formulario", formulario);
        return "banco/formulario"; // Asegúrate de que este archivo exista y que esté bien configurado para edición
    }

    @PostMapping("/{id}")
    public String actualizarFormulario(@PathVariable Long id, @ModelAttribute("formulario") Formulario formulario) {
        Formulario formularioExistente = formularioServicio.obtenerPorId(id);
        if (formularioExistente != null) {
            formularioExistente.setNombre(formulario.getNombre());
            formularioExistente.setApellido(formulario.getApellido());
            formularioExistente.setCedula(formulario.getCedula());
            formularioExistente.setNumeroCuenta(formulario.getNumeroCuenta());
            formularioExistente.setCorreoElectronico(formulario.getCorreoElectronico());
            formularioServicio.guardar(formularioExistente);

        }
        return "redirect:/formularios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFormulario(@PathVariable Long id) {
        formularioServicio.eliminar(id);
        return "redirect:/formularios";
    }
}
