package com.ganepalmira.pruebas.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganepalmira.pruebas.domain.Marca;
import com.ganepalmira.pruebas.repository.MarcaRepository;
import com.ganepalmira.pruebas.service.MarcaService;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/marcas")
@Slf4j
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
	private MarcaService marcaService;

    @GetMapping("/findAll")
    public List<Marca> findAll() {
        try {
            return marcaRepository.findAll();
        } catch (Exception e) {
            // Log de error
            e.printStackTrace();
            throw new RuntimeException("Error al recuperar las marcas");
        }
    }

    @PostMapping
    public Marca save(@RequestBody Marca marca) {
        if (marca.getDescripcion() == null || marca.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la marca no puede ser vacío");
        }
        return marcaRepository.save(marca);
    }
}
