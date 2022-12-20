package com.nttdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.persistence.Edificio;
import com.nttdata.persistence.repository.EdificioRepositoryI;

@Service
public class EdificioServiceImpl implements EdificioServiceI{

	@Autowired
	EdificioRepositoryI edificioRepository;
	
	@Override
	public boolean save(Edificio edificio) {
		
		
		edificioRepository.save(edificio);
		return false;
	}

}
