/**
 * 
 */
package com.jacaranda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.CustomersIdComparator;
import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Pedido;
import com.jacaranda.entity.Producto;



/**
 * @author estudiante
 *
 */

@RestController
@RequestMapping(path="/api")
public class CustomerController {

	private List<Customer> customers = new ArrayList<>() {
		{
		add(new Customer("Abraham", "Romero", "Sevilla", "1548924", 4));
		add(new Customer("Gonzalo", "García", "Sevilla", "7166818", 5));
		add(new Customer("Raúl", "Morales", "Sevilla", "7816162", 1));
		add(new Customer("Ana", "Canto", "Sevilla", "7419862", 2));
		add(new Customer("Carolina", "Sotoca", "Sevilla", "1589473", 3));
	}
		};
	
		//Devulve los customers en el mismo orden en que están introducidos en la lista
//	@GetMapping("/customers")
//	public List<Customer> getCustomers(){
//		return customers;
//	}
	
		
	//Devuelve los datos ordenados por el id
	@GetMapping("/customers")
	public List<Customer> getCustomersOrden(){
		customers.sort(new CustomersIdComparator());
		return customers;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<?> createCustomer(@RequestBody Customer sent){
		ResponseEntity respuesta=null;
		for(Customer c: customers) {
			if(sent.getId()==c.getId()) {
				respuesta=ResponseEntity.status(HttpStatus.CONFLICT).body(sent);
			}else {
				customers.add(sent);
				respuesta=ResponseEntity.status(HttpStatus.CREATED).body(sent);
			}
		
		
		}
		return respuesta;
	}
	
	
	//Petición POST para añadir productos al pedido indicado
		@PostMapping("/customers/{id}")
		public ResponseEntity<?> addProducto(@PathVariable int id, @RequestBody Pedido ped){
			ResponseEntity respuesta=ResponseEntity.status(HttpStatus.CONFLICT).body("FAILED");;
			for(Customer c: customers) {
				if(id==c.getId()) {
					c.getPedidos().add(ped);
					ped.setCustomer(c.getName());
					respuesta=ResponseEntity.status(HttpStatus.OK).body("OK");
				}
			}
			return respuesta;
		}
	
	@PutMapping("/customers")
	public ResponseEntity<?> modifyCustomer(@RequestBody Customer cust1){
		
		ResponseEntity respuesta=null;
		for(Customer c: customers) {
			if(cust1.getId()==c.getId()) {
				c.setName(cust1.getName());
				c.setSurname(cust1.getSurname());
				c.setAddres(cust1.getAddres());
				c.setBirthdate(cust1.getBirthdate());
				c.setCity(cust1.getCity());
				c.setCountry(cust1.getCountry());
				c.setDni(cust1.getDni());
				c.setGender(cust1.getGender());
				c.setMobilenumber(cust1.getMobilenumber());
				respuesta=ResponseEntity.status(HttpStatus.OK).body(cust1);
			}else {
				respuesta=ResponseEntity.status(HttpStatus.NOT_FOUND).body(cust1);
			}
		}
		
		return respuesta;
	}
	
	@DeleteMapping("/customers")
	public ResponseEntity<?> deleteCustomer(@RequestBody Customer cust1){
		
		Customer customerToDelete=null;
		ResponseEntity respuesta=null;
		for(Customer c: customers) {
			if(cust1.getId()==c.getId()) {
				customerToDelete=c;
				customers.remove(customerToDelete);
				respuesta=ResponseEntity.status(HttpStatus.OK).body(cust1);
			}else {
				respuesta=ResponseEntity.status(HttpStatus.NOT_FOUND).body(cust1);
			}
		}
		
		return respuesta;
	}

}
