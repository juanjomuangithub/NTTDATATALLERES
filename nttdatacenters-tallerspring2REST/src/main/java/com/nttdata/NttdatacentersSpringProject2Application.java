package com.nttdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.persistence.Pedido;
import com.nttdata.persistence.Producto;
import com.nttdata.persistence.repository.PedidoRepositoryI;

@SpringBootApplication
public class NttdatacentersSpringProject2Application implements CommandLineRunner {
	
	@Autowired
	PedidoRepositoryI pRepo;

	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersSpringProject2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pedido p = new Pedido();
		p.setCiudad("Madrid");
		p.setDestinatario("Unai Simon");
		p.setDireccionEntrega("Calle Mestalla 11");
		
		List <Producto> productos = new ArrayList<Producto>();
		
		Producto pr = new Producto();
		pr.setNombre("Portatil gaming Omen");
		pr.setPrecioSinPVP(1300);
		pr.setPedido(p);
		productos.add(pr);
		
		
		Producto pr1 = new Producto();
		pr1.setNombre("Raton Razer");
		pr1.setPrecioSinPVP(60);
		pr1.setPedido(p);
		productos. add(pr1);
		
		
		
		
		Producto pr2 = new Producto();
		pr2.setNombre("Ps5");
		pr2.setPrecioSinPVP(450);
		pr2.setPedido(p);
		productos.add(pr2);
		
		
		p.setProductos(productos);
		
		pRepo.save(p);
		
	}

}
