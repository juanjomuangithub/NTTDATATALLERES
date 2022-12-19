package com.nttdata.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.persistence.Inquilino;

@Repository
public interface InquilinoRepositoryI extends JpaRepository<Inquilino, Long> {

	
	public Inquilino findByNombreAndApellidos(String nombre, String apellidos);
	
	
}
