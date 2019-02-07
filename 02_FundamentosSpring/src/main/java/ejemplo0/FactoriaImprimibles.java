package ejemplo0;

public class FactoriaImprimibles {
	public Imprimible crear(String imprimible) {
		switch (imprimible) {
		case "0":
			return new ImprimirFichero();
		case "1":
			return new ImprimirPantalla();
		default:
			return null;
		}
	}
}
