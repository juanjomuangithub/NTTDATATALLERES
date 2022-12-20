package com.nttdata.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.persistence.Pedido;
import com.nttdata.persistence.Producto;
import com.nttdata.persistence.DTO.PedidoDTO;
import com.nttdata.persistence.repository.PedidoRepositoryI;
import com.nttdata.services.PreciosServiceI;

@RestController
@RequestMapping("/api")
public class AplicationControler {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	@Qualifier("peninsula")
	private PreciosServiceI peninsula;
	
	@Autowired
	@Qualifier("fueraPeninsula")
	private PreciosServiceI fueraPeninsula;
	
	@Autowired
	private PedidoRepositoryI pedidoRepo;
	
	
	@GetMapping(value = "{ciudad}/{idPedido}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PedidoDTO> getPrecioTotal(@PathVariable String ciudad, @PathVariable int id) {
		
		Optional<Pedido> pedidoOptional = pedidoRepo.findById((long) id);
		Pedido pedido = pedidoOptional.get();
		List <Producto> productos = pedido.getProductos();
		for (int i = 0; i < productos.size(); i++) {
			if (ciudad == "peninsula") {
				productos.get(i).setPrecioPVP(peninsula.precio(productos.get(i).getPrecioSinPVP())) ;
			} else {
				productos.get(i).setPrecioPVP(fueraPeninsula.precio(productos.get(i).getPrecioSinPVP())) ;
			}
		}
		pedido.setProductos(productos);
		
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO = convertPedidoToDto(pedido);
		return new ResponseEntity<PedidoDTO>(pedidoDTO, HttpStatus.OK);
	}
	
	private PedidoDTO convertPedidoToDto(Pedido pedido) {
		PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
		return pedidoDTO;
	}
}
