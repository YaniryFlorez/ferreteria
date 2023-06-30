package com.example.demo.repository.modelo;
import java.util.List;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="item")
@NamedNativeQuery(name = "Item.seleccionarPorCodigoBarras",
                  query ="select * from Item where item_codigo_barras =:datoCodigoBarra",
                  resultClass =Item.class)

public class Item {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item")
	@SequenceGenerator(name = "seq_item", sequenceName = "seq_item", allocationSize = 1)

	@Column(name="item_id")
	private Integer id;
	@Column(name="item_codigo_barras")
	private String codigoBarras;
	@Column(name="item_nombre")
	private String nombre;
	@Column(name="item_tipo")
	private String tipo;
	@Column(name="item_stock")
	private Integer stock;
	@Column(name="item_precio")
	private BigDecimal precio;
	
	@OneToMany(mappedBy ="item", cascade =CascadeType.ALL)
	private List<DetalleFactura> listDetalles;

	//SET Y GET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getListDetalles() {
		return listDetalles;
	}

	public void setListDetalles(List<DetalleFactura> listDetalles) {
		this.listDetalles = listDetalles;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", stock=" + stock + ", precio=" + precio + ", listDetalles=" + listDetalles + "]";
	}
	
		


	

}
