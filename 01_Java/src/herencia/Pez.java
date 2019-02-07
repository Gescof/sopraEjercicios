package herencia;

public abstract class Pez extends Animal {
	protected int numAletas;
	
	public Pez() {
		super();
	}
	
	public Pez(int id, String nombre, int edad, TipoAlimentacion tipoAlim) {
		super(id, nombre, edad, tipoAlim);
	}

	@Override
	public void comer(Object comida) {
		if(comida instanceof Plancton) {
			System.out.println("Soy un pez de tipo " 
								+ this.getClass().getSimpleName() 
								+ ", mi nombre es " + this.nombre
								+ " y me voy a comer el plancton.");
		} else {
			System.out.println("Soy un pez y solo como plancton.");
		}
	}

	public int getNumAletas() {
		return numAletas;
	}

	public void setNumAletas(int numAletas) {
		this.numAletas = numAletas;
	}
	
}
