package com.jacaranda;

import java.util.Comparator;

import com.jacaranda.entity.Customer;

public class CustomersIdComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		// TODO Auto-generated method stub
		return c1.getId() < c2.getId() ? -1 : c1.getId() > c2.getId() ? +1 : 0;
	}

}