package com.jacaranda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Pedido;
import com.jacaranda.entity.Producto;

@RestController
@RequestMapping(path="/api")
public class ProductoController {

	private List<Producto> productos= new ArrayList<>() {
		{
			add(new Producto("Patatas", 10, 100));
			add(new Producto("Garbanzos", 5, 75));
			add(new Producto("Coca-Cola", 7, 90));
			add(new Producto("Chocolate", 12, 120));
		}
	};
	
	@GetMapping("/productos")
	public List<Producto> getProductos(){
		return productos;
	}
	
	@PostMapping("/productos")
	public ResponseEntity<?> createPedido(@RequestBody Producto sent){
		ResponseEntity respuesta=null;
		for(Producto p: productos) {
			if(sent.getNombre()==p.getNombre()) {
				respuesta=ResponseEntity.status(HttpStatus.CONFLICT).body(sent);
			}else {
				productos.add(sent);
				respuesta=ResponseEntity.status(HttpStatus.CREATED).body(sent);
			}
		
		
		}
		return respuesta;
	}
	
	@PutMapping("/pedidos")
	public ResponseEntity<?> modifyCustomer(@RequestBody Producto prod1){
		
		ResponseEntity respuesta=null;
		for(Producto p: productos) {
			if(prod1.getNombre()==p.getNombre()) {
				p.setPrecio(prod1.getPrecio());
				p.setStock(prod1.getStock());
	
			}else {
				respuesta=ResponseEntity.status(HttpStatus.NOT_FOUND).body(prod1);
			}
		}
		
		return respuesta;
	}
	
	@DeleteMapping("/customers")
	public ResponseEntity<?> deleteCustomer(@RequestBody Producto prod1){
		
		Producto productoToDelete=null;
		ResponseEntity respuesta=null;
		for(Producto p: productos) {
			if(prod1.getNombre()==p.getNombre()) {
				productoToDelete=p;
				productos.remove(productoToDelete);
				respuesta=ResponseEntity.status(HttpStatus.OK).body(prod1);
			}else {
				respuesta=ResponseEntity.status(HttpStatus.NOT_FOUND).body(prod1);
			}
		}
		
		return respuesta;
	}
	
	
}
