package com.nttdata.services;

import com.nttdata.repository.Cliente;

/**
 * 
 * @author Juanjo
 * 
 * Sevicio de gestion de clientes
 *
 */
public interface ClienteManagementServiceI {

	/**
	 * Añade un nuevo cliente.
	 * @param newCliente
	 * @return Cliente
	 */
	public boolean insertCliente(final Cliente newCliente);

	/**
	 * Consulta todos los clientes.
	 */
	public void searchAll();

	/**
	 * Busqueda por nombre y apellidos
	 * @param nombre
	 * @param primerApellido
	 * @param segundoApellido
	 */
	public void searchByFullName(final String nombre, final String primerApellido, final String segundoApellido);

	/**
	 * Busqueda por nombre
	 * @param nombre
	 */
	public void searchByName(final String nombre);
	
	/**
	 * Borrar cliente
	 * @param cliente
	 */
	public void deleteCliente(Cliente cliente);
	
	/**
	 * Actualizar cliente
	 * @param cliente
	 */
	public void updateCliente(Cliente cliente);
	
	/**
	 * 
	 * @param cliente
	 */
	public void saveCliente(Cliente cliente);

	
}
