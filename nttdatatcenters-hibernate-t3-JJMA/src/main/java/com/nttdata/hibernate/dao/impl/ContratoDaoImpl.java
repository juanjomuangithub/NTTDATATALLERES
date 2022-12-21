package com.nttdata.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.commons.CommonDaoImpl;
import com.nttdata.hibernate.daoi.ClienteDaoI;
import com.nttdata.hibernate.daoi.ContratoDaoI;
import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.persistence.Contrato;

/**
 * Implementacion del DAO de la tabla contrato
 * 
 * @author Juanjo
 *
 */
public class ContratoDaoImpl extends CommonDaoImpl<Contrato> implements ContratoDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	private ClienteDaoI clienteDao;

	/**
	 * Método constructor
	 */
	public ContratoDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contrato> searchByIdCliente(Long clienteId) {
		Cliente cliente = new Cliente();
		cliente = clienteDao.searchById(clienteId);

		final List<Contrato> contratosList = session.createQuery("FROM Contrato WHERE cliente=" + cliente).list();
		return contratosList;
	}

}
