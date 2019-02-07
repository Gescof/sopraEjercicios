package modelo.entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Pelicula {
	private int id;
	private String titulo;
	private String genero;
	
	// Con Autowired, se busca por defecto byType
	// @Autowired
	// Para cambiarlo, se usa la etiqueta Qualifier
	@Qualifier("directorBean")
	private Director director;
	
	public Pelicula() {}
	
	public Pelicula(int id, String titulo, String genero, Director director) {
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.director = director;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", director=" + director + "]";
	}
	
}
