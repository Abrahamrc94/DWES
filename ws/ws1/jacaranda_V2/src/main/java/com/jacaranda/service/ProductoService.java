package com.jacaranda.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Producto;
import com.jacaranda.repo.ProductoRepository;

@Service
public class ProductoService {
	
	
	@Autowired
	private ProductoRepository productoRepository;

	//Get de todos los productos
	public ResponseEntity<?> getProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productoRepository.findAll());
	}
	
	
	//Get para un producto por nombre
	public Producto getProductoByNombre(String nombre) {
		return productoRepository.findProductobyName(nombre);
	
	}
	
	//Get para un producto por id
	public Producto getProductoById(int id) {
		return productoRepository.findProductoById(id);
	
	}
	
	//Get de todos los productos por nombre
	public List<Producto> getProductoOrderByNombre() {
		return productoRepository.findAllOrderedByName();
	}
	
	//Crear un nuevo producto
	public Producto saveProducto(Producto sent) {
		return productoRepository.save(sent);
	}
	
	
	//Borrar un producto
	public void deleteProducto(int id) {
		productoRepository.deleteById(id);;
	}
	
	
}
