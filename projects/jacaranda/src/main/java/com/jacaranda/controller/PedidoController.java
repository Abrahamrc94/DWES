package com.jacaranda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Pedido;

@RestController
@RequestMapping(path="/api")
public class PedidoController {

	private List<Pedido> pedidos= new ArrayList<>() {
		{
			add(new Pedido(null, 1, 100, "Pendiente"));
			add(new Pedido(null, 2, 5, "Reparto"));
			add(new Pedido(null, 3, 20, "Entregado"));
			add(new Pedido(null, 4, 75, "Pendiente"));
		}
	};
	
	@GetMapping("/pedidos")
	public List<Pedido> getPedidos(){
		return pedidos;
	}
	
	
	@PostMapping("/pedidos")
	public ResponseEntity<?> createPedido(@RequestBody Pedido sent){
		ResponseEntity respuesta=null;
		for(Pedido p: pedidos) {
			if(sent.getId_Pedido()==p.getId_Pedido()) {
				respuesta=ResponseEntity.status(HttpStatus.CONFLICT).body(sent);
			}else {
				pedidos.add(sent);
				respuesta=ResponseEntity.status(HttpStatus.CREATED).body(sent);
			}
		
		
		}
		return respuesta;
	}
	
	@PutMapping("/pedidos")
	public ResponseEntity<?> modifyCustomer(@RequestBody Pedido ped1){
		
		ResponseEntity respuesta=null;
		for(Pedido p: pedidos) {
			if(ped1.getId_Pedido()==p.getId_Pedido()) {
				p.setCustomer(ped1.getCustomer());
				p.setEstado(ped1.getEstado());
				p.setTotal(ped1.getTotal());
				p.setProductos(ped1.getProductos());
			}else {
				respuesta=ResponseEntity.status(HttpStatus.NOT_FOUND).body(ped1);
			}
		}
		
		return respuesta;
	}
	
	@DeleteMapping("/customers")
	public ResponseEntity<?> deleteCustomer(@RequestBody Pedido ped1){
		
		Pedido pedidoToDelete=null;
		ResponseEntity respuesta=null;
		for(Pedido p: pedidos) {
			if(ped1.getId_Pedido()==p.getId_Pedido()) {
				pedidoToDelete=p;
				pedidos.remove(pedidoToDelete);
				respuesta=ResponseEntity.status(HttpStatus.OK).body(ped1);
			}else {
				respuesta=ResponseEntity.status(HttpStatus.NOT_FOUND).body(ped1);
			}
		}
		
		return respuesta;
	}
	
}

