package ejemplo0;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		/*
		String opcion = args[0];
		Imprimible imp = new FactoriaImprimibles().crear(opcion);
		imp.imprimir("lo que sea");
		*/
		
		// Forma más sencilla. En argumentos hay que especificar la ruta de la clase.
		Imprimible imp = (Imprimible) Class.forName(args[0]).newInstance();
		imp.imprimir("lo que sea");
	}

}
