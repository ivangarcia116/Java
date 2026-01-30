
public class PilaTest {

	public static void main(String[] args) {
	
		System.out.println(" A) Test Pila lista encadenada ");
		PilaInterfaz<String> pilat = new PilaLista<String>();
		pilat.push("Hola");
		pilat.push("Luis");
		pilat.push("Adios");
		System.out.println(" Primer elemento "+pilat.peek());
		pilat.pop();
		System.out.println(" Tamaño: "+ pilat.size()+ ":"+ pilat);
		
		
		
		System.out.println(" B) Test Pila con Array ");
		PilaInterfaz<String> pilal = new PilaArray<String>();
		pilal.push("Hola");
		pilal.push("Luis");
		pilal.push("Adios");
		System.out.println(" Primer elemento "+pilal.peek());
		pilal.pop();
		System.out.println(" Tamaño: "+ pilal.size()+ ":"+ pilal);
		
	}
}
