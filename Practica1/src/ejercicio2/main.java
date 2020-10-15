package ejercicio2;
import java.util.Scanner;

import ejercicio1.GestorContactos;

import java.util.ArrayList;

public class main{
	
	public static void main(String[] args) {
		
		GestorTablon t = GestorTablon.getInstance(); /*Solicito un objeto gestorContactos mediante el patron singleton*/	
		Scanner sn = new Scanner(System.in);
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		int opcion1;
		
		while(!salir) {
			
			
			
			System.out.println("INICIO");
			System.out.println("");
			System.out.println("1. Iniciar sesión\n");
			System.out.println("2. Registrarse \n");
			System.out.println("0. SALIR.\n");

			
			
			System.out.println("Introducir opcion : \n");
			opcion1 = sn.nextInt();
			
			switch(opcion1) {
			
			case 1:
				t.IniciarSesion();
				break;
			
			case 2:
				t.Registrarse();
				break;
			
			case 0:
					salir=true;
				break;
				
			}
		}
		
		
		
		
	}
		
}