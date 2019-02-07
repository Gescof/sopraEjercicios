package modelo.entidades.comparadores;

import java.util.Comparator;

import modelo.entidades.Coche;

public class CompararPorMarca implements Comparator<Coche> {

	public int compare(Coche o1, Coche o2) {
		return o1.getMarca().compareTo(o2.getMarca());
	}

}
