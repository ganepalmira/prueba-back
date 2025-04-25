package com.ganepalmira.pruebas.controller;

import java.util.List;

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

import com.ganepalmira.pruebas.domain.Activo;
import com.ganepalmira.pruebas.domain.Marca;
import com.ganepalmira.pruebas.domain.Ubicacion;
import com.ganepalmira.pruebas.repository.ActivoRepository;
import com.ganepalmira.pruebas.repository.MarcaRepository;
import com.ganepalmira.pruebas.repository.UbicacionRepository;
import com.ganepalmira.pruebas.service.ActivoService;
import org.springframework.web.bind.annotation.PathVariable;

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
	private ActivoService activoService;

    @Autowired
    private UbicacionRepository ubicacionRepository;

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

        if (activo.getUbicacionActual() != null && activo.getUbicacionActual().getCodUbicacion() != null) {
            Ubicacion ubicacion = ubicacionRepository.findById(activo.getUbicacionActual().getCodUbicacion())
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));
            activo.setUbicacionActual(ubicacion);
        }
		
        return activoRepository.save(activo);
    }

    @DeleteMapping("/delete/{codigo}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long codigo) {
        Activo activo = activoRepository.findById(codigo)
        .orElseThrow(() -> new RuntimeException("Activo no encontrado con código: " + codigo));

        if (activo.getMarca() == null || activo.getUbicacionActual() == null) {
            throw new RuntimeException("Activo tiene una marca o ubicación no persistida.");
        }

        activoRepository.delete(activo); 
        return ResponseEntity.ok("Activo eliminado correctamente");
    }

    @PutMapping("/update/{codigo}")
    @Transactional
    public ResponseEntity<String> updateActivo(@PathVariable Long codigo, @RequestBody Activo activoActualizado) {
        Activo activoExistente = activoRepository.findById(codigo)
            .orElseThrow(() -> new RuntimeException("Activo no encontrado con código: " + codigo));

        activoExistente.setNombre(activoActualizado.getNombre());
        activoExistente.setReferencia(activoActualizado.getReferencia());
        activoExistente.setEstado(activoActualizado.getEstado());

        if (activoActualizado.getMarca() != null && activoActualizado.getMarca().getCodMarca() != null) {
            Marca marca = marcaRepository.findById(activoActualizado.getMarca().getCodMarca())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con código: " + activoActualizado.getMarca().getCodMarca()));
            activoExistente.setMarca(marca);
        }

        if (activoActualizado.getUbicacionActual() != null && activoActualizado.getUbicacionActual().getCodUbicacion() != null) {
            Ubicacion ubicacion = ubicacionRepository.findById(activoActualizado.getUbicacionActual().getCodUbicacion())
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada con código: " + activoActualizado.getUbicacionActual().getCodUbicacion()));
            activoExistente.setUbicacionActual(ubicacion);
        }

        activoRepository.save(activoExistente);
        return ResponseEntity.ok("Activo actualizado correctamente");
    }

}
