package com.jacaranda.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Producto;

import service.CheckService;
import service.UpdateService;

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
	
	//Creamos los servicios
			@Autowired
			private CheckService checkService;
			@Autowired
			private UpdateService updateService;
	
	//Devuelve todos los productos
	@GetMapping("/productos")
	public List<Producto> getProductos(){
		return productos;
	}
	
	//Devuelve un producto en concreto
	@GetMapping("/productos/{nombre}")
	public ResponseEntity<?> getProductoNombre(@PathVariable String nombre){
		Producto producto = checkService.comprobarProducto(productos, nombre);
		ResponseEntity<?> respuesta;
		if(producto == null) {
			respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto no existe");
		}else {
			respuesta = ResponseEntity.status(HttpStatus.OK).body(producto);
		}
		return respuesta;
	}
	
	@PostMapping("/productos")
	public ResponseEntity<?> createProducto(@RequestBody Producto sent){
		ResponseEntity respuesta;
		Producto producto = checkService.comprobarProducto(productos, sent.getNombre());
		if(producto == null) {
			productos.add(sent);
			respuesta = ResponseEntity.status(HttpStatus.CREATED).body("El producto se ha creado");
		}else {
			respuesta = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el producto");
		}
		return respuesta;
	}
	
	@PutMapping("/productos")
	public ResponseEntity<?> modifyProducto(@RequestBody Producto sent){
		ResponseEntity respuesta;
		Producto producto = checkService.comprobarProducto(productos, sent.getNombre());
		if(producto == null) {
			respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el producto");
		}else {
			updateService.upProduct(producto, sent);
			respuesta = ResponseEntity.status(HttpStatus.ACCEPTED).body("Se ha actualziado el producto");
		}
		return respuesta;
	
	}
	
	@DeleteMapping("/productos")
	public ResponseEntity<?> deleteProducto(@RequestBody Producto sent){
		
		Producto productoToDelete=checkService.comprobarProducto(productos, sent.getNombre());
		ResponseEntity respuesta;
		
			if(productoToDelete==null) {
				respuesta=ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el producto");
			}else {
				productos.remove(productoToDelete);
				respuesta=ResponseEntity.status(HttpStatus.ACCEPTED).body("Se ha eliminado el producto");
			}
		
		return respuesta;
	}

}
