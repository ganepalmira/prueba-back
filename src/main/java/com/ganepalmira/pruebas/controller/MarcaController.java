package com.ganepalmira.pruebas.controller;

import com.ganepalmira.pruebas.domain.Marca;
import com.ganepalmira.pruebas.repository.MarcaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaRepository marcaRepository;

    public MarcaController(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @GetMapping
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
