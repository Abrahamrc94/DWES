package service;

import org.springframework.stereotype.Service;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Pedido;
import com.jacaranda.entity.Producto;

@Service
public class UpdateService {

	//Servicio para actualizar un producto
	public void upProduct(Producto p, Producto sent) {
		p.setNombre((sent.getNombre()==null)? p.getNombre():sent.getNombre());
		p.setPrecio((sent.getPrecio()==0)? p.getPrecio():sent.getPrecio());
		p.setStock((sent.getStock()==0)? p.getStock():sent.getStock());
	}
	
	//Servicio para actualizar un pedido
	public void upPedido(Pedido p, Pedido sent) {
		p.setCustomer((sent.getCustomer()==null)? p.getCustomer():sent.getCustomer());
		p.setEstado((sent.getEstado()==null)? p.getEstado():sent.getEstado());
		p.setProductos((sent.getProductos()==null)? p.getProductos():sent.getProductos());
		p.setTotal((sent.getTotal()==0)? p.getTotal():sent.getTotal());
	}
	
	//Servicio para actualizar un customer
	public void upCustomer(Customer c, Customer sent) {
		c.setName((sent.getName()== null)? c.getName(): sent.getName());
		c.setSurname((sent.getSurname()== null)? c.getSurname(): sent.getSurname());
		c.setBirthdate((sent.getBirthdate()== null)? c.getBirthdate(): sent.getBirthdate());
		c.setAddres((sent.getAddres()== null)? c.getAddres(): sent.getAddres());
		c.setCity((sent.getCity()==null)? c.getCity(): sent.getCity());
		c.setMobilenumber((sent.getMobilenumber()==null)? c.getMobilenumber(): sent.getMobilenumber());
		c.setCountry((sent.getCountry()==null)? c.getMobilenumber(): sent.getMobilenumber());
		c.setDni((sent.getDni()==null)? c.getDni(): sent.getDni());
		c.setGender((sent.getGender()==null)? c.getDni():sent.getDni());
		c.setPedidos((sent.getPedidos()==null)? c.getPedidos(): sent.getPedidos());
	}
	
}
