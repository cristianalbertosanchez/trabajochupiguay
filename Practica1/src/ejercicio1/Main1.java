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
		recibidos = g.leerDeFichero(ruta);
		for(int i=0;i<recibidos.size();i++) {
			g.crearContacto(recibidos.get(i));
		}
		
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
			case 1: //Añadir contacto
				
				
				
				System.out.println( "Introduce nombre por favor : \n");
				
				String nombre = teclado.nextLine();
				
				System.out.println( "Introduce apellidos por favor : \n");
				
				String apellidos = teclado.nextLine();
				
				System.out.println("Introduce email por favor : \n");
				String contactoEmail= teclado.nextLine();
													
				while(g.existeContacto(contactoEmail)==1 ) {
					
					System.out.println("Introduce de nuevo un email por favor : \n");
					contactoEmail= teclado.nextLine();
				}
				
				
				System.out.println("Introduce la fecha de nacimiento :    ");
				System.out.println("(Por favor sigua el formato DD/MM/AAAA)\n");
				String fechaN = teclado.nextLine();
				
				while(!g.validarFecha(fechaN)) {
					System.out.println("\nFecha no válida");
					System.out.println("Introduce la fecha de nacimiento :    ");
					System.out.println("(Por favor sigua el formato DD/MM/AAAA)\n");
					fechaN = teclado.nextLine();
				}
				
				System.out.println("Introduzca sus intereses");
				System.out.println("Escriba alguno de los siguientes separado por comas\n");
				System.out.println("Pintura    Música    Deporte  \n");
				System.out.println("Pesca      Cine      Fotografía  \n");
				System.out.println("Viajes     Tecnología \n");
				
				
				String intereses = teclado.nextLine();
				ArrayList<String> aux = new ArrayList<String>();
				
				g.Obtencion_Intereses(intereses);
				
				while(!g.Obtencion_Intereses(intereses)) {
					System.out.println("\n Intereses no válidos");
					System.out.println("Vuelva a introducir los intereses :    ");
					System.out.println("Escriba alguno de los siguientes separado por comas\n");
					System.out.println("Pintura    Música    Deporte  \n");
					System.out.println("Pesca      Cine      Fotografía  \n");
					System.out.println("Viajes     Tecnología \n");
					intereses = teclado.nextLine();
					
				}
								
				aux = g.devolver_array(intereses);
				
				System.out.println("Contacto creado.\n");
				g.crearContacto(nombre,apellidos,contactoEmail,fechaN,aux);
				
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
				
			case 2: 
				//Eliminar contacto
				g.eliminarContacto();
				g.escribirEnFichero(g.getContactos());
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
				g.escribirEnFichero(g.getContactos());
				//-----------------------------------------------------------------------------
				System.out.println("Saliendo del programa ...\n");
				salir = true;
				break;
			default:
				System.out.println("Solo opciones entre 1 y 6.\n");
					
			}
		}
		
	}
	
	

}
