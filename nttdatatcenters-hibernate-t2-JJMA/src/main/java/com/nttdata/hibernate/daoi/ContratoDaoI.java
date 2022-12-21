package com.nttdata.hibernate.daoi;

import java.util.List;

import com.nttdata.hibernate.commons.CommonDaoI;
import com.nttdata.hibernate.persistence.Contrato;

/**
 * 
 * @author Juanjo
 * 
 *         Dao de tabla contrato
 *
 */
public interface ContratoDaoI extends CommonDaoI<Contrato> {

	/**
	 * Obtiene los contratos asociados a un cliente buscados por su id
	 * 
	 * @param clienteId
	 * @return List<Contrato>
	 */
	public List<Contrato> searchByIdCliente(Long clienteId);
}
