package herencia;

public class Tiburon extends Pez {

	@Override
	public void comer(Object comida) {
		if(comida instanceof Animal) {
			Animal animal = (Animal) comida;
			System.out.println("Soy el tiburon de nombre " 
					+ this.nombre
					+ " y me voy a comer al animal "
					+ animal.getNombre());
		} else {
			System.out.println("No me gusta.");
		}
	}
	
}
