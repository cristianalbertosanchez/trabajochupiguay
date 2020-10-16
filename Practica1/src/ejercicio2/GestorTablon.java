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
	
	
		public boolean IniciarSesion() {
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Correo Electrónico:");
			String email = teclado.nextLine();
			
			
			Contacto c=null;
			
			if(g.existeContacto(email)==1) {
				
				c = g.getContacto(email);
				MenuTablon(c);
				
				
				return true;
			}
			else if (g.existeContacto(email)==-1) {
				System.out.println("Correo introducido no válido\n");
				
			}
			else {
				System.out.println("Este correo no se encuentra asociado a ninguna cuenta\n");
			}
			
			return false;
			
			
			
		}	
		
		public void Registrarse() {

			g.CreacionContacto();
			
		}
		
		public void MenuTablon(Contacto c) {
			
			
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			boolean salir = false;
			int opcion2;
			
			while(!salir) {
				System.out.println("MENÚ");
				System.out.println("");
				System.out.println("1. Tu tablón\n");
				System.out.println("2. Zona creación anuncios \n");
				System.out.println("0. SALIR.\n");

				
				
				System.out.println("Introducir opcion : \n");
				opcion2 = sn.nextInt();
				
				switch(opcion2) {
				
				case 1:
					TablonUsuario();
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
					break;
				
				case 2:
					ZonaCreacionUsuario();
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
					break;
				
				case 0:
						salir=true;
					break;
					
				}
			}		
		}
			
			
		public void ZonaCreacionUsuario() {
			
		}
		
		public void TablonUsuario() {
			
		}
		
		
	
	
	
	}



	


	
	