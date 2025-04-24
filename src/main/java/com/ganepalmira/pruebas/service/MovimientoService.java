package com.ganepalmira.pruebas.service;

import com.ganepalmira.pruebas.domain.Movimiento;

import java.util.List;
import java.util.Optional;

public interface MovimientoService {
    List<Movimiento> findAll();
    Optional<Movimiento> findById(Long id);
    Movimiento save(Movimiento movimiento);
    void deleteById(Long id);
}
