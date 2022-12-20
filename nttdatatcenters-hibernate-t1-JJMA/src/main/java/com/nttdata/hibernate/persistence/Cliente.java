package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Juanjo ENTIDAD DE TABLA T_CLIENTE
 */

@Entity
@Table(name = "T_CLIENTE")
public class Cliente extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long clienteId;

	/** nombre del cliente */
	private String nombre;

	/** Primer apellido del cliente */
	private String primerApellido;

	/** Segundo apellido del cliente */
	private String segundoApellido;

	/** DNI del cliente */
	private String dni;

	/**
	 * 
	 * @return clienteId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_CLIENTE_ID")
	public Long getClienteId() {
		return clienteId;
	}

	/**
	 * 
	 * @param clienteId. The clienteId to set
	 */
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	/**
	 * 
	 * @return nombre
	 */
	@Column(name = "C_NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre. The nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return primerApellido
	 */
	@Column(name = "C_PRIMER_APELLIDO", nullable = false)
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * 
	 * @param primerApellido. The primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * 
	 * @return segundoApellido
	 */
	@Column(name = "C_SEGUNDO_APELLIDO", nullable = false)
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * 
	 * @param segundoApellido. The segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * 
	 * @return dni
	 */
	@Column(name = "C_DNI", nullable = false, unique = true)
	public String getDni() {
		return dni;
	}

	/**
	 * 
	 * @param dni. The dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public Long getId() {
		return this.clienteId;
	}

	@Override
	public void setId(Long id) {
		this.clienteId = id;
	}

	@Override
	public String toString() {
		return "Cliente [clienteId=" + clienteId + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", dni=" + dni + "]";
	}
	
	

}
