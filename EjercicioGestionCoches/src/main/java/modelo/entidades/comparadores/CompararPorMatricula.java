package modelo.entidades.comparadores;

import java.util.Comparator;

import modelo.entidades.Coche;

public class CompararPorMatricula implements Comparator<Coche> {

	public int compare(Coche o1, Coche o2) {
		return o1.getMatricula().compareTo(o2.getMatricula());
	}

}
