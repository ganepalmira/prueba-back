package com.ganepalmira.pruebas.service;

import com.ganepalmira.pruebas.domain.Movimiento;
import com.ganepalmira.pruebas.repository.MovimientoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    @Override
    public Optional<Movimiento> findById(Long id) {
        return movimientoRepository.findById(id);
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public void deleteById(Long id) {
        movimientoRepository.deleteById(id);
    }
}
