/**
 * 
 */
package com.jacaranda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Customer;
import com.jacaranda.service.CustomerService;



/**
 * @author estudiante
 *
 */

@RestController
@RequestMapping(path="/api")
public class CustomerController {
	
		//Creamos los servicios
		@Autowired
		private CustomerService customerService;
		
				
		//Devuelve todos los customers
		@GetMapping("/customers")
		public ResponseEntity<?> getCustomers(){
			return customerService.getCustomers();
		}
		
		//Devuelve customers ordenados segun el nombre
		@GetMapping("/customers/nombres")
		public ResponseEntity<?> getCustomerOrderByNombre(){
			return ResponseEntity.ok(customerService.getCustomerOrderByNombre());
		}
		
		//Devuelve un customer segun el id
		@GetMapping("/customers/{id}")
		public ResponseEntity<?> getCustomerId(@PathVariable int id){
			return ResponseEntity.ok(customerService.getCustomerById(id));
		}
			
		
		//Crea un customer
		@PostMapping("/customers")
		public Customer createCustomer(@RequestBody Customer sent){
			return customerService.saveCustomer(sent);
		}
		
		
		//Modifica un customer PUT

		
		
		//Borra un customer
		@DeleteMapping("/customers/{id}")
		public void deleteCustomer(@RequestBody int id){
			customerService.deleteCustomer(id);
		}
}