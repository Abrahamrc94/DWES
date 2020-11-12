package com.jacaranda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Pedido;

@Repository(value="pedidoRepository")
public interface PedidoRepository extends CrudRepository<Pedido, Integer>{

			// Get de un pedido por nombre
			//public  Pedido findPedidoByName(String name);

			//Busca un pedido por id
			public Pedido findPedidoById(Long id);
			
			
			// Get de todos los pedidos ordenado por nombre
			@Query(value = "select * from pedido order by estado", nativeQuery = true)
			public List<Pedido> findAllOrderedByEstado();
}
