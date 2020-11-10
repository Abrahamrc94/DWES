package com.jacaranda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable{

	@ManyToOne
	@JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "Customer_ID_FK"))
	private Customer customerId;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	private int total;//El precio total del pedido
	private String estado;//Si el pedido está pendiente, entregado o en reparto
	@OneToMany
	@JoinColumn(foreignKey = @ForeignKey(name = "producto_fk"), name = "producto_nombre", insertable=false, updatable=false)
	private List<Producto> productos;
	
	
	public Pedido() {
		super();
	}


	public Pedido(Customer customerId, int id, int total, String estado) {
		super();
		this.customerId = customerId;
		this.id = id;
		this.total = total;
		this.estado = estado;
		productos = new ArrayList<Producto>();
	}


	public int getId() {
		return id;
	}


	public void setId_(int id) {
		this.id = id;
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
		return customerId;
	}


	public void setCustomer(Customer customerId) {
		this.customerId = customerId;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
}
