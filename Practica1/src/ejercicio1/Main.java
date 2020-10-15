package ejercicio1;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		GestorContactos g = GestorContactos.getInstance(); /*Solicito un objeto gestorContactos
		 													mediante el patron singleton*/
		
		Scanner sn = new Scanner(System.in);
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		
		while(!salir) {
			System.out.println("MENU DE GESTOR DE CONTACTOS");
			System.out.println("");
			System.out.println("1. Crear contacto.\n");
			System.out.println("2. Eliminar contacto.\n");
			System.out.println("3. Buscar contacto.\n");
			System.out.println("4. Actualizar contacto.\n");
			System.out.println("5. Mostrar contactos.\n");
			System.out.println("6. Guardar en fichero.\n");
			System.out.println("7. Leer fichero.\n");
			System.out.println("0. Salir\n");
			
			
			System.out.println("Introducir opcion : \n");
			opcion = sn.nextInt();
			
			switch(opcion){
			case 1: //Añadir contacto
				
				g.CreacionContacto();
								
				
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
				
			case 2: 
				//Eliminar contacto
				g.eliminarContacto();
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				
				break;
			case 3:
				//Buscar contacto

				g.buscarContacto();
				
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
			case 4:
				//Actualizar contacto
				
				String cadena3;
				System.out.println("Introducir email de el contacto a actualizar : \n");
				cadena3 = teclado.nextLine();
				g.actualizarContacto(cadena3);
				
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
			case 5:
				//Mostrar contactos
				g.mostrarContactos();
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				
				break;	
				
			case 6:
				String email;
				Contacto c;
				System.out.println("Introducir el email del contacto que quiere guardar.\n");
				email = teclado.nextLine();
				
				c = g.getContacto(email);
				
				g.escribirEnFichero(c);
				
			break;
			
			case 7:
				String ruta;
				ruta = g.getRuta();
				g.leerDeFichero(ruta);
				
			break;	
					
			case 0:
				System.out.println("Saliendo del programa ...\n");
				salir = true;
				break;
			default:
				System.out.println("Solo opciones entre 1 y 6.\n");
					
			}
		}
		
		
	}

}
