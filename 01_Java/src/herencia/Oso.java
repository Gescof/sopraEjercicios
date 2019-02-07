package herencia;

public class Oso extends Animal {

	@Override
	public void comer(Object comida) {
		if(comida instanceof Pez) {
			Pez animal = (Pez) comida;
			System.out.println("Soy el oso de nombre " 
					+ this.nombre
					+ " y me voy a comer al pez "
					+ animal.getNombre());
		} else {
			System.out.println("No me gusta.");
		}
	}

}
