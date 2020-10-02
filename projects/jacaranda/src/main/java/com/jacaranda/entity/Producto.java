package com.jacaranda.entity;

import java.io.Serializable;

public class Producto implements Serializable{

	private String nombre;
	private int precio;
	private int stock;
	
	public Producto() {
		super();
	}

	public Producto(String nombre, int precio, int stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	
	
}
