package cineapp;

public class Pelicula {

	private String titulo;
	private int duracion;
	private int edad_minima;
	private Genero genero;	
	
	public Pelicula(String titulo, int duracion, int edad_minima, Genero AVENTURAS) {
		
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.edad_minima = edad_minima;
		this.genero = AVENTURAS;
	}

	public int getEdadMinima() {
		return edad_minima;
	}

	public void setEdad_minima(int edad_minima) {
		this.edad_minima = edad_minima;
	}
	
	public String getTitulo() {
		
		return titulo;
	}
	
	
	
}
