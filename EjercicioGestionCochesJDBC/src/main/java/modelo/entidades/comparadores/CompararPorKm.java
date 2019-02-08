package modelo.entidades.comparadores;

import java.util.Comparator;

import modelo.entidades.Coche;

public class CompararPorKm implements Comparator<Coche> {

	public int compare(Coche o1, Coche o2) {
		return o1.getKilometraje() - o2.getKilometraje();
	}

}
