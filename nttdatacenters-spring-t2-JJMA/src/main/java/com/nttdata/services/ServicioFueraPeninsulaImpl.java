package com.nttdata.services;

import org.springframework.stereotype.Service;

@Service("fueraPeninsula")
public class ServicioFueraPeninsulaImpl implements PreciosServiceI {

	@Override
	public double precio(double precio) {
		double pvp = precio*0.04;
		return precio + pvp;
	}

}
