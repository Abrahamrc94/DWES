package com.jacaranda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Pedido;
import com.jacaranda.repo.CustomerRepository;
import com.jacaranda.repo.PedidoRepository;

@Service
public class CustomerService {

	//Repositorios
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	
	// Servicios
	@Autowired
	private UpdateService updateService;
	
	
	public CustomerService(CustomerRepository customerRepository, PedidoRepository pedidoReposiroty) {
		this.customerRepository=customerRepository;
		this.pedidoRepository = pedidoReposiroty;
		
	}

	//Get de todos los customers
	public ResponseEntity<?> getCustomers() {
		return ResponseEntity.status(HttpStatus.OK).body(customerRepository.findAll());
	}
	
	//Get para un customer por id
	public Customer getCustomerById(Long id) {
		return customerRepository.findCustomerBycustomerId(id);
	
	}
	
	//Get de todos los customers por nombre
	public List<Customer> getCustomerOrderByNombre() {
		return customerRepository.findAllOrderedByName();
	}
	
	//Crear un nuevo customer
	public Customer saveCustomer(Customer sent) {
		return customerRepository.save(sent);
	}
	
	
	//Asignar un pedido
	public Customer addPedido(Pedido newPedido, Long idCustomer) {
		// se guarda el cliente en una variable auxiliar
		Customer auxCustomer = customerRepository.findCustomerBycustomerId(idCustomer);
		
		// se inserta el id de cliente en el pedido
		newPedido.setCustomer(idCustomer);
			
		// se guarda el pedido en la BBDD
		pedidoRepository.save(newPedido);
			
		// se inserta el pedido al cliente
		auxCustomer.getPedidos().add(newPedido);
			
		// se guarda el cliente en la BBDD
		customerRepository.save(auxCustomer);
		
		return auxCustomer;
	}
	
	
	
	//Actualziar un customer
	public ResponseEntity<?> updateCustomer(Long id, Customer sent) {
		Customer c = customerRepository.findCustomerBycustomerId(id);
		ResponseEntity<?> response;
		if (c == null) {
			response = ResponseEntity.notFound().build();
		} else {
			updateService.updateCustomer(c, sent);
			response = ResponseEntity.ok(customerRepository.save(c));
		}
		return response;
	}
	
	
	//Borrar un customer
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);;
	}
	
}
