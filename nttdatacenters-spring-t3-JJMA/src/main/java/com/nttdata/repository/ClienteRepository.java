package com.nttdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 * 
 * @author Juanjo
 * 
 * Repositorio de cliente
 *
 */

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	/**
	 * Busqueda de cliente por nombre y apellidos
	 * 
	 * @param nombre
	 * @param primerApellido
	 * @param segundoApellido
	 * @return
	 */
	public List<Cliente> findByNombreAndPrimerApellidoAndSegundoApellido(
			final String nombre, final String primerApellido, final String segundoApellido);
	
}
