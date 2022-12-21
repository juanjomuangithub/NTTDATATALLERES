package Services;

import java.util.List;

import com.nttdata.hibernate.persistence.Cliente;

/**
 * 
 * @author Juanjo Interfaz de Cliente
 */
public interface ClienteManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param cliente
	 */
	public void insertNewCliente(final Cliente cliente);

	/**
	 * Obtiene todos los clientes.
	 * 
	 * @return List<Cliente>
	 */
	public List<Cliente> searchAll();

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param clienteId
	 */
	public Cliente searchById(final Long clienteId);

	/**
	 * Elimina un cliente.
	 * 
	 * @param cliente
	 */
	public void deleteCliente(final Cliente cliente);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param cliente
	 */
	public void updateCliente(final Cliente cliente);

	/**
	 * Obtiene el cliente que busca por nombre, primer aPellido y segundo aPellido
	 * 
	 * @param nombre
	 * @param primerApellido
	 * @param segundoApellido
	 * @return Cliente
	 */
	public Cliente searchByNombreAndApellidos(String nombre, String primerApellido, String segundoApellido);
}
