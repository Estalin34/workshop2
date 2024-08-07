package com.example.tallerBanco.Banco.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tallerBanco.Banco.Entidad.Formulario;
import com.example.tallerBanco.Banco.Repositorio.FormularioRepositorio;

import java.util.List;

@Service
public class FormularioServicio {

    @Autowired
    private FormularioRepositorio formularioRepositorio;

    public List<Formulario> listarTodos() {
        return formularioRepositorio.findAll();
    }

    public Formulario guardar(Formulario formulario) {
        return formularioRepositorio.save(formulario);
    }

    public Formulario obtenerPorId(Long id) {
        return formularioRepositorio.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        formularioRepositorio.deleteById(id);
    }
}
