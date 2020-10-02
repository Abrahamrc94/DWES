package com.jacaranda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable{

	private Customer customer;
	private int  id_Pedido;
	private int total;//El precio total del pedido
	private String estado;//Si el pedido está pendiente, entregado o en reparto
	private List<Producto> productos;
	
	
	public Pedido() {
		super();
	}


	public Pedido(Customer customer, int id_Pedido, int total, String estado) {
		super();
		this.customer = customer;
		this.id_Pedido = id_Pedido;
		this.total = total;
		this.estado = estado;
		productos = new ArrayList<Producto>();
	}


	public int getId_Pedido() {
		return id_Pedido;
	}


	public void setId_Pedido(int id_Pedido) {
		this.id_Pedido = id_Pedido;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
}
