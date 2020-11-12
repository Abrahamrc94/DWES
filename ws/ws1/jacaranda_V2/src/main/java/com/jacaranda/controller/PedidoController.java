package com.jacaranda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Pedido;
import com.jacaranda.service.PedidoService;

@RestController
@RequestMapping(path="/api")
public class PedidoController {

	
	//Creamos los servicios
	@Autowired
	private PedidoService pedidoService;
	
			
	//Devuelve todos los productos
	@GetMapping("/pedido")
	public ResponseEntity<?> getPedidos(){
		return pedidoService.getPedidos();
	}
	
	//Devuelve pedidos ordenados segun el estado (pendiente, entregado, en reparto)
	@GetMapping("/pedido/estado")
	public ResponseEntity<?> getPedidoEstado(){
		return ResponseEntity.ok(pedidoService.getPedidoOrderByEstado());
	}
	
	//Devuelve un pedido segun el id
	@GetMapping("/pedido/{id}")
	public ResponseEntity<?> getPedidoId(@PathVariable int id){
		return ResponseEntity.ok(pedidoService.getPedidoById(id));
	}
		
	
	//Crea un pedido
	@PostMapping("/pedido")
	public Pedido createPedido(@RequestBody Pedido sent){
		return pedidoService.savePedido(sent);
	}
	
	
	//Modifica un pedido PUT
	@PutMapping(path = "/pedido/{id}")
	public ResponseEntity<?> updatePedido(@PathVariable int id, @RequestBody Pedido sent) {
		return pedidoService.updatePedido(id, sent);
	}
	
	
	//Borra un pedido
	@DeleteMapping("/pedido/{id}")
	public void deletePedido(@RequestBody int id){
		pedidoService.deletePedido(id);
	}
}
