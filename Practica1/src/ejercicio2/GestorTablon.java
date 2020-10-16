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
			
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			System.out.println("Introduce email por favor : \n");
			String email= teclado.nextLine();
												
			if(g.existeContacto(email)==0) {
				g.CreacionContacto(email);
			}
			else if(g.existeContacto(email)==1){
				System.out.println("YA estás registrado!! Inicia sesión desde Inicio para acceder a tu perfil\n");
			}
		}
		
		public void MenuTablon(Contacto c) {
			
			
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			boolean salir = false;
			int opcion2;
			
			while(!salir) {
				System.out.println("MENÚ");
				System.out.println("¡Hola "+ c.getNombre()+"!");
				
				
				System.out.println("");
				System.out.println("1. Tu tablón\n");
				System.out.println("2. Zona creación anuncios \n");
				System.out.println("0. SALIR.\n");

				
				
				System.out.println("Introducir opcion : \n");
				opcion2 = sn.nextInt();
				
				switch(opcion2) {
				
				case 1:
					GestorContactos.clearConsole();
					TablonUsuario(c);
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
					break;
				
				case 2:
					GestorContactos.clearConsole();
					ZonaCreacionUsuario(c);
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
					break;
				
				case 0:
						salir=true;
					break;
					
				}
			}		
		}
			
			
		public void ZonaCreacionUsuario(Contacto c) {
			
			
			
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			boolean salir = false;
			int opcion3;
			
			while(!salir) {
				System.out.println("ZONA DE CREACIÓN ANUNCIOS");
				System.out.println("¡Hola "+ c.getNombre()+"!");
				
				
				System.out.println("");
				System.out.println("1. Editar Anuncio/ Guardar\n");
				System.out.println("2. Publicar anuncio\n");
				System.out.println("3. Archivar anuncio\n");
				System.out.println("4. Buscar anuncio por fecha\n");
				System.out.println("5. Buscar anuncio por interes\n");
				System.out.println("6. Buscar anuncio por usuario propietario\n");
				System.out.println("7. Buscar anuncio por usuario destinatario\n");


				
				System.out.println("0. SALIR.\n");

				
				
				System.out.println("Introducir opcion : \n");
				opcion3 = sn.nextInt();
				
				switch(opcion3) {
				
				case 1:
					GestorContactos.clearConsole();
				
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
					break;
				
				case 2:
					GestorContactos.clearConsole();
					
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
					break;
				case 3:
					GestorContactos.clearConsole();
					
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
					break;
				case 4:
					GestorContactos.clearConsole();
					
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
					break;
				case 5:
					GestorContactos.clearConsole();
					
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
					break;
				case 6:
					GestorContactos.clearConsole();
				
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
					break;
				case 7:
					GestorContactos.clearConsole();
					
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
					break;
				case 0:
						salir=true;
					break;
					
				}
			}		
			
			
		}
		
		public void TablonUsuario(Contacto c) {
			
			
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			boolean salir = false;
			
			
			
			
		}
		
		
	
	
	
	}



	


	
	