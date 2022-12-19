package com.nttdata.persistence;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "INQUILINO")
public class Inquilino implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	private Long inquilinoId;
	private String nombre;
	private String apellidos;
	private Edificio edificio;

	public Inquilino(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Inquilino() {
		super();
	}

	/** ID (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INQUILINO_ID")
	public Long getId() {
		return inquilinoId;
	}

	public void setId(Long id) {
		this.inquilinoId = id;
	}

	@Column(name = "C_NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "C_APELLIDOS")
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "inquilino")
	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}
	
	
	
	//@OneToOne(mappedBy = inquilino, fetch = FetchType.EAGER cascade = CascadeType.All)
	//private Edificio edificio;

}
