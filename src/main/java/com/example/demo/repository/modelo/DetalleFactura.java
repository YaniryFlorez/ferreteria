package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="detallefactura")
public class DetalleFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_delfac")
	@SequenceGenerator(name = "seq_delfac", sequenceName = "seq_delfac", allocationSize = 1)

	@Column(name="delfact_id")
	private Integer id;
	@Column(name="delfact_cantidad")
	private Integer cantidad;
	@Column(name="delfact_precio_unid")
	private BigDecimal precioUnid;
	@Column(name="delfact_sudtotal")
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name="delfact_id_producto")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="delfact_id_venta")
	private Factura factura;
	
	//SET Y GET


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnid() {
		return precioUnid;
	}

	public void setPrecioUnid(BigDecimal precioUnid) {
		this.precioUnid = precioUnid;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", precioUnid=" + precioUnid + ", subtotal="
				+ subtotal + ", item=" + item + ", factura=" + factura + "]";
	}



}
