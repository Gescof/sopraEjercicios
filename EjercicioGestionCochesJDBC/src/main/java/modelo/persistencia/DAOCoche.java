package modelo.persistencia;

import java.util.List;

import modelo.entidades.Coche;

public interface DAOCoche {

	public boolean insertar(Coche coche);
	
	public Coche buscar(Integer id);
	
	public List<Coche> getListaCoches();
	
	public boolean borrar(Coche coche);
	
	public boolean modificar(Coche coche);

}
