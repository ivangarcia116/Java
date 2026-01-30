
public class BurradasNOException extends Exception {

	/**
	 * @param tpalabros
	 * Constructor de la Excepcion BurradasNOException, con la lista de palabras que no se pueden ingresar.
	 */
	public BurradasNOException(String tpalabros) {
		
	super("No se permite lenguaje obsceno: " +tpalabros);

	}
}
