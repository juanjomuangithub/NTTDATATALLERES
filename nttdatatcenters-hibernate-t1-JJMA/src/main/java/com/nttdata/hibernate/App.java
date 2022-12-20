package com.nttdata.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;

import Services.ClienteManagementServiceI;
import Services.ClienteManagementServiceImpl;

/**
 * 
 * @author Juanjo Clase principal
 *
 */
public class App {
	public static void main(String[] args) {

		final Session session = Utils.getSessionFactory().openSession();

		final ClienteManagementServiceI clienteService = new ClienteManagementServiceImpl(session);

		final String updatedUser = "ADMINISTRADOR";
		final Date updatedDate = new Date();

		Cliente cliente = new Cliente();
		cliente.setNombre("Juanjo");
		cliente.setPrimerApellido("Munoz");
		cliente.setSegundoApellido("Ansotegui");
		cliente.setDni("234535135h");
		cliente.setUpdatedUser(updatedUser);
		cliente.setUpdatedDate(updatedDate);

		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Francisco");
		cliente1.setPrimerApellido("Perez");
		cliente1.setSegundoApellido("Niidea");
		cliente1.setDni("34534534h");
		cliente1.setUpdatedUser(updatedUser);
		cliente1.setUpdatedDate(updatedDate);

		clienteService.insertNewCliente(cliente);
		clienteService.insertNewCliente(cliente1);

		List<Cliente> clientes = clienteService.searchAll();
		for (final Cliente clienteA : clientes) {
			System.out.println(clienteA.getNombre() + " " + clienteA.getPrimerApellido() + " "
					+ clienteA.getSegundoApellido() + ". DNI: " + clienteA.getDni());
		}

		clienteService.updateCliente(cliente1);

		Cliente clienteSearch = clienteService.searchById(1L);
		System.out.println(clienteSearch);

		clienteService.deleteCliente(clienteSearch);

		Cliente clienteSearchByName = clienteService.searchByNombreAndApellidos(cliente.getNombre(),
				cliente.getPrimerApellido(), cliente.getSegundoApellido());
		System.out.println(clienteSearchByName);
		

	}
}
