package ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		GestorContactos gestor = GestorContactos.getInstance();
		
		
		Scanner sn = new Scanner(Sysetem.in);
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
			
			switch(opcion) {
			case 1: //Crear contacto
				Scanner teclado = new Scanner(System.in);
				
				System.out.println( "Introduce nombre por favor : \n");
				
				String nombre = teclado.nextLine();
				
				System.out.println( "Introduce apellidos por favor : \n");
				
				String apellidos = teclado.nextLine();
				
				System.out.println("Introduce email por favor : \n");
				
				String email = teclado.nextLine();
				
				System.out.println("Introduce la fecha de nacimiento : \n");
				
				String fechaN = teclado.nextLine();
				
				gestor.crearContacto(nombre,apellidos,email,fechaN);
				
				break;
				
			case 2: 
				//Eliminar contacto
				Scanner sn = new Scanner(System.in);
				String email;
				System.out.println("Introducir email de el contacto a actualizar.\n");
				email = sn.nextLine();
				gestor.eliminarContacto(email);
				break;
			case 3:
				//Buscar contacto
				Scanner sn = new Scanner(System.in);
				String email;
				System.out.println("Introducir email de el contacto a actualizar.\n");
				email = sn.nextLine();
				gestor.buscarContacto(email);
				break;
			case 4:
				//Actualizar contacto
				Scanner sn = new Scanner(System.in);
				String email;
				System.out.println("Introducir email de el contacto a actualizar.\n");
				email = sn.nextLine();
				gestor.actualizarContacto(email);
				break;
			case 5:
				//Mostrar contactos
				gestor.mostrarContactos();
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
