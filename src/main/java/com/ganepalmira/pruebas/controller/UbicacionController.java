package com.ganepalmira.pruebas.controller;

import com.ganepalmira.pruebas.domain.Ubicacion;
import com.ganepalmira.pruebas.service.UbicacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/ubicaciones")
@Slf4j
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Ubicacion>> findAll() {
        log.info("Consultando ubicaciones");
        return ResponseEntity.ok(ubicacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion> findById(@PathVariable Long id) {
        Optional<Ubicacion> ubicacion = ubicacionService.findById(id);
        return ubicacion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Ubicacion> save(@RequestBody Ubicacion ubicacion) {
        Ubicacion saved = ubicacionService.save(ubicacion);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ubicacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
