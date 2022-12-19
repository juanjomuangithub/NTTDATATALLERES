package com.nttdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.persistence.Edificio;
import com.nttdata.persistence.Inquilino;
import com.nttdata.services.EdificioServiceI;
import com.nttdata.services.InquilinosServiceI;

@SpringBootApplication
public class Tallerspring1RestApplication implements CommandLineRunner {

	@Autowired
	InquilinosServiceI inquilinosServiceI;
	
	@Autowired
	EdificioServiceI edificioServiceI;

	public static void main(String[] args) {
		SpringApplication.run(Tallerspring1RestApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		final Inquilino i = new Inquilino();
//		i.setNombre("Juanjo");
//		i.setApellidos("Munoz ansotegui");
//		
//		inquilinosServiceI.save(i);
//	}

	@Override
	public void run(String... args) throws Exception {
		

		Inquilino i = new Inquilino();
		i.setNombre("Juanjo");
		i.setApellidos("Munoz Ansotegui");

		Inquilino i1 = new Inquilino();
		i1.setNombre("Pablo");
		i1.setApellidos("Paez Gavira");

		Inquilino i2 = new Inquilino();
		i2.setNombre("Pedro");
		i2.setApellidos("Gonzalez Lopez");

		Inquilino i3 = new Inquilino();
		i3.setNombre("Alvaro");
		i3.setApellidos("Morata Martin");

		final Edificio e = new Edificio();
		e.setNumeroPlanta(1);
		e.setPuerta("A");
		e.setInquilino(i);

		final Edificio e1 = new Edificio();
		e1.setNumeroPlanta(1);
		e1.setPuerta("B");
		e1.setInquilino(i1);

		final Edificio e2 = new Edificio();
		e2.setNumeroPlanta(2);
		e2.setPuerta("A");
		e2.setInquilino(i2);
		
		final Edificio e4 = new Edificio();
		e4.setNumeroPlanta(2);
		e4.setPuerta("B");

		final Edificio e3 = new Edificio();
		e3.setNumeroPlanta(3);
		e3.setPuerta("B");
		e3.setInquilino(i3);
		
		final Edificio e5 = new Edificio();
		e5.setNumeroPlanta(3);
		e5.setPuerta("A");
		
		final Edificio e6 = new Edificio();
		e6.setNumeroPlanta(4);
		e6.setPuerta("A");
		
		final Edificio e7 = new Edificio();
		e7.setNumeroPlanta(4);
		e7.setPuerta("B");
		
		edificioServiceI.save(e);
		edificioServiceI.save(e1);
		edificioServiceI.save(e2);
		edificioServiceI.save(e3);
		edificioServiceI.save(e4);
		edificioServiceI.save(e5);
		edificioServiceI.save(e6);
		edificioServiceI.save(e7);
	}

}
