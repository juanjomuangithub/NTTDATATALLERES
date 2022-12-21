package Services;

import java.util.List;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.persistence.Contrato;

/**
 * 
 * @author Juanjo Interfaz de Contrato
 */
public interface ContratoManagementServiceI {

	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param contrato
	 */
	public void insertNewContrato(final Contrato contrato);

	/**
	 * Obtiene todos los contratos.
	 * 
	 * @return List<Contrato>
	 */
	public List<Contrato> searchAll();

	/**
	 * Obtiene un contrato mediante su ID.
	 * 
	 * @param contratoId
	 */
	public Contrato searchById(final Long contratoId);

	/**
	 * Elimina un contrato.
	 * 
	 * @param contrato
	 */
	public void deleteContrato(final Contrato contrato);

	/**
	 * Actualiza un contrato existente.
	 * 
	 * @param contrato
	 */
	public void updateContrato(final Contrato contrato);

	/**
	 * Obtiene los contratos asociados a un cliente buscados por su id
	 * 
	 * @param clienteId
	 * @return List<Contrato>
	 */
	public List<Contrato> searchByIdCliente(Long clienteId);
}
