/**
 * 
 */
package com.jacaranda.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Pedido;
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
		@GetMapping("/customer")
		public ResponseEntity<?> getCustomers(){
			return customerService.getCustomers();
		}
		
		//Devuelve customers ordenados segun el nombre
		@GetMapping("/customer/nombres")
		public ResponseEntity<?> getCustomerOrderByNombre(){
			return ResponseEntity.ok(customerService.getCustomerOrderByNombre());
		}
		
		//Devuelve un customer segun el id
		@GetMapping("/customer/{id}")
		public ResponseEntity<?> getCustomerId(@PathVariable Long id){
			return ResponseEntity.ok(customerService.getCustomerById(id));
		}
			
		
		//Crea un customer
		@PostMapping("/customer")
		public Customer createCustomer(@RequestBody Customer sent){
			return customerService.saveCustomer(sent);
		}
		
		//Asigna un pedido al customer
		@PostMapping("/customer/{id}")
		public ResponseEntity<?> addPedido(@RequestBody Pedido newPedido, @PathVariable Long id) {
			
			ResponseEntity<?> response = null;
			Customer resultado = customerService.addPedido(newPedido, id);
			
			if (resultado == null) {
				response = ResponseEntity.status(HttpStatus.CONFLICT).body("Ha surgido algo inesperado");
			} else {
				response = ResponseEntity.status(HttpStatus.OK).body(resultado);
			}
			
			return response;
		}
		
		
		//Modifica un customer PUT
		@PutMapping("/customer/{id}")
		public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer sent) {
			return customerService.updateCustomer(id, sent);
		}
		
		
		//Borra un customer
		@DeleteMapping("/customer/{id}")
		public void deleteCustomer(@RequestBody int id){
			customerService.deleteCustomer(id);
		}
}