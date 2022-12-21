package Services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.dao.impl.ContratoDaoImpl;
import com.nttdata.hibernate.daoi.ContratoDaoI;
import com.nttdata.hibernate.persistence.Contrato;

/**
 * 
 * @author Juanjo Implementacion del servicio de contratos
 */
public class ContratoManagementServiceImpl implements ContratoManagementServiceI {

	private ContratoDaoI contratoDao;

	public ContratoManagementServiceImpl(Session session) {
		this.contratoDao = new ContratoDaoImpl(session);
	}

	@Override
	public void insertNewContrato(Contrato contrato) {

		if (contrato != null && contrato.getContratoId() == null) {

			contratoDao.insert(contrato);
		}

	}

	@Override
	public List<Contrato> searchAll() {

		List<Contrato> contratosList = new ArrayList<>();

		contratosList = contratoDao.searchAll();

		return contratosList;
	}

	@Override
	public Contrato searchById(Long contratoId) {

		Contrato contrato = null;

		if (contratoId != null) {

			contrato = contratoDao.searchById(contratoId);
		}

		return contrato;
	}

	@Override
	public void deleteContrato(Contrato contrato) {

		if (contrato != null && contrato.getContratoId() != null) {

			contratoDao.delete(contrato);
		}

	}

	@Override
	public void updateContrato(Contrato contrato) {

		if (contrato != null && contrato.getContratoId() == null) {

			contratoDao.update(contrato);
		}

	}

	@Override
	public List<Contrato> searchByIdCliente(Long clienteId) {
		List<Contrato> contratos = new ArrayList<Contrato>();
		contratos = contratoDao.searchByIdCliente(clienteId);
		return contratos;
	}

}
