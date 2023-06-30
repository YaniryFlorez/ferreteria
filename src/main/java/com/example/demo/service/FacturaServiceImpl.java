package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.FacturaRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.modelo.DetalleFactura;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Item;

@Service
public class FacturaServiceImpl implements FacturaService{

	@Autowired
	private FacturaRepository facturaRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public void crear(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.ingresar(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.actualizar(factura);
	}

	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.facturaRepository.eliminar(id);
	}

	@Override
	public void crearFactura(List<Item> productos, String cedCliente, String numeroVenta) {
		// TODO Auto-generated method stub
        List<DetalleFactura> detallesFactura = new ArrayList<>();


        Factura factu = new Factura();
        factu.setCedulaCliente(cedCliente);
        factu.setFecha(LocalDate.now());
        factu.setNumero(numeroVenta);


        BigDecimal totFactVenta = new BigDecimal(0);

 
        for (Item item : productos) {

            DetalleFactura detfactura = new DetalleFactura();

            Item itembuscado = this.itemRepository.seleccionarPorCodBarras(item.getCodigoBarras());


            if (itembuscado.getStock() >= item.getStock()) {

                itembuscado.setStock(itembuscado.getStock() - item.getStock());

                this.itemRepository.actualizar(itembuscado);

 

                detfactura.setCantidad(item.getStock());
                detfactura.setPrecioUnid(itembuscado.getPrecio());
                detfactura.setSubtotal(itembuscado.getPrecio().multiply(new BigDecimal(item.getStock())));
                factu.setTotalVenta(detfactura.getSubtotal());
                detfactura.setItem(itembuscado);
                detfactura.setFactura(factu);
                detallesFactura.add(detfactura);
                factu.setListDetalles(detallesFactura);
                this.facturaRepository.ingresar(factu);

                } 
            else 
               {

                System.out.println("No se puede realizar la venta");

               }


        }	}

}
