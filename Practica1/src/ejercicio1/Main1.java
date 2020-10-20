package ejercicio1;

import java.util.Scanner;
import java.util.ArrayList;

public class Main1 {

	public static void main(String[] args) {
		
		GestorContactos g = GestorContactos.getInstance(); /*Solicito un objeto gestorContactos
		 													mediante el patron singleton*/
		ArrayList<Contacto> recibidos = new ArrayList<Contacto>();
		Scanner sn = new Scanner(System.in);
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		
		
	//Primero cargamos los posibles contactos que pueda haber en el fichero de contactos	
		String ruta;
		ruta = g.getRuta();
		g.leerDeFichero(ruta);
	//-------------------------------------------------------------------------------------	
	 
		
		while(!salir) {
			System.out.println("MENU DE GESTOR DE CONTACTOS");
			System.out.println("");
			System.out.println("1. Crear contacto.\n");
			System.out.println("2. Eliminar contacto.\n");
			System.out.println("3. Buscar contacto.\n");
			System.out.println("4. Actualizar contacto.\n");
			System.out.println("5. Mostrar contactos.\n");
			System.out.println("0. Salir\n");
			
			
			System.out.println("Introducir opcion : \n");
			opcion = sn.nextInt();
			
			switch(opcion){
			case 1: //A�adir contacto
				
				System.out.println("Introduce email por favor : \n");
				String contactoEmail= teclado.nextLine();
													
				while(g.existeContacto(contactoEmail)!= 0) {
					
					System.out.println("Introduce de nuevo un email por favor : \n");
					contactoEmail= teclado.nextLine();
				}
				g.CreacionContacto(contactoEmail);
				
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
					
			case 0:
				//Aqui guardamos todos los contactos que tengamos en el fichero de contactos.
				System.out.println("Guardando contactos en fichero...\n");
				g.escribirEnFichero();
				//-----------------------------------------------------------------------------
				System.out.println("Saliendo del programa ...\n");
				salir = true;
				break;
			default:
				System.out.println("Solo opciones entre 1 y 6.\n"); //En caso de que la opci�n introducida no sea v�lida
					
			}
		}
		
	}
	
	

}
