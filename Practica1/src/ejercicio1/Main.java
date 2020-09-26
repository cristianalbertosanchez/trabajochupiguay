package ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		GestorContactos gestor = GestorContactos.getInstance();
		
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
		
		gestor.mostrarContactos();

		
	}

}
