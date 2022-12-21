package Services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.dao.impl.ClienteDaoImpl;
import com.nttdata.hibernate.daoi.ClienteDaoI;
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

		if (cliente != null && cliente.getClienteId() == null) {

			clienteDao.insert(cliente);
		}

	}

	@Override
	public List<Cliente> searchAll() {
		List<Cliente> clientesList = new ArrayList<>();

		clientesList = clienteDao.searchAll();

		return clientesList;
	}

	@Override
	public Cliente searchById(Long clienteId) {

		Cliente cliente = null;

		if (clienteId != null) {

			cliente = clienteDao.searchById(clienteId);
		}

		return cliente;

	}

	@Override
	public void deleteCliente(Cliente cliente) {

		if (cliente != null && cliente.getClienteId() != null) {

			clienteDao.delete(cliente);
		}

	}

	@Override
	public void updateCliente(Cliente cliente) {

		if (cliente != null && cliente.getClienteId() == null) {

			clienteDao.update(cliente);
		}

	}

	@Override
	public Cliente searchByNombreAndApellidos(String nombre, String primerApellido, String segundoApellido) {

		Cliente cliente = new Cliente();

		cliente = clienteDao.searchByNombreAndApellidos(nombre, primerApellido, segundoApellido);

		return cliente;
	}

}
