package com.nttdata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.repository.Cliente;
import com.nttdata.repository.ClienteRepository;

/**
 * 
 * @author Juanjo
 * 
 *         Implementacion del servico de clientes
 *
 */

@Service
public class ClienteManagementServiceImpl implements ClienteManagementServiceI {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public boolean insertCliente(Cliente newCliente) {

		if (newCliente != null && newCliente.getId() == null) {
			newCliente = clienteRepository.save(newCliente);
		}
		return true;
	}

	@Override
	public void searchAll() {

		List<Cliente> clientesList = clienteRepository.findAll();
		clientesList.forEach((Cliente cliente) -> System.out.println(cliente.toString()));

	}

	@Override
	public void searchByFullName(String nombre, String primerApellido, String segundoApellido) {

		List<Cliente> clientesList = clienteRepository.findByNombreAndPrimerApellidoAndSegundoApellido(nombre,
				primerApellido, segundoApellido);
		clientesList.forEach((Cliente cliente) -> System.out.println(cliente.toString()));
	}

	@Override
	public void deleteCliente(Cliente cliente) {

		if (cliente != null && cliente.getId() != null) {
			clienteRepository.delete(cliente);
		}

	}

	@Override
	public void searchByName(String nombre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCliente(Cliente cliente) {
		if (cliente != null && cliente.getId() != null) {
			Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getId());
			Cliente clienteToUpdate = clienteOptional.get();
			clienteToUpdate.setNombre(cliente.getNombre());
			clienteToUpdate.setPrimerApellido(cliente.getPrimerApellido());
			clienteToUpdate.setSegundoApellido(cliente.getSegundoApellido());
			clienteToUpdate.setDNI(cliente.getDNI());
			clienteToUpdate.setFechaNacimiento(cliente.getFechaNacimiento());

			clienteRepository.save(clienteToUpdate);
		}

	}

	@Override
	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);

	}

}
