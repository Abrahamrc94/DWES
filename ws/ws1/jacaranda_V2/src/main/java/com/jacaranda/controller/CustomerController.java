/**
 * 
 */
package com.jacaranda.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.jacaranda.CustomersIdComparator;
import com.jacaranda.entity.Customer;

import service.CheckService;
import service.UpdateService;



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
	
		
		//Creamos los servicios
		@Autowired
		private CheckService checkService;
		@Autowired
		private UpdateService updateService;	
		
		
	//Devuelve los datos ordenados por el id
	@GetMapping("/customers")
	public List<Customer> getCustomersOrden(){
		customers.sort(new CustomersIdComparator());
		return customers;
	}
	
	//Devuelve un customer en concreto
			@GetMapping("/customers/{id}")
			public ResponseEntity<?> getCustomerId(@PathVariable int id){
				Customer customer = checkService.comprobarCustomer(customers, id);
				ResponseEntity<?> respuesta;
				if(customer == null) {
					respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El customer no existe");
				}else {
					respuesta = ResponseEntity.status(HttpStatus.OK).body(customer);
				}
				return respuesta;
			}
			
			@PostMapping("/customers")
			public ResponseEntity<?> createCustomer(@RequestBody Customer sent){
				ResponseEntity respuesta;
				Customer customer = checkService.comprobarCustomer(customers, sent.getId());
				if(customer == null) {
					customers.add(sent);
					respuesta = ResponseEntity.status(HttpStatus.CREATED).body("El customer se ha creado");
				}else {
					respuesta = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el customer");
				}
				return respuesta;
			}
			
			@PutMapping("/customers")
			public ResponseEntity<?> modifyPedido(@RequestBody Customer sent){
				ResponseEntity respuesta;
				Customer customer = checkService.comprobarCustomer(customers, sent.getId());
				if(customer == null) {
					respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el customer");
				}else {
					updateService.upCustomer(customer, sent);
					respuesta = ResponseEntity.status(HttpStatus.ACCEPTED).body("Se ha actualziado el customer");
				}
				return respuesta;
			
			}
			
			@DeleteMapping("/customers")
			public ResponseEntity<?> deletePedido(@RequestBody Customer sent){
				
				Customer customerToDelete=checkService.comprobarCustomer(customers, sent.getId());
				ResponseEntity respuesta;
				
					if(customerToDelete==null) {
						respuesta=ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el customer");
					}else {
						customers.remove(customerToDelete);
						respuesta=ResponseEntity.status(HttpStatus.ACCEPTED).body("Se ha eliminado el customer");
					}
				
				return respuesta;
			}

}
