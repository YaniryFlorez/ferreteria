package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Item;

public interface FacturaService {
	
	 
		public void crear(Factura factura);
		public void crearFactura(List<Item> productos,String cedCliente, String numeroVenta);
		public void actualizar (Factura  factura);
		public Factura buscar(Integer id);
		public void borrar(Integer id);

}
