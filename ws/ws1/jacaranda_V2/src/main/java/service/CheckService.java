package service;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Pedido;
import com.jacaranda.entity.Producto;

@Service
public class CheckService {

	//Servicio para comprobar productos
	public Producto comprobarProducto(List<Producto> productos, String nombre) {
		boolean encontrado=false;
		Producto resultado=null;
		Iterator<Producto> iterador=productos.iterator();
		
		while(!encontrado && iterador.hasNext()) {
			Producto p=iterador.next();
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				encontrado=true;
				resultado=p;
			}
		}
		return resultado;
		
	}
	
	//Servicio para comprobar pedidos
	
	public Pedido comprobarPedido(List<Pedido> pedidos, int id) {
		boolean encontrado=false;
		Pedido resultado=null;
		Iterator<Pedido> iterador=pedidos.iterator();
		
		while(!encontrado && iterador.hasNext()) {
			Pedido p=iterador.next();
			if(p.getId_Pedido()==id) {
				encontrado=true;
				resultado=p;
			}
		}
		return resultado;
		
	}
	
	//Servicio para comprobar customers
	
	public Customer comprobarCustomer(List<Customer> customers, int id) {
		boolean encontrado=false;
		Customer resultado=null;
		Iterator<Customer> iterador=customers.iterator();
		
		while(!encontrado && iterador.hasNext()) {
			Customer c=iterador.next();
			if(c.getId()==id) {
				encontrado=true;
				resultado=c;
			}
		}
		return resultado;
		
	}
	
	
}
