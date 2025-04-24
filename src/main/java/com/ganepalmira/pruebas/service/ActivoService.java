package com.ganepalmira.pruebas.service;

import java.util.List;

import com.ganepalmira.pruebas.domain.Activo;
import java.util.Optional;

public interface ActivoService {

	List<Activo> findAll();
	Optional<Activo> findById(Long codigo);
    Activo save(Activo activo);
    void deleteById(Long codigo);
	
}
