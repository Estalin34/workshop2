package com.example.tallerBanco.Banco.Servicio;

import com.example.tallerBanco.Banco.Entidad.Formulario;
import com.example.tallerBanco.Banco.Repositorio.FormularioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormularioServicio {

    @Autowired
    private FormularioRepositorio formularioRepositorio;

    public Formulario guardar(Formulario formulario) {
        return formularioRepositorio.save(formulario);
    }
}
