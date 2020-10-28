package ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

import ejercicio1.GestorContactos;
import ejercicio1.Contacto;


public class GestorAnuncios {

	
	private static GestorAnuncios gestorA = null;
	
	GestorContactos gC = GestorContactos.getInstance();
	
	
	
	
	
	public static GestorAnuncios getInstance() {
		if(gestorA == null) {
			gestorA = new GestorAnuncios();
		}
		return gestorA;
	}
	
	
	public void recibirContactos() {
	
		String ruta;
		ruta = gC.getRuta();
		gC.leerDeFichero(ruta);
	}
	
	
	
	
	
	public void IniciarSesion() {
		
		String email;
		Scanner teclado = new Scanner(System.in);
		boolean esta = false;
		
		
		recibirContactos();
		
		
		System.out.println("Intoducir email : ");
		email = teclado.nextLine();
	
	
		for(int i=0;i<gC.getContactos().size();i++) {
			if(gC.getContactos().get(i).getEmail().equals(email)) {
				MenuAnuncios(gC.getContactos().get(i));
				esta = true;
			}
		}
		
		if(esta == false) {
			System.out.println("No se ha encontrado el contacto.");
		}
		
		
		
	}
	
	
	public void Registrarse() {
		
		Scanner teclado = new Scanner(System.in);
		String email;
		
		System.out.println("Introducir email : ");
		email = teclado.nextLine();
		
		for(int i=0;i<gC.getContactos().size();i++) {
			if(gC.getContactos().get(i).getEmail().equals(email)) {
				System.out.println("Email ya en uso.");
			}else {
				gC.CreacionContacto(email);
				MenuAnuncios(gC.getContactos().get(i));
			}
		}
		
	}
	
	public void MenuAnuncios(Contacto c) {
		Scanner sn = new Scanner(System.in);
		int op;
		System.out.println(c.getNombre());
		if(c.getAnuncios() != null) {
			ArrayList<Anuncio> aux = new ArrayList<Anuncio>(c.getAnuncios());
		}else {
			System.out.println("Vaya, todavia no tienes anuncios creados");
		}
		
		System.out.println("Bienvenido "+c.getNombre()+"\n");
		System.out.println("1.Ver Anuncios");
		System.out.println("2.Crear Anuncio");
		op = sn.nextInt();
		
		if(op == 1) {
			System.out.println("Mostrar Anuncios en construccion...");
		}else if(op ==2) {
			
		}else {
			System.out.println("Opcion no valida");
		}
		
	}
	
	
}
