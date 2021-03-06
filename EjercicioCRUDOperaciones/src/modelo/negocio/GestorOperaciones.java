package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidades.Operacion;
import modelo.persistencia.DAOOperacionesJpaData;

@Service
public class GestorOperaciones {
	
	@Autowired
	private DAOOperacionesJpaData daoOperaciones;
	
	@Transactional
	public void insertarOperacion(Operacion operacion) throws Exception {
		switch (operacion.getTipoOperacion()) {
		case "suma":
			operacion.setResultado(operacion.getOperando1() + operacion.getOperando2());
			break;
		case "resta":
			operacion.setResultado(operacion.getOperando1() - operacion.getOperando2());
			break;
		case "producto":
			operacion.setResultado(operacion.getOperando1() * operacion.getOperando2());
			break;
		case "division":
			operacion.setResultado(operacion.getOperando1() / operacion.getOperando2());
			break;
		default:
			throw new Exception("Tipo de operacion no valida");
		}
		daoOperaciones.save(operacion);
	}
	
	public List<Operacion> getListaOperaciones() {
		return daoOperaciones.findAll();
	}
	
	public List<Operacion> getListaOperacionesPorTipo(String tipoOperacion) {
		return daoOperaciones.findByTipoOperacion(tipoOperacion);
	}
	
}
