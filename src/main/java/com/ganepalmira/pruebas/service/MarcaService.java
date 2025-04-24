package com.ganepalmira.pruebas.service;

import com.ganepalmira.pruebas.domain.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
    List<Marca> findAll();
    Optional<Marca> findById(Long id);
    Marca save(Marca marca);
    void deleteById(Long id);
}
