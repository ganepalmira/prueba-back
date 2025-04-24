package com.ganepalmira.pruebas.repository;

import com.ganepalmira.pruebas.domain.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByActivoCodigo(String codigo);
}
