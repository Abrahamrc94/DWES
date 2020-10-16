package com.jacaranda.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/public-api")
public class testController {
	
	
	private Logger logger=org.slf4j.LoggerFactory.getLogger(testController.class);

	@RequestMapping(path="/prueba", method=RequestMethod.GET)
	public String prueba() {
		logger.info("Método prueba llamado");
		return "Prueba correcta";
	}
	
	
	@GetMapping(path="/test")
	public String pruebaGET() {
		return "Prueba correcta 2";
	}
	
	
	@RequestMapping(path="/post", method=RequestMethod.POST)
	public String pruebaPost() {
		return "Prueba post correcta";
	}
	
	@PostMapping(path="/post-test")
	public String pruebaPost2() {
		return "Hola Mundo";
	}
	
	
	@PutMapping(path="/put")
	public String pruebaPut() {
		return "Prueba de petición Put";
	}
	
	@DeleteMapping(path="/delete")
	public String pruebaDelete() {
		logger.warn("Cuidado, hay un loco borrando cosas");
		return "Borrando";
	}
}
