package com.example.demo.service;

import com.example.demo.repository.modelo.Item;

public interface ItemService {
	
	 
		public void crear(Item item);
		public void actualizar (Item  item);
		public Item buscar(Integer id);
		public void borrar(Integer id);
		public void mostrarStockPorCodBarras(String codBrras);

		

}
