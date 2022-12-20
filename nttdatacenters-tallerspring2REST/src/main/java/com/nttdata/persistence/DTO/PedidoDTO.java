package com.nttdata.persistence.DTO;

import java.util.List;

import com.nttdata.persistence.Producto;

public class PedidoDTO {

	private Long pedidoId;

	/** Destinatario del pedido */
	private String destinatario;

	/** Direccion de entrega */
	private String direccionEntrega;

	/** Ciudad de la entrega */
	private String ciudad;

	private List<Producto> productos;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public PedidoDTO() {
		super();
	}
	
	
}
