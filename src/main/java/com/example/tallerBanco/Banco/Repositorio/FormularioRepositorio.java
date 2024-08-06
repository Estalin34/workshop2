package com.example.tallerBanco.Banco.Repositorio;

import com.example.tallerBanco.Banco.Entidad.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepositorio extends JpaRepository<Formulario, Long> {
}
