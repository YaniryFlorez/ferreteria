package com.example.demo.repository;

import com.example.demo.repository.modelo.Factura;

public interface FacturaRepository {
   
	public void ingresar(Factura factura);
	public void actualizar (Factura factura);
	public Factura buscar(Integer id);
	public void eliminar(Integer id);
	
}
