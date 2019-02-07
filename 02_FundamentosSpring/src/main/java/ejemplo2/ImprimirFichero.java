package ejemplo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ImprimirFichero implements Imprimible {
	
	public void imprimir(String cadena) {
		File fichero = new File("fichero.txt");
		// Antigua manera de usar el PrintWriter: try + catch + finally
//		PrintWriter pw = new PrintWriter(fichero);
		
		// Nueva manera de usar el PrintWriter
		try (PrintWriter pw = new PrintWriter(fichero)) {
			pw.print(cadena);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
