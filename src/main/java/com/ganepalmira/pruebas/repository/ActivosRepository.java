package com.ganepalmira.pruebas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganepalmira.pruebas.domain.Activos;

public interface ActivosRepository extends JpaRepository<Activos, String> {

	List<Activos> findAll();
	
}
