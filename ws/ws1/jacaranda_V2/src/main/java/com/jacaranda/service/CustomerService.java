package com.jacaranda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jacaranda.entity.Customer;
import com.jacaranda.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	//Get de todos los customers
	public ResponseEntity<?> getCustomers() {
		return ResponseEntity.status(HttpStatus.OK).body(customerRepository.findAll());
	}
	
	//Get para un customer por id
	public Customer getCustomerById(int id) {
		return customerRepository.findCustomerById(id);
	
	}
	
	//Get de todos los customers por nombre
	public List<Customer> getCustomerOrderByNombre() {
		return customerRepository.findAllOrderedByName();
	}
	
	//Crear un nuevo customer
	public Customer saveCustomer(Customer sent) {
		return customerRepository.save(sent);
	}
	
	
	//Borrar un customer
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);;
	}
	
}
