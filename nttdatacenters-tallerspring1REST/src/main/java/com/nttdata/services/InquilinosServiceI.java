package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Inquilino;

public interface InquilinosServiceI {

	public Inquilino findByNombreAndApellidos(String nombre, String apellidos);
	public boolean save(Inquilino inquilino);
	public List<Inquilino> getAllInquilinos();
}
