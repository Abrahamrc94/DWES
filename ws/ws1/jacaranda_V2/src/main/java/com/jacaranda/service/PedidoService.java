package com.jacaranda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jacaranda.entity.Pedido;
import com.jacaranda.entity.Producto;
import com.jacaranda.repo.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

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
	
	
	//Borrar un pedido
	public void deletePedido(int id) {
		pedidoRepository.deleteById(id);;
	}
	
	
}
