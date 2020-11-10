package com.jacaranda.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private String dni;
	private String gender;

	@OneToMany
	@JoinColumn(name="id_Pedido", foreignKey = @ForeignKey(name="id_Pedido_fk"), nullable = false, insertable=false, updatable=false)
	private List<Pedido> pedidos;
	
	
	public Customer() {
		super();
	}

	public Customer(String name, String surname, String dni, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.id = id;
		pedidos = new ArrayList<Pedido>();
	}
	
	
	
	
	
	public Customer(String name, String surname, String dni, String gender, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.gender = gender;
		this.id = id;
		pedidos = new ArrayList<Pedido>();
	}



	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
