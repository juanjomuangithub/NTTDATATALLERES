package com.nttdata;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.repository.Cliente;
import com.nttdata.services.ClienteManagementServiceI;

/**
 * Clase principal
 * 
 * @author Juanjo
 *
 */

@SpringBootApplication
public class NttdatacentersSpringT3JjmaApplication implements CommandLineRunner{
	
	@Autowired
	ClienteManagementServiceI clienteServiceI;
	

	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersSpringT3JjmaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Calendar c_date1 = Calendar.getInstance();
		c_date1.set(1982, 5, 5);
		Calendar c_date2 = Calendar.getInstance();
		c_date2.set(2004, 2, 19);
		Calendar c_date3 = Calendar.getInstance();
		c_date3.set(1995, 12, 27);
		
		DateFormat formateador= new SimpleDateFormat("dd/M/yy");
		Date fecha1 = formateador.parse("05/05/1982");
		Date fecha2 = formateador.parse("19/02/2004");
		Date fecha3 = formateador.parse("27/12/1995");

		final Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNombre("Henry");
		cliente1.setPrimerApellido("Dalgliesh");
		cliente1.setSegundoApellido("Cavill");
		cliente1.setDNI("28999666A");
		cliente1.setFechaNacimiento(fecha1);
		clienteServiceI.saveCliente(cliente1);

		final Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNombre("Millie");
		cliente2.setPrimerApellido("Bobby");
		cliente2.setSegundoApellido("Brown");
		cliente2.setDNI("2824355A");
		cliente2.setFechaNacimiento(fecha2);
		clienteServiceI.saveCliente(cliente2);

		final Cliente cliente3 = new Cliente();
		cliente3.setId(3L);
		cliente3.setNombre("Timothee");
		cliente3.setPrimerApellido("Hal");
		cliente3.setSegundoApellido("Chalamet");
		cliente3.setDNI("221346A");
		cliente3.setFechaNacimiento(fecha3);
		clienteServiceI.saveCliente(cliente3);

		System.out.println("***** Lista de clientes:");

		clienteServiceI.searchAll();

		cliente3.setDNI("1111111111B");
		clienteServiceI.updateCliente(cliente3);

		System.out.println("******Busqueda de cliente por nombre y apellidos:");
		
		clienteServiceI.searchByFullName("Timothee", "Hal", "Chalamet");
		
		
		
		System.out.println("***** Lista de clientes:");

		clienteServiceI.searchAll();
		
	}

}
