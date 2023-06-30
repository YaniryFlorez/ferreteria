package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.DetalleFactura;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class DetalleFacturaRepositoryImpl implements DetalleFacturaRepository{
	
	@Autowired
	private EntityManager entityManager;
	

	@Override
	public void ingresar(DetalleFactura delfactura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(delfactura);
	}

	@Override
	public void actualizar(DetalleFactura delfactura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(delfactura);
	}

	@Override
	public DetalleFactura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(DetalleFactura.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}

}
