package com.nttdata.services;

import org.springframework.stereotype.Service;

@Service("peninsula")
public class ServicioPeninsulaImpl implements PreciosServiceI {

	@Override
	public double precio(double precio) {
		double pvp = precio*0.21;
		
		return precio + pvp;
	}

}
