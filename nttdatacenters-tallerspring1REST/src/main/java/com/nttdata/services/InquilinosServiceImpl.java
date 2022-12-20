package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.persistence.Inquilino;
import com.nttdata.persistence.repository.InquilinoRepositoryI;

@Service
public class InquilinosServiceImpl implements InquilinosServiceI{
	
	@Autowired
	InquilinoRepositoryI inquilinoRepositoryI;

	@Override
	public Inquilino findByNombreAndApellidos(String nombre, String apellidos) {
		Inquilino inquilino = new Inquilino();
		inquilino = inquilinoRepositoryI.findByNombreAndApellidos(nombre, apellidos);
		return inquilino;
	}

	@Override
	public boolean save(Inquilino inquilino) {
		
		if (inquilino != null && inquilino.getId() == null) {
			
			inquilinoRepositoryI.save(inquilino);
		}
		
		inquilinoRepositoryI.save(inquilino);
		return true;
	}

	@Override
	public List<Inquilino> getAllInquilinos() {
		
		return inquilinoRepositoryI.findAll();
	}

	

}
