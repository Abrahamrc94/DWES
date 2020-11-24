package com.jacaranda.service;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Pedido;
import com.jacaranda.repo.CustomerRepository;
import com.jacaranda.repo.PedidoRepository;

public class CustomeraddPedidoServiceTest {

	
	private CustomerService sut;
	
	
	private CustomerRepository mockCustomerRepo;
	private PedidoRepository mockPedidoRepo;
	
	
	private Customer mockCustomer;
	private Pedido mockPedido;
	
	@BeforeEach
	private void init() {
		sut= new CustomerService();
		mockCustomerRepo = mock(CustomerRepository.class);
		mockPedidoRepo = mock(PedidoRepository.class);
		mockCustomer = mock(Customer.class);
		mockPedido = mock(Pedido.class);
		
	}
	
	@Test
	public void addingPedidoToCustomer() {
		
		Mockito.when(mockCustomerRepo.findCustomerBycustomerId(Mockito.anyLong())).thenReturn(mockCustomer);
		//Mockito.when(mockPedido.setCustomer(idCustomer))
		//mockPedido.setCustomer(mockCustomer.getId());
		Mockito.when(mockPedidoRepo.save(Mockito.any(Pedido.class))).thenReturn(mockPedido);
		
	}
	
	
}
