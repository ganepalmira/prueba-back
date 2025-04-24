package com.ganepalmira.pruebas.service;

import com.ganepalmira.pruebas.domain.Ubicacion;

import java.util.List;
import java.util.Optional;

public interface UbicacionService {
    List<Ubicacion> findAll();
    Optional<Ubicacion> findById(Long id);
    Ubicacion save(Ubicacion ubicacion);
    void deleteById(Long id);
}
