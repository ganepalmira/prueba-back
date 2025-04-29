package com.ganepalmira.pruebas.controller;

import javax.transaction.Transactional;

import com.ganepalmira.pruebas.domain.Movimiento;
import com.ganepalmira.pruebas.service.MovimientoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movimientos")
@Slf4j
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Movimiento>> findAll() {
        log.info("Consultando movimientos");
        return ResponseEntity.ok(movimientoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> findById(@PathVariable Long id) {
        Optional<Movimiento> movimiento = movimientoService.findById(id);
        return movimiento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Movimiento> save(@RequestBody Movimiento movimiento) {
        Movimiento saved = movimientoService.save(movimiento);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movimientoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
