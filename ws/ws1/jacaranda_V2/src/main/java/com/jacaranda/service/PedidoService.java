package com.jacaranda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Pedido;
import com.jacaranda.entity.Producto;
import com.jacaranda.repo.PedidoRepository;

@Service
public class PedidoService {

	//Repositorios
	@Autowired
	private PedidoRepository pedidoRepository;
	
	// Servicios
	@Autowired
	private UpdateService updateService;

	//Get de todos los pedidos
	public ResponseEntity<?> getPedidos() {
		return ResponseEntity.status(HttpStatus.OK).body(pedidoRepository.findAll());
	}
	
	//Get para un pedido por id
	public Pedido getPedidoById(int id) {
		return pedidoRepository.findPedidoById(id);
	
	}
	
	//Get de todos los pedidos por el estado
	public List<Pedido> getPedidoOrderByEstado() {
		return pedidoRepository.findAllOrderedByEstado();
	}
	
	//Crear un nuevo pedido
	public Pedido savePedido(Pedido sent) {
		return pedidoRepository.save(sent);
	}
	
	//Actualizar un pedido
	public ResponseEntity<?> updatePedido(int id, Pedido sent) {
		Pedido p = pedidoRepository.findPedidoById(id);
		ResponseEntity<?> response;
		if (p == null) {
			response = ResponseEntity.notFound().build();
		} else {
			updateService.updatePedido(p, sent);
			response = ResponseEntity.ok(pedidoRepository.save(p));
		}
		return response;
	}
	
	//Borrar un pedido
	public void deletePedido(int id) {
		pedidoRepository.deleteById(id);;
	}
	
	
}
