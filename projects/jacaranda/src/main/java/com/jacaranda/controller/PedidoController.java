package com.jacaranda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
