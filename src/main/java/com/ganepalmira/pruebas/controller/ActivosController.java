package com.ganepalmira.pruebas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganepalmira.pruebas.domain.Activos;
import com.ganepalmira.pruebas.service.ActivosService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/activos")
@Slf4j
public class ActivosController {
	
	@Autowired
	ActivosService activosService;

	@GetMapping("/findAll")
	public ResponseEntity<List<Activos>> findAll() throws Exception {
		log.info("Consultando activos");
		List<Activos> activosLst = activosService.findAll();
		log.info("Se encontraron: " + activosLst.size() + " activos");
		
		return ResponseEntity.ok(activosLst);
	}
	
}
