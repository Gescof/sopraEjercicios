package herencia;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Animal animal = new Tiburon();
		Tiburon tiburon = (Tiburon) animal;
		tiburon.setNombre("Tiburcio");
		tiburon.setNumAletas(4);
		tiburon.setEdad(5);
		tiburon.setTipoAlim(TipoAlimentacion.CARNIVORO);
		tiburon.setId(1);
		
		Trucha trucha = new Trucha();
		trucha.setNombre("Robustina");
		trucha.setNumAletas(2);
		trucha.setEdad(1);
		trucha.setTipoAlim(TipoAlimentacion.OMNIVORO);
		trucha.setId(2);
		
		Oso oso = new Oso();
		oso.setNombre("Yogui");
		oso.setEdad(8);
		oso.setTipoAlim(TipoAlimentacion.OMNIVORO);
		oso.setId(3);
		
		List<Animal> listaAnimales = new ArrayList<>();
		listaAnimales.add(tiburon);
		listaAnimales.add(trucha);
		listaAnimales.add(oso);
		
		Animal comida = new Oso();
		
		for(Animal animAux : listaAnimales) {
			animAux.comer(comida);
		}
	}

}
