package com.jacaranda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Pedido;
import com.jacaranda.repo.CustomerRepository;


public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	//Get de todos los pedidos
	public ResponseEntity<?> getCustomers() {
		return ResponseEntity.status(HttpStatus.OK).body(customerRepository.findAll());
	}
	
	//Get para un pedido por id
	public Customer getCustomerById(int id) {
		return customerRepository.findCustomerById(id);
	
	}
	
	//Get de todos los pedidos por nombre
	public List<Customer> getCustomerOrderByNombre() {
		return customerRepository.findAllOrderedByName();
	}
	
	//Crear un nuevo pedido
	public Customer saveCustomer(Customer sent) {
		return customerRepository.save(sent);
	}
	
	
	//Borrar un pedido
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);;
	}
	
}
