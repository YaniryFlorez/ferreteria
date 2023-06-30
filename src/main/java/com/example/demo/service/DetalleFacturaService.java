package com.example.demo.service;

import com.example.demo.repository.modelo.DetalleFactura;

public interface DetalleFacturaService {
	
	 
		public void crear(DetalleFactura delfactura);
		public void actualizar (DetalleFactura  delfactura);
		public DetalleFactura buscar(Integer id);
		public void borrar(Integer id);

}
