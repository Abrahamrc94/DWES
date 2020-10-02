package com.jacaranda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
	
}
