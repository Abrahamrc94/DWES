package com.jacaranda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@Column(nullable = false)
	private String name;
	private String surname;
	private String dni;
	private String gender;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pedido> pedidos;
	@OneToOne(targetEntity = Document.class)
	@JsonIgnore
	private Document document;
	
	
	
	public Customer() {
		super();
	}

	public Customer(String name, String surname, String dni, Long id) {
		super();
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.customerId = id;
		pedidos = new ArrayList<Pedido>();
	}
	
	
	
	
	
	public Customer(String name, String surname, String dni, String gender, Long id) {
		super();
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.gender = gender;
		this.customerId = id;
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
	
	public Long getId() {
		return customerId;
	}

	public void setId(Long id) {
		this.customerId = id;
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
	
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
}
