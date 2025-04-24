package com.ganepalmira.pruebas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ganepalmira.pruebas.domain.Activo;
import com.ganepalmira.pruebas.repository.ActivoRepository;
import java.util.Optional;

@Service
@Scope("singleton")
public class ActivoServiceImpl implements ActivoService {

	@Autowired
	ActivoRepository activoRepository;
	
	@Override
	public List<Activo> findAll() {
		return activoRepository.findAll();
	}

	@Override
    public Optional<Activo> findById(Long codigo) {
        return activoRepository.findById(codigo);
    }

    @Override
    public Activo save(Activo activo) {
        return activoRepository.save(activo);
    }

    @Override
    public void deleteById(Long codigo) {
        activoRepository.deleteById(codigo);
    }

}
