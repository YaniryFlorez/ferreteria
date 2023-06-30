package com.example.demo.repository;

import com.example.demo.repository.modelo.Item;

public interface ItemRepository {
   
	public void ingresar(Item item);
	public void actualizar (Item  item);
	public Item buscar(Integer id);
	public void eliminar(Integer id);
	public Item seleccionarPorCodBarras(String codBrras);
	public Item seleccionarStockPorCodBarras(String codBrras);

	
	
}
