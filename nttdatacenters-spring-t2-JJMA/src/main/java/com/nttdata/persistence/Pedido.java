package com.nttdata.persistence;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_PEDIDO")
public class Pedido implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** ID */
	private Long pedidoId;

	/** Destinatario del pedido */
	private String destinatario;

	/** Direccion de entrega */
	private String direccionEntrega;

	/** Ciudad de la entrega */
	private String ciudad;

	private List<Producto> productos;

	/** @return personId */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_PK_PEDIDO_ID")
	public Long getPedidoId() {
		return pedidoId;
	}

	/**
	 * 
	 * @param pedidoId. Establece el Id del pedido
	 */
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	/**
	 * 
	 * @param productos. Establece los productos
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	/**
	 * 
	 * @return destinatario
	 */
	@Column(name = "C_DESTINATARIO", nullable = false)
	public String getDestinatario() {
		return destinatario;
	}

	/**
	 * 
	 * @param destinatario. Establece el destinatario
	 */
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	/**
	 * 
	 * @return direccionEntrega
	 */
	@Column(name = "C_DIRECCION", nullable = false)
	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	/**
	 * 
	 * @param direccionEntrega. Establece la direccion de entrega
	 */
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	/**
	 * 
	 * @return ciudad
	 */
	@Column(name = "C_CIUDAD", nullable = false)
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * 
	 * @param ciudad. Establece la ciudad de entrega
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pedido")
	public List<Producto> getProductos() {
		return productos;
	}
}
