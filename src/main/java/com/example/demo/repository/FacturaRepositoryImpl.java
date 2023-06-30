package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Item;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class FacturaRepositoryImpl implements FacturaRepository{

	@Autowired
	private EntityManager entityManager;

	@Override
	public void ingresar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}
	
	

}
