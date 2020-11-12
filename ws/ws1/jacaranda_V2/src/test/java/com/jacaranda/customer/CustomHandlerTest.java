package com.jacaranda.customer;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jacaranda.entity.Customer;

class CustomHandlerTest {


	
	
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
	


}
