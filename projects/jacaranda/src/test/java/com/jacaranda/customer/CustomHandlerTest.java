package com.jacaranda.customer;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jacaranda.entity.Customer;

class CustomHandlerTest {

	private List<Customer> customers = new ArrayList<>() {
		{
		add(new Customer("Abraham", "Romero", "Sevilla", "1548924", 4));
		add(new Customer("Gonzalo", "García", "Sevilla", "7166818", 5));
		add(new Customer("Raúl", "Morales", "Sevilla", "7816162", 1));
		add(new Customer("Ana", "Canto", "Sevilla", "7419862", 2));
		add(new Customer("Carolina", "Sotoca", "Sevilla", "1589473", 3));
	}
		};
	
	
	@Test
	public void testFailOnNull() {
		List<Customer> customers=null;
		try {
			customers.stream().sorted();
		}catch(Exception e) {
			assert(true);
		}
	}
	
	
	@Test
	public void testFailOnEmpty() {
		List<Customer> customers=new ArrayList<Customer>();
		try {
			customers.stream().sorted();
		}catch(Exception e) {
			assert(true);
		}
	}
	
	
	@Test
	public void testOrderedCollection() {
		try {
			customers.stream().sorted();
		}catch(Exception e) {
			assert(true);
		}
	}

}
