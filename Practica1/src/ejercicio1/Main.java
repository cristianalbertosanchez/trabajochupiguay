package ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		GestorContactos g = GestorContactos.getInstance();
		
		
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
			System.out.println("0. Salir");
			
			System.out.println("Introducir opcion : \n");
			opcion = sn.nextInt();
			
			switch(opcion){
			case 1: //Crear contacto
				
				System.out.println( "Introduce nombre por favor : \n");
				
				String nombre = teclado.nextLine();
				
				System.out.println( "Introduce apellidos por favor : \n");
				
				String apellidos = teclado.nextLine();
				
				System.out.println("Introduce email por favor : \n");
				
				String contactoEmail = teclado.nextLine();
				
				System.out.println("Introduce la fecha de nacimiento : \n");
				
				String fechaN = teclado.nextLine();
				
				g.crearContacto(nombre,apellidos,contactoEmail,fechaN);
				
				break;
				
			case 2: 
				//Eliminar contacto
				String cadena;
				System.out.println("Introducir email de el contacto a actualizar.\n");
				cadena = teclado.nextLine();
				g.eliminarContacto(cadena);
				break;
			case 3:
				//Buscar contacto
				String cadena2;
				System.out.println("Introducir email de el contacto a actualizar.\n");
				cadena2 = teclado.nextLine();
				g.buscarContacto(cadena2);
				break;
			case 4:
				//Actualizar contacto
				
				String cadena3;
				System.out.println("Introducir email de el contacto a actualizar.\n");
				cadena3 = teclado.nextLine();
				g.actualizarContacto(cadena3);
				break;
			case 5:
				//Mostrar contactos
				g.mostrarContactos();
				break;
			case 6:
				salir = true;
				break;
			default:
				System.out.println("Solo opciones entre 1 y 6.\n");
					
			}
		}
		
		
	}

}
