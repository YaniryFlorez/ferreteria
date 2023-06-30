package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DetalleFacturaRepository;
import com.example.demo.repository.modelo.DetalleFactura;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService{

	@Autowired
	private DetalleFacturaRepository detalleFacturaRepository;
	@Override
	public void crear(DetalleFactura delfactura) {
		// TODO Auto-generated method stub
		this.detalleFacturaRepository.ingresar(delfactura);
	}

	@Override
	public void actualizar(DetalleFactura delfactura) {
		// TODO Auto-generated method stub
		this.detalleFacturaRepository.actualizar(delfactura);
	}

	@Override
	public DetalleFactura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.detalleFacturaRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.detalleFacturaRepository.eliminar(id);
	}

}
