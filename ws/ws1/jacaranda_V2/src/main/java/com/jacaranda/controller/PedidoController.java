package com.jacaranda.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Pedido;
import com.jacaranda.entity.Producto;

import service.CheckService;
import service.UpdateService;

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
	
	//Creamos los servicios
	@Autowired
	private CheckService checkService;
	@Autowired
	private UpdateService updateService;
	
	@GetMapping("/pedidos")
	public List<Pedido> getPedidos(){
		return pedidos;
	}
	
	//Devuelve un pedido en concreto
		@GetMapping("/pedidos/{id}")
		public ResponseEntity<?> getProductoNombre(@PathVariable int id){
			Pedido pedido = checkService.comprobarPedido(pedidos, id);
			ResponseEntity<?> respuesta;
			if(pedido == null) {
				respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El pedido no existe");
			}else {
				respuesta = ResponseEntity.status(HttpStatus.OK).body(pedido);
			}
			return respuesta;
		}
		
		@PostMapping("/pedidos")
		public ResponseEntity<?> createPedido(@RequestBody Pedido sent){
			ResponseEntity respuesta;
			Pedido pedido = checkService.comprobarPedido(pedidos, sent.getId_Pedido());
			if(pedido == null) {
				pedidos.add(sent);
				respuesta = ResponseEntity.status(HttpStatus.CREATED).body("El pedido se ha creado");
			}else {
				respuesta = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el pedido");
			}
			return respuesta;
		}
		
		@PutMapping("/pedidos")
		public ResponseEntity<?> modifyPedido(@RequestBody Pedido sent){
			ResponseEntity respuesta;
			Pedido pedido = checkService.comprobarPedido(pedidos, sent.getId_Pedido());
			if(pedido == null) {
				respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el pedido");
			}else {
				updateService.upPedido(pedido, sent);
				respuesta = ResponseEntity.status(HttpStatus.ACCEPTED).body("Se ha actualziado el pedido");
			}
			return respuesta;
		
		}
		
		@DeleteMapping("/pedidos")
		public ResponseEntity<?> deletePedido(@RequestBody Pedido sent){
			
			Pedido pedidoToDelete=checkService.comprobarPedido(pedidos, sent.getId_Pedido());
			ResponseEntity respuesta;
			
				if(pedidoToDelete==null) {
					respuesta=ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el pedido");
				}else {
					pedidos.remove(pedidoToDelete);
					respuesta=ResponseEntity.status(HttpStatus.ACCEPTED).body("Se ha eliminado el pedido");
				}
			
			return respuesta;
		}
}

