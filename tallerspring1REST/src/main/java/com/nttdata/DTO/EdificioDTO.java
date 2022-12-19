package com.nttdata.DTO;

import com.nttdata.persistence.Inquilino;

public class EdificioDTO {

	private Long id;
	private int numeroPlanta;
	private String puerta;
	private Inquilino inquilino;

	public Long getId() {
		return id;
	}

	public int getNumeroPlanta() {
		return numeroPlanta;
	}

	public String getPuerta() {
		return puerta;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumeroPlanta(int numeroPlanta) {
		this.numeroPlanta = numeroPlanta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

}
