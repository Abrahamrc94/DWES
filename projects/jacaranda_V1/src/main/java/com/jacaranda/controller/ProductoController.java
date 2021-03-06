package com.jacaranda.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Producto;

@RestController
@CrossOrigin(origins="*")
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
	
	
	@GetMapping("/productos/{nombre}")
	public Producto getProducto(@PathVariable String nombre){
		Producto producto = null;
		
		boolean encontrado=false;
		Iterator<Producto> prodIterator= productos.iterator();
		while(prodIterator.hasNext() && !encontrado) {
			Producto p= prodIterator.next();
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				producto=p;
				encontrado= true;
			}
		}
		return producto;
	}
	
	@PostMapping("/productos")
	public ResponseEntity<?> createPedido(@RequestBody Producto sent){
		ResponseEntity<?> respuesta=null;
		Producto p=buscaProducto(sent.getNombre());
		if(p==null) {
				productos.add(sent);
				respuesta=ResponseEntity.status(HttpStatus.CREATED).body(sent);
			}else {
				respuesta=ResponseEntity.status(HttpStatus.CONFLICT).body(sent);
			}
		return respuesta;
	}
	
	@PutMapping("/productos")
	public ResponseEntity<?> modifyCustomer(@RequestBody Producto prod1){
		
		ResponseEntity respuesta=null;
		boolean encontrado=false;
		Iterator<Producto> prodIterator= productos.iterator();
		while(prodIterator.hasNext() && !encontrado) {
			Producto p= prodIterator.next();
			if(p.getNombre().equalsIgnoreCase(prod1.getNombre())) {
				p.setPrecio(prod1.getPrecio());
				p.setStock(prod1.getStock());
				encontrado= true;
				respuesta=ResponseEntity.status(HttpStatus.ACCEPTED).body(prod1);
			}else {
				respuesta=ResponseEntity.status(HttpStatus.NOT_FOUND).body(prod1);
			}
		}
		
		return respuesta;
	}
	
	@DeleteMapping("/productos")
	public ResponseEntity<?> deleteCustomer(@RequestBody Producto prod1){
		
		Producto productoToDelete=null;
		ResponseEntity respuesta=null;
		boolean encontrado=false;
		Iterator<Producto> prodIterator= productos.iterator();
		while(prodIterator.hasNext() && !encontrado) {
			Producto p= prodIterator.next();
			if(p.getNombre().equalsIgnoreCase(prod1.getNombre())) {
				productoToDelete=p;
				productos.remove(productoToDelete);
				encontrado=true;
				respuesta=ResponseEntity.status(HttpStatus.OK).body(prod1);
			}else {
				respuesta=ResponseEntity.status(HttpStatus.NOT_FOUND).body(prod1);
			}
		}
		
		return respuesta;
	}
	
	private Producto buscaProducto(String nombre) {
		boolean encontrado= false;
		Producto prod=null;
		Iterator<Producto> prodIterator= productos.iterator();
		while(prodIterator.hasNext() && !encontrado) {
			Producto p= prodIterator.next();
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				prod=p;
				encontrado=true;
			}
		}
		return prod;
	}
}
