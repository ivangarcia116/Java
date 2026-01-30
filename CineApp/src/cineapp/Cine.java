package cineapp;

import java.util.Random;

public class Cine {

	private Pelicula pelicula;
	private float precio;
	private int nespectadores;
	private Espectador tespectadores[][];
	
	public Cine (int filas, int columnas, Pelicula pelicula, float precio) {
		
		super();
		this.pelicula = pelicula;
		this.precio = precio;
		this.nespectadores = 0;
		tespectadores = new Espectador [filas][columnas];
	}	
	
	public String venderAsiento(Espectador esp) {
		
		if ( precio > esp.getDinero()) {
			
			return esp.getNombre() + " No tiene dinero suficiente";	
		}
		
		if (esp.getEdad() < pelicula.getEdadMinima()) {
			
			return esp.getNombre() + " No tiene edad suficiente";
 			
		}
		
		if (nespectadores == (tespectadores.length * tespectadores[0].length)) {
			
			return "La sala esta llena";
			
		}
		
		Random rd = new Random();
		
		int fila = rd.nextInt(0, tespectadores.length);
		int columna = rd.nextInt(0, tespectadores[0].length);
		
		while (tespectadores[fila][columna] != null) {
			
			fila = rd.nextInt(0, tespectadores.length);
			columna = rd.nextInt(0, tespectadores[0].length);
		}
		
		tespectadores[fila][columna] = esp;
		
		esp.setDinero(esp.getDinero() - precio);
		
		nespectadores++;
		
		String resu = "Fila " +((fila +1)+ " Asiento " + (char) 'A' +columna);
		
		return resu;
	}

	public void informeSala() {
				
		int totalPlazas = tespectadores.length * tespectadores[0].length;
		float recaudacion = nespectadores * precio;
		int ocupacion = (nespectadores * 100) / totalPlazas;
		
		System.out.println("------------------------");
		System.out.println("Pelicula: " +pelicula.getTitulo());
		System.out.println("Nº de Espectadores: " +nespectadores);
		System.out.println("Nº de Plazas: " +totalPlazas);
		System.out.println("Ocupación: " +ocupacion );
		System.out.println("Recaudación: " +recaudacion + "€");
		System.out.println("------------------------");
	}

	public void listadoEspectadores() {
				
		System.out.println("Lista de Espectadores");
		System.out.println("------------------------");
		System.out.println("Nombre  Asiento");
		
		for (int i = 0; i < tespectadores.length; i++) {
			
			for (int j = 0; j < tespectadores[i].length; j++) {
				
				if (tespectadores[i][j] != null) {
					
					System.out.println(tespectadores[i][j].getNombre() + "\t" +(i + 1) + (char)('A' + j));
					
				}
				
			}
			
		}
		
	}

	public void listadoAsientos() {
				
		for (int i = 0; i < tespectadores.length; i++) {
			
			for (int j = 0; j < tespectadores[i].length; j++) {
				
				if (tespectadores[i][j] != null) {
					
					System.out.print(" X");
					
				}
				
				else {
					
					System.out.print("  ");
					
				}
			}
			
			System.out.println();
			
		}
		
		
		
	}
}
