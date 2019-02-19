package modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.entidades.Operacion;

public interface DAOOperacionesJpaData extends JpaRepository<Operacion, Integer> {
	
	List<Operacion> findByTipoOperacion(String tipoOperacion);
	
}
