package com.jacaranda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Customer;

@Repository(value="customerRepository")
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	
			// Get de un customer por nombre
			public Customer findCustomerByName(String name);

			//Busca un producto por id
			public Customer findCustomerBycustomerId(Long id);
			
			
			// Get de todos los productos ordenado por nombre
			@Query(value = "select * from customer order by name", nativeQuery = true)
			public List<Customer> findAllOrderedByName();
}
