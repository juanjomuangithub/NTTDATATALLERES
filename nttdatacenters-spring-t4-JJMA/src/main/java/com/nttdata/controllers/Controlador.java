package com.nttdata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.nttdata.repository.Cliente;
import com.nttdata.services.ClienteManagementServiceI;

@Controller
public class Controlador {
	
	@Autowired
	ClienteManagementServiceI clienteService;
	
	@GetMapping("/listaclientes")
	public List<Cliente> listaclientes (Model model) {
		List<Cliente> listaclientes = clienteService.searchAll();
		model.addAttribute("listaclientes", listaclientes);
		return listaclientes;
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCliente (Model model, @PathVariable("id") Long id) {
		Cliente clienteToDelete = clienteService.searchById(id);
		clienteService.deleteCliente(clienteToDelete);
		
		List<Cliente> listaclientes = clienteService.searchAll();
		model.addAttribute("listaclientes", listaclientes);
		
		return "listaclientes";
	}
	
	@GetMapping("/nuevocliente")
	public String nuevoCliente (@ModelAttribute Cliente cliente, Model model) {
		clienteService.saveCliente(cliente);
		
		List<Cliente> listaclientes = clienteService.searchAll();
		model.addAttribute("listaclientes", listaclientes);
		return "listaclientes";
		
	}
	
	@GetMapping("/paginacliente")
	public String paginaCliente(Model model) {
		
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		
		return "nuevocliente";
	}
	
	@GetMapping("/buscarcliente")
	public String buscarCliente(Model model) {
		
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		
		return "buscarcliente";
	}
	
	@GetMapping("/busquedacliente")
	public String busquedaCliente (@ModelAttribute Cliente cliente, Model model) {
		
		
		Cliente clienteEncontrado = clienteService.searchByName(cliente.getNombre());
		model.addAttribute("clienteEncontrado", clienteEncontrado);
		return "mostrarcliente";
		
	}
	
}
