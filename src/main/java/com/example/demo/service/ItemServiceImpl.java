package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.modelo.Item;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void crear(Item item) {
		// TODO Auto-generated method stub
		if(this.itemRepository.seleccionarPorCodBarras(item.getCodigoBarras())== null){
		  this.itemRepository.ingresar(item);
		}
		else {
			Item itembuscado=this.itemRepository.seleccionarPorCodBarras(item.getCodigoBarras());
			itembuscado.setStock(itembuscado.getStock()+item.getStock());
			this.itemRepository.actualizar(itembuscado);
		}
		
	}

	@Override
	public void actualizar(Item item) {
		// TODO Auto-generated method stub
		this.itemRepository.actualizar(item);
	}

	@Override
	public Item buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.itemRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.itemRepository.eliminar(id);
	}

	@Override
	public void mostrarStockPorCodBarras(String codBrras) {
		// TODO Auto-generated method stub
		Item mostrarStock = this.itemRepository.seleccionarStockPorCodBarras(codBrras);
		System.out.println("Item Nombre:   "+ mostrarStock.getNombre()+ "   stock:  "+mostrarStock.getStock() );
		
	}

	

}
