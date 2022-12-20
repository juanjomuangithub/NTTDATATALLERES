package Services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.daoi.ClienteDaoI;
import com.nttdata.hibernate.daoi.ClienteDaoImpl;
import com.nttdata.hibernate.persistence.Cliente;

/**
 * 
 * @author Juanjo Implementacion del servicio de clientes
 */
public class ClienteManagementServiceImpl implements ClienteManagementServiceI {

	private ClienteDaoI clienteDao;

	/**
	 * Método constructor
	 * 
	 * @param session
	 */
	public ClienteManagementServiceImpl(final Session session) {
		this.clienteDao = new ClienteDaoImpl(session);
	}

	@Override
	public void insertNewCliente(Cliente cliente) {
		// Verificación de nulidad e inexistencia.
		if (cliente != null && cliente.getClienteId() == null) {

			// Insercción del nuevo cliente.
			clienteDao.insert(cliente);
		}

	}

	@Override
	public List<Cliente> searchAll() {
		List<Cliente> clientesList = new ArrayList<>();

		// Obtención de clientes
		clientesList = clienteDao.searchAll();

		return clientesList;
	}

	@Override
	public Cliente searchById(Long clienteId) {
		// Resultado.
		Cliente cliente = null;

		// Verificación de nulidad.
		if (clienteId != null) {

			// Obtención del cliente por ID.
			cliente = clienteDao.searchById(clienteId);
		}

		return cliente;

	}

	@Override
	public void deleteCliente(Cliente cliente) {
		// Verificación de nulidad y existencia.
		if (cliente != null && cliente.getClienteId() != null) {

			// Eliminación del cliente.
			clienteDao.delete(cliente);
		}

	}

	@Override
	public void updateCliente(Cliente cliente) {
		// Verificación de nulidad e inexistencia.
		if (cliente != null && cliente.getClienteId() == null) {

			// Insercción del nuevo cliente.
			clienteDao.update(cliente);
		}

	}

	@Override
	public Cliente searchByNombreAndApellidos(String nombre, String primerApellido, String segundoApellido) {
		// Resultado.
		Cliente cliente = new Cliente();

		// Obtención de cliente.
		cliente = clienteDao.searchByNombreAndApellidos(nombre, primerApellido, segundoApellido);

		return cliente;
	}

}
