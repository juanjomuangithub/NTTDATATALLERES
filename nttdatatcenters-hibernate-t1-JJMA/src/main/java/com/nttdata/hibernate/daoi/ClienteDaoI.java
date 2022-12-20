package com.nttdata.hibernate.daoi;

import com.nttdata.hibernate.commons.CommonDaoI;
import com.nttdata.hibernate.persistence.Cliente;

/**
 * 
 * @author Juanjo
 * DAO de tabla cliente
 */
public interface ClienteDaoI extends CommonDaoI<Cliente> {

	/**
	 * Obtiene el cliente que busca por nombre, primer aPellido y segundo aPellido
	 * @param nombre
	 * @param primerApellido
	 * @param segundoApellido
	 * @return Cliente
	 */
	public Cliente searchByNombreAndApellidos(String nombre, String primerApellido, String segundoApellido);
}
