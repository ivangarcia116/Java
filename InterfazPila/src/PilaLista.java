public class PilaLista<T> implements PilaInterfaz<T>  {

	 // Clase Interna
	 class Nodo <T>
	 {
	     T valor;
	     Nodo siguiente;
	     
	     Nodo ( T dato, Nodo<T> sig ){
	         this.valor     = dato;
	         this.siguiente = sig;
	     }
	 }

	 Nodo<T> inicio;
	 int contador;
	 
	 //Constructor
	 public PilaLista() {
		 
		 inicio = null;
		 contador = 0;
		 
	 }
	 
	@Override
	public boolean push(T valor) {
		
		Nodo<T> nuevo = new Nodo(valor, inicio);
		inicio = nuevo;
		contador++;
		return true;
	}

	@Override
	public T pop() {
		
		if (inicio == null) {
			
			return null;
		}
		
		else {
			
			T valor = inicio.valor;
			inicio = inicio.siguiente;
			contador--;
			return valor;
		}
		
	}

	@Override
	public T peek() {
		
		if (inicio == null) {
			
			return null;
		}
		
		else {
			
			T valor = inicio.valor;
			return valor;
		}
		
	}

	@Override
	public int size() {

		return contador;
	}
	
	public String toString() {
		
		String resu = "Lista:";
		
		Nodo<T> aux = inicio;
		
		while(aux != null) {
			
			resu+= aux.valor + ",";
			aux = aux.siguiente;
		}
		
		return resu;
		
	}
	
}
