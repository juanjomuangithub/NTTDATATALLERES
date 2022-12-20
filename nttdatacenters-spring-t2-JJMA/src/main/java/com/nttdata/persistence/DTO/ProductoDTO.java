package com.nttdata.persistence.DTO;

import com.nttdata.persistence.Pedido;

public class ProductoDTO {

	/** ID */
	private Long productoId;

	/** Nombre del pedido */
	private String nombre;

	/** Precio del pedido con impuestos */
	private double precioPVP;

	/** Precio del pedido sin impuestos */
	private double precioSinPVP;

	private Pedido pedido;

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioPVP() {
		return precioPVP;
	}

	public void setPrecioPVP(double precioPVP) {
		this.precioPVP = precioPVP;
	}

	public double getPrecioSinPVP() {
		return precioSinPVP;
	}

	public void setPrecioSinPVP(double precioSinPVP) {
		this.precioSinPVP = precioSinPVP;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}
