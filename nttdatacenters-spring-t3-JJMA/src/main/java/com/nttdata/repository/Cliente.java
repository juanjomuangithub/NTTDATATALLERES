package com.nttdata.repository;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author Juanjo
 * 
 * Tabla Cliente
 *
 */
@Entity
@Table(name="T_CLIENTE")
public class Cliente implements Serializable{
	
	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long id;

	/** Nombre del cliente */
	private String nombre;

	/** Primer apellido */
	private String primerApellido;

	/** Segundo apellido */
	private String segundoApellido;

	/** Documento de identidad */
	private String DNI;
	
	/** Fecha de nacimiento */
	//private Calendar fechaNacimiento;
	private Date fechaNacimiento;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_CLIENTE_ID")
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id. The id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
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
	 * @return primerApellido
	 */
	@Column(name = "C_PRIMER_APELLIDO", nullable = false)
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * 
	 * @param primerApellido. primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * @return segundoApellido
	 */
	@Column(name = "C_SEGUNDO_APELLIDO", nullable = false)
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * 
	 * @param segundoApellido. Segundo apellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * @return DNI
	 */
	@Column(name = "C_DNI", nullable = false, unique = true)
	public String getDNI() {
		return DNI;
	}

	/**
	 * 
	 * @param dNI. The DNI to set
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	/**
	 * 
	 * @return fechaNacimiento
	 */
	@Column(name = "C_FECHA_NACIMIENTO", nullable = false)
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * 
	 * @param fechaNacimiento. The fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Cliente [id: " + id + ", nombre: " + nombre + ", primer apellido: " + primerApellido + ", segundo apellido: "
				+ segundoApellido + ", DNI: " + DNI + ", fecha nacimiento: " + fechaNacimiento + "]";
	}
	
	
}
