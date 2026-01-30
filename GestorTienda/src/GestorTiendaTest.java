import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GestorTiendaTest {

	@Test
	void testCalcularDescuento() {

		GestorTienda gestor = new GestorTienda();
		
		assertEquals(10.0, gestor.calcularDescuento(100.0, 10), 0.01);
		assertEquals(5.0, gestor.calcularDescuento(100.0, 5), 0.01);
		assertEquals(0.0, gestor.calcularDescuento(100.0, 4), 0.01);
	}
	
	@Test
	void testCategorizarProducto() {
		
		GestorTienda gestor = new GestorTienda();
		
		assertEquals("Económico", gestor.categorizarProducto(9.99));
		assertEquals("Estándar", gestor.categorizarProducto(29.99));
		assertEquals("Premium", gestor.categorizarProducto(89.99));
		
	}
	
	@Test
	void testBuscarProducto() {
		
		GestorTienda gestor = new GestorTienda();
		
		String[] inventario = {"Piña", "Uva", "Pera"};
		
		assertEquals("Piña", gestor.buscarProducto(inventario, "Piña"));
		assertEquals("Uva", gestor.buscarProducto(inventario, "Uva"));
		assertEquals("Pera", gestor.buscarProducto(inventario, "Pera"));
		assertNull( gestor.buscarProducto(inventario, null));
		
	}
}
