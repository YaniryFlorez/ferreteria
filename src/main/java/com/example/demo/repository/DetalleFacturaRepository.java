package com.example.demo.repository;

import com.example.demo.repository.modelo.DetalleFactura;

public interface DetalleFacturaRepository {
   
	public void ingresar(DetalleFactura delfactura);
	public void actualizar (DetalleFactura delfactura);
	public DetalleFactura buscar(Integer id);
	public void eliminar(Integer id);
	
}
