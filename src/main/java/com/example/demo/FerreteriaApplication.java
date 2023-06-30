package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Item;
import com.example.demo.service.FacturaService;
import com.example.demo.service.ItemService;

@SpringBootApplication
public class FerreteriaApplication implements CommandLineRunner{
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private FacturaService facturaService;
	

	public static void main(String[] args) {
		SpringApplication.run(FerreteriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Item ite= new Item();
		ite.setCodigoBarras("123");
		ite.setNombre("tornillos");
		ite.setPrecio(new BigDecimal(1));
		ite.setStock(25);
		ite.setTipo("herramientas");
		
		//this.itemService.crear(ite);
		
		//this.itemService.crear(ite);

		

		   List<Item> listaProductos = new ArrayList<>();

           listaProductos.add(ite);
           
           this.facturaService.crearFactura(listaProductos, "170184678", "1");
           System.out.println("consulta Criteria API Query");
		   this.itemService.mostrarStockPorCodBarras("123");
		   

           



	}

}
