package com.nttdata.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.DTO.InquilinoDTO;
import com.nttdata.persistence.Inquilino;
import com.nttdata.services.InquilinosServiceI;

@RestController
@RequestMapping("/api")
public class InquilinoController {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	InquilinosServiceI inquilinosServiceI;

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<InquilinoDTO> addInquilino(@RequestBody Inquilino inquilino) {

		boolean addedInquilino;

		Inquilino inquilinoExist = inquilinosServiceI.findByNombreAndApellidos(inquilino.getNombre(),
				inquilino.getApellidos());
		if (inquilinoExist == null) {
			addedInquilino = inquilinosServiceI.save(inquilino);
		} else {

			// throw new ExistException("La persona ya existe");
		}

		InquilinoDTO addedInquilinoDTO = convertInquilinoToDto(inquilino);
		return new ResponseEntity<InquilinoDTO>(addedInquilinoDTO, HttpStatus.OK);
	}
	
//	@GetMapping
//	public List<Inquilino> showAllPersons() {
//	List<Inquilino> inquilinos = inquilinosServiceI.getAllInquilinos();
//		return inquilinos; value = "/inquilinos",
//	} 
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<InquilinoDTO>> getInquilinos() {
		
		List<Inquilino> inquilinos = inquilinosServiceI.getAllInquilinos();
		//if(inquilinos.isEmpty()) {
			//throw new NotContentException("No se encuentran personas");
		//}
		
		List<InquilinoDTO> inquilinosDTO = new ArrayList<InquilinoDTO>();
		inquilinos.stream().forEach(i -> inquilinosDTO.add(convertInquilinoToDto(i)));
		
		return new ResponseEntity<List<InquilinoDTO>>(inquilinosDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/port", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InquilinoDTO> getInquilinoByNombreAndApellidos(@RequestBody Inquilino inquilino) {
		Inquilino inquilinoFound = inquilinosServiceI.findByNombreAndApellidos(inquilino.getNombre(), inquilino.getApellidos());
		
		InquilinoDTO inquilinoDTO = new InquilinoDTO();
		inquilinoDTO = convertInquilinoToDto(inquilinoFound);
		return new ResponseEntity<InquilinoDTO>(inquilinoDTO, HttpStatus.OK);
	}

	private InquilinoDTO convertInquilinoToDto(Inquilino inquilino) {
		InquilinoDTO inquilinoDTO = modelMapper.map(inquilino, InquilinoDTO.class);
		return inquilinoDTO;
	}
}
