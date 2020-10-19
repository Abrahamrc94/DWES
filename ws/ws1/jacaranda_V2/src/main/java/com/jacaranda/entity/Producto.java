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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
