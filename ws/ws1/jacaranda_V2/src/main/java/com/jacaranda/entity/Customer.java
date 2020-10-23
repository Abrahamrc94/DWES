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

	private String name;
	private String surname;
	private LocalDate birthdate;
	private String addres;
	private String city;
	private String dni;
	private String country;
	private String mobilenumber;
	private String gender;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany
	@JoinColumn(name="id_Pedido", foreignKey = @ForeignKey(name="id_Pedido_fk"), nullable = false, insertable=false, updatable=false)
	private List<Pedido> pedidos;
	
	
	public Customer() {
		super();
	}

	public Customer(String name, String surname, String city, String dni, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.dni = dni;
		this.id = id;
		pedidos = new ArrayList<Pedido>();
	}
	
	
	
	
	
	public Customer(String name, String surname, LocalDate birthdate, String addres, String city, String dni,
			String country, String mobilenumber, String gender, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.addres = addres;
		this.city = city;
		this.dni = dni;
		this.country = country;
		this.mobilenumber = mobilenumber;
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
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
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
