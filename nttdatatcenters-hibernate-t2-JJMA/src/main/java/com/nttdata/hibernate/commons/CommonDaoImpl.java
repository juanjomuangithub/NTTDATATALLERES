package com.nttdata.hibernate.commons;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.AbstractEntity;

/**
 * 
 * @author Juanjo
 *
 *         Implementacion del DAO generico
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Sesión de conexión a BD */
	private Session session;

	/** Tipo de clase */
	private Class<T> entityClass;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(final T paramT) {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		session.save(paramT);
		session.flush();

		session.getTransaction().commit();
	};

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		return list;

	};

	@Override
	public T searchById(final Long id) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por PK.
		T result = session.get(this.entityClass, id);

		return result;
	};

	@Override
	public void delete(final T paramT) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void update(final T paramT) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
