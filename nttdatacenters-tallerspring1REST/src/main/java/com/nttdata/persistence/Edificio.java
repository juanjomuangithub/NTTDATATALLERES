package com.nttdata.persistence;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Tabla de pisos del edificio
 * @author Juanjo
 *
 */

@Entity
@Table(name = "EDIFICIO")
public class Edificio implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	private Long edificioId;
	private int numeroPlanta;
	private String puerta;
	/** Inquilino asociado (FK) */
	private Inquilino inquilino;

	public Edificio(int numeroPlanta, String puerta) {
		super();
		this.numeroPlanta = numeroPlanta;
		this.puerta = puerta;
	}

	public Edificio() {
		super();
	}

	/** ID (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return edificioId;
	}

	public void setId(Long id) {
		this.edificioId = id;
	}

	@Column(name = "C_NUMERO_PLANTA")
	public int getNumeroPlanta() {
		return numeroPlanta;
	}

	public void setNumeroPlanta(int numeroPlanta) {
		this.numeroPlanta = numeroPlanta;
	}

	@Column(name = "C_PUERTA")
	public String getPuerta() {
		return puerta;
	}

	/**
	 * 
	 * @param puerta
	 */
	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "INQUILINO_ID", referencedColumnName = "INQUILINO_ID")
	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

}
