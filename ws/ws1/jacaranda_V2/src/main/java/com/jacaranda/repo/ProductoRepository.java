package com.jacaranda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Producto;

@Repository(value="productoRepository")
public interface ProductoRepository extends CrudRepository<Producto, Integer>{
	

		// Get de un producto por nombre
		public  Producto findProductoByNombre(String nombre);

		//Busca un producto por id
		public Producto findProductoById(Long id);
		
		
		// Get de todos los productos ordenado por nombre
		@Query(value = "select * from producto order by nombre", nativeQuery = true)
		public List<Producto> findAllOrderedByName();
	
}
