package modelo.entidades;

public class Pelicula {
	private int id;
	private String titulo;
	private String genero;
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
