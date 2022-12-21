package com.nttdata.hibernate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.persistence.Contrato;

import Services.ClienteManagementServiceI;
import Services.ClienteManagementServiceImpl;
import Services.ContratoManagementServiceI;
import Services.ContratoManagementServiceImpl;

/**
 * 
 * @author Juanjo Clase principal
 *
 */
public class App {
	public static void main(String[] args) {

		final Session session = Utils.getSessionFactory().openSession();

		final ClienteManagementServiceI clienteService = new ClienteManagementServiceImpl(session);
		final ContratoManagementServiceI contratoService = new ContratoManagementServiceImpl(session);

		final String updatedUser = "ADMINISTRADOR";
		final Date updatedDate = new Date();
		Calendar c_date1 = Calendar.getInstance();
		c_date1.set(2023, 2, 7);
		Calendar c_date2 = Calendar.getInstance();
		c_date2.set(2024, 4, 9);
		Calendar c_date3 = Calendar.getInstance();
		c_date3.set(2025, 1, 1);
		
		Calendar v_date1 = Calendar.getInstance();
		c_date1.set(2020, 2, 7);
		Calendar v_date2 = Calendar.getInstance();
		c_date2.set(2021, 4, 9);
		Calendar v_date3 = Calendar.getInstance();
		c_date3.set(2019, 1, 1);
		
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
		
		Contrato contrato =new Contrato();
		contrato.setFechaVigencia(v_date1);
		contrato.setFechaCaducidad(c_date1);
		contrato.setPrecioMensual(400);
		contrato.setCliente(cliente);
		contrato.setUpdatedDate(updatedDate);
		contrato.setUpdatedUser(updatedUser);
		
		Contrato contrato1 =new Contrato();
		contrato1.setFechaVigencia(v_date2);
		contrato1.setFechaCaducidad(c_date2);
		contrato1.setPrecioMensual(400);
		contrato1.setCliente(cliente);
		contrato1.setUpdatedDate(updatedDate);
		contrato1.setUpdatedUser(updatedUser);
		
		Contrato contrato2 =new Contrato();
		contrato2.setFechaVigencia(v_date3);
		contrato2.setFechaCaducidad(c_date3);
		contrato2.setPrecioMensual(400);
		contrato2.setCliente(cliente);
		contrato2.setUpdatedDate(updatedDate);
		contrato2.setUpdatedUser(updatedUser);
		
		contratoService.insertNewContrato(contrato);
		contratoService.insertNewContrato(contrato1);
		contratoService.insertNewContrato(contrato2);
		
		List<Contrato> contratos = contratoService.searchAll();
		for (final Contrato contratoA : contratos) {
			System.out.println("Id de contrato: "+ contratoA.getId() + ". Fecha de caducidad: " + contratoA.getFechaCaducidad() + 
					". Fecha vigencia:  " + contratoA.getFechaVigencia() + ". Precio mensual:  "
					+ contratoA.getPrecioMensual() + ". Cliente: " + contratoA.getCliente());
		}
	}
}
