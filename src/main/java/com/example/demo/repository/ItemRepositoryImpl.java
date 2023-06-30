package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ItemRepositoryImpl implements ItemRepository{

	@Autowired
	private EntityManager entityManager;

	@Override
	public void ingresar(Item item) {
		// TODO Auto-generated method stub
		this.entityManager.persist(item);
	}

	@Override
	public void actualizar(Item item) {
		// TODO Auto-generated method stub
		this.entityManager.merge(item);
		
	}

	@Override
	public Item buscar(Integer id) {
		return this.entityManager.find(Item.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}

	@Override
	public Item seleccionarPorCodBarras(String codBrras) {
		// TODO Auto-generated method stub
		TypedQuery<Item> myQuery =this.entityManager.createNamedQuery("Item.seleccionarPorCodigoBarras", Item.class);
		myQuery.setParameter("datoCodigoBarra", codBrras);
		
		try {
			return myQuery.getSingleResult();

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("codigo de barras no enconttrado");
			return null;
		}
	}

	@Override
	public Item seleccionarStockPorCodBarras(String codBrras) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Item> myCriteriaQuery = 
				myCriteriaBuilder.createQuery(Item.class);
		
		Root<Item> myTablaFrom = myCriteriaQuery.from(Item.class);//from item
		
		Predicate condicionBarras = myCriteriaBuilder.equal(myTablaFrom.get("codigoBarras"), codBrras);

		myCriteriaQuery.select(myTablaFrom).where(condicionBarras);
		
		TypedQuery<Item> myTypedQuery= this.entityManager.createQuery(myCriteriaQuery);
		
		


		return myTypedQuery.getSingleResult();
	}
	
	
}
