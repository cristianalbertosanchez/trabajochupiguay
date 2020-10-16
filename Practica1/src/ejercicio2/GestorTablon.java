package ejercicio2;


import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import ejercicio1.Contacto;
import ejercicio1.GestorContactos;

public class GestorTablon {

	private static GestorTablon gestor;
	
	private ArrayList<Anuncio> contactos;
	
	private GestorTablon() {contactos = new ArrayList<Anuncio>();}
	public GestorContactos g= new GestorContactos();
	
		
	public static GestorTablon getInstance() {
		
			if(gestor == null) {
				gestor = new GestorTablon();
			}
			
			return gestor;
		}
	
	
		public Contacto IniciarSesion() {
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Correo Electrónico:");
			String email = teclado.nextLine();
			
			
			Contacto c=null;
			
			if(g.existeContacto(email)==1) {
				
				c = g.getContacto(email);
			}
			else if (g.existeContacto(email)==-1) {
				System.out.println("Correo introducido no válido\n");
				
			}
			else {
				System.out.println("Este correo no se encuentra asociado a ninguna cuenta\n");
			}
			
			return c;
			
			
			
		}	
		
		public void Registrarse() {

			g.CreacionContacto();
			
		}
		
	
	
	
	}



	


	
	