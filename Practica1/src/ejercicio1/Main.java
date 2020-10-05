package ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		GestorContactos g = GestorContactos.getInstance(); /*Solicito un objeto gestorContactos
		 													mediante el patron singleton*/
		
		
		Scanner sn = new Scanner(System.in);
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		
		
		while(!salir) {
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
													
				while(g.existeContacto(contactoEmail)) {
					System.out.println("El email ya se encuentra en uso, por favor ingrese otra dirección de email.\n");
					System.out.println("Introduce email por favor : \n");
					contactoEmail= teclado.nextLine();
				}
				System.out.println("Introduce la fecha de nacimiento : \n");
				String fechaN = teclado.nextLine();
				
				System.out.println("Contacto creado.\n");
				g.crearContacto(nombre,apellidos,contactoEmail,fechaN);
				
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
				
			case 2: 
				//Eliminar contacto
				String cadena,auxiliar;
				System.out.println("Introducir email de el contacto a eliminar : \n");
				cadena = teclado.nextLine();
				
				if(!g.buscarContacto(cadena)) {
					System.out.println("Contacto no encontrado\n");
					break;
				}
				System.out.println("A continuación se muestran los datos del contacto a eliminar: \n");
				System.out.println("¿Eliminar definitivamente? Y/N \n");
				auxiliar = teclado.nextLine();
								
				if(auxiliar.equals("y")|| auxiliar.equals("Y")) {
					g.eliminarContacto(cadena);
				}
				else {
					System.out.println("Volviendo al menú...");
				}
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				
				break;
			case 3:
				//Buscar contacto
				String cadena2,aux;
				System.out.println("Introducir email de el contacto a buscar : \n");
				cadena2 = teclado.nextLine();
				g.buscarContacto(cadena2);
				
				while(!g.buscarContacto(cadena2)) {
					
					System.out.println("Contacto no encontrado \n");
					System.out.println("¿Desea buscar otro contacto? Y/N\n");
					aux = teclado.nextLine();
					if(aux.equals("y")|| aux.equals("Y")) {
						System.out.println("Introducir email de el contacto a buscar : \n");
						cadena2 = teclado.nextLine();
						g.buscarContacto(cadena2);
					}
					else {
						System.out.println("Volviendo al menú...");
						break;
					}
				}
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
				System.out.println("Saliendo del programa ...\n");
				salir = true;
				break;
			default:
				System.out.println("Solo opciones entre 1 y 6.\n");
					
			}
		}
		
		
	}

}
