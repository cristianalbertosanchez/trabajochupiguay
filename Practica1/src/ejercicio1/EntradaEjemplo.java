package ejercicio1;
import java.util.Scanner;

public class EntradaEjemplo {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println( "Introduce nombre por favor : \n");
		
		String nombreUsuario = entrada.nextLine();
		
		System.out.println("Introduce edad por favor : \n");
		
		int edad = entrada.nextInt();
		
		System.out.println("Nombre : "+nombreUsuario+" ,Edad : "+edad);

	}

}
