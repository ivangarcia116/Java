/**
 *  MiAlmacen
 *  Programa principal de gestión de un almacén de productos
 *  implementa un CRUD ( Creat, Read, Update, Delete) ofreciendo varios
 *  informes.
 */
package gestionalmacen01.principal;

import java.util.Scanner;

import gestionalmacen01.modelo.ModeloInterfaz;
import gestionalmacen01.modelo.ModeloArrayList;
import gestionalmacen01.modelo.ModeloHashMap;
import gestionalmacen01.modelo.Producto;

//Completar los métodos
public class MiAlmacen {
    // Defino como estaticas para que puedan usarse 
    // dentro de la clase sin necesidad de pasarlas como 
    // parametros.
    static private ModeloInterfaz almacen;
    static private Scanner sc;
    
    public static void main(String[] args) {
    	
        almacen = new ModeloHashMap();
        sc = new Scanner(System.in);
        int opcion = 0;
        
        do {
        	
		mostrarMenu();
		
        opcion = leerOpcion(1,9);
        
                switch (opcion) {
                
                    case 1: crear();break;
                    case 2: consultar();break;
                    case 3: borrar();break;
                    case 4: modificarPrecio();break;
                    case 5: comprar();break;
                    case 6: vender();break;
                    case 7: listar();break;
                    case 8: listarPocoStock();break;
                }
                
                System.out.println("\n---------------------------- ");
                System.out.print("Pulse enter para continuar");
                sc.nextLine();       
        }
        
        while(opcion!=9);
        sc.close();
        
    }
    
    
    private static void mostrarMenu() {
    	
        System.out.println("\n\n    MENU");
        System.out.println("1. Nuevo producto ");
        System.out.println("2. Consulta producto ");
        System.out.println("3. Borrar producto ");
        System.out.println("4. Modificar precio ");
        System.out.println("5. Compra de productos ");
        System.out.println("6. Venta de productos ");
        System.out.println("7. Listado completo de productos ");
        System.out.println("8. Listado de productos con stock inferior al mínimo");
        System.out.println("9. Terminar ");
        System.out.print("Elige una opción (1-9): ");        
    }
    
    // Lee un entero del System.in que este comprendido entre primero y ultimo
    
    private static int leerOpcion(int primero, int ultimo) {
    	
        int valor = leerEntero();
        
        while (valor < primero || valor > ultimo) {
        	
            valor = leerEntero();
        }
        
        return valor;
    }
      
    
    // Metodos Auxiliares leerFloat y LeerEntero, 
    // Lee de la System.in con el scanner sc y controlan la excepcion de NumberFormatException
    
    
    static private int leerEntero() {
    	
        boolean error = false;
        int  valor = 0;
        String cadena;
        
        do {
        	
        error = false; 
        
          try {
             // Intento leer directamente un entero  
             cadena = sc.nextLine();
             valor = Integer.parseInt(cadena);
             
            } 
          
          catch (NumberFormatException e) {
        	  
              System.out.println("Error en formato.");
              error = true;
              
            }
        }
        
       while (error);
       return valor; 
    }

    static private float leerFloat() {
        
    	boolean error = false;
    	float valor = 0;
    	String cadena;
    	
    	do {
    		
    		error = false;
    		
    	
    	
    	try {
    		
    		cadena = sc.nextLine();
    		valor = Float.parseFloat(cadena);
    		
    	}
    	
    	catch (NumberFormatException e) {
    		
    		
    		System.out.println("Error en formato.");
    		error = true;
    	}
    
    }
    	while (error);
        return valor; 
    }
    
    // Muestra los datos de un producto a partir de su codigo
    
    private static void consultar() {   
    	
       System.out.println("<CONSULTA>");
       System.out.print("Introduzca codigo: ");
       int codigo = leerEntero();
       
       Producto p = almacen.buscarProducto(codigo);
       
       if (p == null) {
    	   
           System.out.println("El producto no se encuentra en almacen");
        }
       
       else {
    	   
           System.out.println("PRODUCTO : "+p);
        }
       
    }
    
   
    // Borrar un producto a partir de su codigo
    
    private static void borrar() {    
    	
      System.out.println("<ELIMINAR>");
      System.out.print("Introduzca codigo: ");
      int codigo = leerEntero();
      
      if (almacen.borrarProducto(codigo)) {
    	  
    	  System.out.println(" El producto ha sido eliminado");
    	  
      } 
      
      else {
    	  
    	  System.out.println(" No existe un producto con ese código");
      }
   }
    
   
 // Cambia el precio de un producto a partir de su código
    
    private static void modificarPrecio() {
    	
        System.out.println("<MODIFICAR PRECIO>");
        
        System.out.print("Introduzca codigo: ");
        int codigo = leerEntero();
        
        
        System.out.print("Introduce el nuevo precio: ");
        float nuevoPrecio = leerFloat();
   
        Producto producto = almacen.buscarProducto(codigo);

        if (producto != null) {
        	
            System.out.println("El precio del producto es: " + producto.getPrecio());
            producto.setPrecio(nuevoPrecio);
            System.out.println("Nuevo precio actualizado para este producto a: " + producto.getPrecio());   
        } 
        
        else {
        	
            System.out.println("No se encontró un producto con ese código.");
        }
    }

    
    
    // Incrementa el stock
    
    private static void comprar() {   
    	
       System.out.println("<COMPRAR>");
       System.out.println("Introduzca el codigo: ");
       int codigo = leerEntero();
       
       Producto producto = almacen.buscarProducto(codigo);
       
       if (producto != null) {
    	   
    	   System.out.println("El producto" +producto.getNombre() +" se ha encontrado: ");
    	   System.out.println("El stock es : " +producto.getStock());
    	   
    	   System.out.println("¿Cuantas unidades quiere comprar para este producto?");
    	   int cantidad = leerEntero();
    	   
    	   if (cantidad > 0) {
    		   
    		   producto.setStock(producto.getStock() + cantidad);
    		   System.out.println("La compra se ha realizado de manera satisfactoria");
    		   System.out.println("El stock restante para este producto: " +producto.getNombre() + "es de " +producto.getStock());  
    	   }
      
       
    	   else {
    		   
    		   System.out.println("La cantidad debe de ser mayor a 0");
    	   }
       }
       
       	   else {
       		   
       		   System.out.println("Aún no disponible");
       		   
       	   }
    	}
    
    // Decrementa el stock
    private static void vender() {
    	
        System.out.println("<VENDER>");
        System.out.println("Introduzca el codigo: ");
        int codigo = leerEntero();
        
        Producto producto = almacen.buscarProducto(codigo);
        
        if (producto != null) {
     	   
     	   System.out.println("El producto" +producto.getNombre() + " se ha encontrado: ");
     	   System.out.println("El stock es : " +producto.getStock());
     	   
     	   System.out.println("¿Cuantas unidades quiere vender para este producto?");
     	   int cantidad = leerEntero();
     	   
     	   if (cantidad > 0) {
     		   
     		   producto.setStock(producto.getStock() - cantidad);
     		   System.out.println("La venta se ha realizado de manera satisfactoria");
     		   System.out.println("El stock restante para este producto: " +producto.getNombre() + "es de " +producto.getStock());  
     	   }
       
        
     	   else {
     		   
     		   System.out.println("La cantidad debe de ser mayor a 0");
     	   }
        }
        
        	   else {
        		   
        		   System.out.println("Aún no disponible");
        		   
        	   }
    		}
    
    // Listado de todos los productos
    private static void listar() {  
    	
         System.out.println("<LISTAR>");
         almacen.listarProductosTodos();
         
    }
    
    // Listado de todos los productos con stock inferior a stock minimo
    private static void listarPocoStock() {
    	
        System.out.println("<LISTAR STOCK BAJO MINIMOS>");
        almacen.listarProductosStockMin();
        
    }
    
    // Solicita datos al usuario para dar de alta un nuevo producto 
    // El codigo no se puede repetir
    private static void crear() {
       
    	   System.out.println("<CREAR NUEVO PRODUCTO>");
           System.out.print("Introduce código: ");
           int codigo = leerEntero();
           
           if (almacen.buscarProducto(codigo) != null) {
               System.out.println("Ya existe un producto con ese código.");
               return;
           }
           
           System.out.print("Introduce nombre: ");
           String nombre = sc.nextLine();
           System.out.print("Introduce stock inicial: ");
           int stock = leerEntero();
           System.out.print("Introduce stock mínimo: ");
           int stockMin = leerEntero();
           System.out.print("Introduce precio: ");
           float precio = leerFloat();

           Producto nuevo = new Producto(codigo, nombre, stock, stockMin, precio);
           almacen.insertarProducto(nuevo);
           System.out.println("Producto añadido: " + nuevo); 
    }
}
