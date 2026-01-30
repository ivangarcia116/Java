
public class PilaArray<T> implements PilaInterfaz<T>{

	T [] tabla;
	
	int posicion;

	PilaArray (){
		
		posicion = 0;
		tabla = (T[]) new Object[50];
	}
	
	@Override
	public boolean push(T valor) {
		
		if (posicion < tabla.length) {
			
			tabla[posicion] = valor;
			posicion++;
			return true;
		}
		
		return false;
	}

	@Override
	public T pop() {
		
		if (posicion == 0) {
			
			return null;
		}
		
		else {
			
			posicion--;
			return tabla[posicion];
			
		}
	}

	@Override
	public T peek() {
		
		if (posicion == 0) {
			
			return null;
		}
		
		else {
			
			return tabla[posicion - 1];
			
		}
	}

	@Override
	public int size() {
		
		return posicion;
		
	}
	
	public String toString() {
		
		String resu = "Lista:";
		
		for (int i = posicion -1; i >= 0; i--) {
			
			resu += tabla[i] + ",";
			
		}
			
		return resu;
	}
}
