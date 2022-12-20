package com.nttdata.persistence;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Tabla de productos
 * 
 * @author
 *
 */

@Entity
@Table(name = "T_PRODUCTO")
public class Producto implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** ID */
	private Long productoId;

	/** Nombre del pedido */
	private String nombre;

	/** Precio del pedido con impuestos */
	private double precioPVP;

	/** Precio del pedido sin impuestos */
	private double precioSinPVP;

	private Pedido pedido;

	/** @return personId */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_PK_PRODUCTO_ID")
	public Long getProductoId() {
		return productoId;
	}

	/**
	 * 
	 * @param productoId Establece el productoId
	 */
	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	/**
	 * 
	 * @return nombre
	 */
	@Column(name = "C_NOMBRE")
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre. Establece el nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return precioPVP
	 */
	@Column(name = "C_PRECIO_PVP")
	public double getPrecioPVP() {
		return precioPVP;
	}

	/**
	 * 
	 * @param precioPVP. Establece el precio con impuestos
	 */
	public void setPrecioPVP(double precioPVP) {
		this.precioPVP = precioPVP;
	}

	/**
	 * 
	 * @return PrecioSinPVP
	 */
	@Column(name = "C_PRECIO_SIN_PVP", nullable = false)
	public double getPrecioSinPVP() {
		return precioSinPVP;
	}

	/**
	 * 
	 * @param precioSinPVP. Establece el precio sin impuestos
	 */
	public void setPrecioSinPVP(double precioSinPVP) {
		this.precioSinPVP = precioSinPVP;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_FK_PEDIDO_ID", referencedColumnName = "C_PK_PEDIDO_ID")
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}
