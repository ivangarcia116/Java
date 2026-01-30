import java.util.Scanner;

/**
 * Clase Test para detectar palabras prohibidas que pueda introducir el usuario.
 */

public class Test {
	
    /**
     * Lista de palabras prohibidas que no se puede introducir.
     */
	
    static String tpalabros[] = {"caca", "culo", "pedo", "pis"};

    /**
     * Método principal que ejecuta el programa.
     * Permite al usuario introducir mensajes y verifica que no contengan palabras prohibidas.
     * @param argv Argumentos de línea de comandos (no utilizados).
     */
    
    public static void main(String argv[]) {
    	
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce tus mensajes, o pulsa . para terminar:");
        
        boolean fin = false;
        
        do {
        	
            try {
            	
                String mensaje = leerLineaOK(sc);
                
                if (mensaje.equals(".")) {
                	
                    System.out.println("Fin de programa");
                    fin = true;     
                    
                } 
                
                else {
                	
                    System.out.println("OK");
                }
                
            }
            
            catch (BurradasNOException e) {
                System.out.println(e.getMessage());
            }
            
        } 
        
        while (!fin);
    }

    /**
     * Lee una línea de texto desde el scanner y verifica si contiene palabras prohibidas.
     * Si se encuentra una palabra prohibida, lanza la excepción {@link BurradasNOException}.
     * @param Scanner utilizado para leer la entrada del usuario.
     * @return Devuelve la línea de texto si no contiene las palabras prohibidas.
     * @throws BurradasNOException salta la excepción si hay alguna palabra prohibida.
     */
    
    public static String leerLineaOK(Scanner sc) throws BurradasNOException {
    	
        String cadena = sc.nextLine();
        
        for (String palabra : tpalabros) {
            if (cadena.toLowerCase().contains(palabra)) {
                throw new BurradasNOException(""+palabra); 
            }
        }
        
        return cadena;
    }
}
