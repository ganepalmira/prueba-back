package com.ganepalmira.pruebas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ganepalmira.pruebas.domain.Activos;
import com.ganepalmira.pruebas.repository.ActivosRepository;

@Service
@Scope("singleton")
public class ActivosServiceImpl implements ActivosService {

	@Autowired
	ActivosRepository activosRepository;
	
	@Override
	public List<Activos> findAll() {
		return activosRepository.findAll();
	}

}
