package com.ganepalmira.pruebas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganepalmira.pruebas.domain.Activo;
import com.ganepalmira.pruebas.domain.Marca;
import com.ganepalmira.pruebas.repository.ActivoRepository;
import com.ganepalmira.pruebas.repository.MarcaRepository;
import com.ganepalmira.pruebas.service.ActivoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/activos")
@Slf4j
public class ActivoController {

	@Autowired
    private ActivoRepository activoRepository;

    @Autowired
    private MarcaRepository marcaRepository;
	
	@Autowired
	ActivoService activoService;

	@GetMapping("/findAll")
	public ResponseEntity<List<Activo>> findAll() throws Exception {
		log.info("Consultando activos");
		List<Activo> activosLst = activoService.findAll();
		log.info("Se encontraron: " + activosLst.size() + " activos");
		
		return ResponseEntity.ok(activosLst);
	}
	
	@PostMapping("/create")
    public Activo create(@RequestBody Activo activo) {
        if (activo.getMarca() != null && activo.getMarca().getCodMarca() != null) {
            Marca marca = marcaRepository.findById(activo.getMarca().getCodMarca())
                    .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
            activo.setMarca(marca);
        }
		
        return activoRepository.save(activo);
    }
}
