package ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

import ejercicio1.GestorContactos;
import ejercicio1.Contacto;


public class GestorAnuncios {

	
	private static GestorAnuncios gestorA = null;
	
	
	
	public static GestorAnuncios getInstance() {
		if(gestorA == null) {
			gestorA = new GestorAnuncios();
		}
		return gestorA;
	}
	
	public void IniciarSesion() {
		
		String email;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Intoducir email : ");
		email = teclado.nextLine();
		
		for(int i=0;i<gC.getContactos().size();i++) {
			if(gestorC.getContactos().get(i).getEmail().equals(email)) {
				MenuAnuncios(gestorC.getContactos().get(i));
			}
		}
		
		
	}
	
	
	public void Registrarse() {
		
		Scanner teclado = new Scanner(System.in);
		String email;
		
		System.out.println("Introducir email : ");
		email = teclado.nextLine();
		
		for(int i=0;i<gestorC.getContactos().size();i++) {
			if(gestorC.getContactos().get(i).getEmail().equals(email)) {
				System.out.println("Email ya en uso.");
			}else {
				gestorC.CreacionContacto(email);
				MenuAnuncios(gestorC.getContactos().get(i));
			}
		}
		
	}
	
	public void MenuAnuncios(Contacto c) {
		Scanner sn = new Scanner(System.in);
		int op;
		ArrayList<Anuncio> aux = new ArrayList<Anuncio>(c.getAnuncios());
		System.out.println("Bienvenido "+c.getNombre()+"\n");
		System.out.println("1.Ver Anuncios");
		System.out.println("2.Crear Anuncio");
		op = sn.nextInt();
		
		if(op == 1) {
			System.out.println("Mostrar Anuncios en construccion...");
		}else if(op ==2) {
			System.out.println("Crear Anuncios en construccion...");
		}else {
			System.out.println("Opcion no valida");
		}
		
	}
	
	
}
