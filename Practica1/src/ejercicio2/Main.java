package ejercicio2;

import java.util.Scanner;

import ejercicio1.GestorContactos;

public class Main {

	public static void main(String[] args) {
		
		int id = 0;
		Scanner sn = new Scanner(System.in);
		int op;
		
		GestorAnuncios gA = GestorAnuncios.getInstance();
		
		
		
		
		
		System.out.println("Menu Anuncios");
		System.out.println("");
		System.out.println("1.Iniciar Sesion.");
		System.out.println("2.Registrarse.");
		op = sn.nextInt();
		
		if(op == 1) {
			gA.IniciarSesion();
		}else if(op == 2){
			gA.Registrarse();
		}else {
			System.out.println("Opcion no valida.");
		}
	}
}
