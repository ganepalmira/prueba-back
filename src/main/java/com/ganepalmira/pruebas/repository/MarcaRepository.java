package com.ganepalmira.pruebas.repository;

import com.ganepalmira.pruebas.domain.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {}
