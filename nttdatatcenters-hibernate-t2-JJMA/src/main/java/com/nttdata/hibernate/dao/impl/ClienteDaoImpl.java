package com.nttdata.hibernate.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.hibernate.commons.CommonDaoImpl;
import com.nttdata.hibernate.daoi.ClienteDaoI;
import com.nttdata.hibernate.persistence.Cliente;

/**
 * Implementacion del DAO de la tabla cliente
 * 
 * @author Juanjo
 *
 */
public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ClienteDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Cliente searchByNombreAndApellidos(String nombre, String primerApellido, String segundoApellido) {

		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Cliente> cquery = cb.createQuery(Cliente.class);	
		final Root<Cliente> rootP = cquery.from(Cliente.class);

		// Where.
		Predicate[] predicates = new Predicate[3];
		predicates[0] = cb.equal(rootP.get("nombre"), nombre);
		predicates[1] = cb.like(rootP.get("primerApellido"), primerApellido);
		predicates[2] = cb.like(rootP.get("segundoApellido"), segundoApellido);

		// Consulta.
		cquery.select(rootP).where(predicates);

		// Ejecución de consulta.
		final Cliente cliente = (Cliente) session.createQuery(cquery).getResultList();

		return cliente;
	}

}
