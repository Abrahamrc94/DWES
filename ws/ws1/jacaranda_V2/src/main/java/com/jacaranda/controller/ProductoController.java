package com.jacaranda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Pedido;
import com.jacaranda.entity.Producto;
import com.jacaranda.service.ProductoService;

@RestController
@RequestMapping(path="/api")
public class ProductoController {

	//Creamos los servicios
	@Autowired
	private ProductoService productoService;
	
			
	//Devuelve todos los productos
	@GetMapping("/producto")
	public ResponseEntity<?> getProductos(){
		return productoService.getProducts();
	}
	
	//Devuelve un producto en concreto segun el nombre
	@GetMapping("/producto/{nombre}")
	public ResponseEntity<?> getProductoNombre(@PathVariable String nombre){
		return ResponseEntity.ok(productoService.getProductoByNombre(nombre));
	}
	
	//Devuelve un producto segun el id
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> getProductoId(@PathVariable int id){
		return ResponseEntity.ok(productoService.getProductoById(id));
	}
	
	//Devuelve todos los productos ordenados por nombre
	@GetMapping("/producto/nombres")
	public List<Producto> getProductosOrderByNombre(){
		return productoService.getProductoOrderByNombre();
	}
		
	
	//Crea un producto
	@PostMapping("/producto")
	public Producto createProducto(@RequestBody Producto sent){
		return productoService.saveProducto(sent);
	}
	
	
	//Modifica un producto PUT
	@PutMapping(path = "/producto/{id}")
	public ResponseEntity<?> updateProducto(@PathVariable int id, @RequestBody Producto sent) {
		return productoService.updateProducto(id, sent);
	}
		
	
	
	//Borra un producto
	@DeleteMapping("/productos/{id}")
	public void deleteProducto(@RequestBody int id){
		productoService.deleteProducto(id);
	}

}