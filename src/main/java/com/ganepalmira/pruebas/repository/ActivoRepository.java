package com.ganepalmira.pruebas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganepalmira.pruebas.domain.Activo;

public interface ActivoRepository extends JpaRepository<Activo, Long> {

	List<Activo> findAll();
	
}
