package ejercicio2;


import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import ejercicio1.Contacto;
import ejercicio1.GestorContactos;

public class GestorTablon {

	private static GestorTablon gestor;
	

	public GestorContactos g= new GestorContactos();
	
		
	public static GestorTablon getInstance() {
		
			if(gestor == null) {
				gestor = new GestorTablon();
			}
			
			return gestor;
		}
	
	
		public void IniciarSesion() {
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Correo Electr�nico:");
			String email = teclado.nextLine();
			boolean aux=false;
			for(int i=0; i<GestorContactos.contactos.size();i++) {
				if(GestorContactos.contactos.get(i).getEmail().contentEquals(email)) {
					MenuTablon(GestorContactos.contactos.get(i));
					aux=true;
				}

			}
			
			if(!aux) {
				System.out.println("Correo no v�lido, si fuera necesario prueba a registrarte");

			}
			
			
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
				System.out.println("YA est�s registrado!! Inicia sesi�n desde Inicio para acceder a tu perfil\n");
			}
		}
		
		public void MenuTablon(Contacto c) {
			
			
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			boolean salir = false;
			int opcion2;
			
			while(!salir) {
				System.out.println("MEN�");
				System.out.println("�Hola "+ c.getNombre()+"!");
				
				
				System.out.println("");
				System.out.println("1. Tu tabl�n\n");
				System.out.println("2. Zona creaci�n anuncios \n");
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
			if(c.getMisAnuncios()!=null) {
				
			
				while(!salir) {
					System.out.println("ZONA DE CREACI�N ANUNCIOS");
					System.out.println("�Hola "+ c.getNombre()+"!");
					
					
					System.out.println("");
					System.out.println("1. Editar Anuncio / Guardar\n");
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
						
						EditarAnuncio(c);
						
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
			else {
				int op;
				System.out.println("�Todav�a no has creado ning�n anuncio!.\n");
				System.out.println("1. Crear anuncio\n");
				System.out.println("0. Volver\n");
				System.out.println("Introducir opcion : \n");
				op = sn.nextInt();
				
				if(op==1) {
					CrearAnuncio(c);
				}
				else {
					GestorContactos.press_any_key_to_continue();
					GestorContactos.clearConsole();
				}
				
			}
			
			
			
			
		}
		
		public void TablonUsuario(Contacto c) {
			
			
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			boolean salir = false;
			
			
		}
		
		
		public void CrearAnuncio(Contacto c) {
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			int op;
			String tipo;
			System.out.println("Escoge el tipo de anuncio que prefieras.\n");
			System.out.println("1. Anuncio general         :  Este anuncio podr� ser visto por todos los usuarios registrados\n");
			System.out.println("2. Anuncio tem�tico        :  Ser� mostrado a aquellos usuarios que les interese un determinado tema\n");
			System.out.println("3. Anuncio individualizado :  Ser� mostrado a 1 o m�s usuarios espec�ficos\n");
			System.out.println("4. Anuncio Flash           :  Se muestra en el tabl�n restringido entre una fecha/hora inicial y una fecha/hora final\n");
			System.out.println("0. Volver\n");
			System.out.println("Introducir opcion : \n");
			op = sn.nextInt();
			switch(op) {
			
			case 1:
				GestorContactos.clearConsole();
				
				tipo="General";
				SolicitarInfoAnuncio(tipo,c);
								
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
			
			case 2:
				GestorContactos.clearConsole();
				
				tipo="Tematico";				
				SolicitarInfoAnuncio(tipo,c);
				
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
			case 3:
				GestorContactos.clearConsole();
				
				tipo="Individualizado";
				SolicitarInfoAnuncio(tipo,c);
				
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
			case 4:
				GestorContactos.clearConsole();
				
				tipo="Flash";
				SolicitarInfoAnuncio(tipo,c);
				
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
			default: 
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
			break;
			
			}
			
		}
		
		public void SolicitarInfoAnuncio(String tipo,Contacto c){
			Scanner sn = new Scanner(System.in);
			Scanner teclado = new Scanner(System.in);
			int id;
			
			
			
			id= (int) (Math.random()*10000+1); //ASIGNAMOS UN ID MEDIANTE UN N�MERO ALEATORIO
			
			System.out.println("T�tulo: \n");  //PEDIMOS el titulo
			String titulo= teclado.nextLine(); //
			
			String usuario_prop=c.getNombre()+" "+c.getApellidos(); //asignamos el usuario propietario como el usuario creador del anuncio
			
					
			
			String usuario_dest;										//VARIABLES AUXILIARES PARA LOS INTERESES Y LOS USUARIOS DESTINATARIOS
			String interes;
			ArrayList<String> usuarios_dest= new ArrayList<String>();
			
			String fecha_inicio="Siempre";
			String fecha_fin="Siempre";
			
			
			switch(tipo) {
			
			case "General":
				
				usuario_dest="todos";
				usuarios_dest.add(usuario_dest);
				
				break;
				
			case "Tematico":
				

				System.out.println("�A que intereses del usuario te diriges? : \n");
				System.out.println("Escriba alguno de los siguientes separado por comas sin espacios\n");
				System.out.println("Pintura    M�sica    Deporte  \n");
				System.out.println("Pesca      Cine      Fotograf�a  \n");
				System.out.println("Viajes     Tecnolog�a \n");
				
				
				interes= teclado.nextLine();
				
				usuarios_dest=g.UsuariosValidos(interes);

				
				
				break;
				
			case "Individualizado":
				
	
				
				
				System.out.println("�A que usuario/s te diriges? (Escribe sus nombres y apellidos separados por comas): \n");
				usuario_dest= teclado.nextLine();				
				usuarios_dest=Separar(usuario_dest);
				
				break;
				
			case "Flash":
				
				
				System.out.println("Fecha inicio del anuncio: \n");     //FECHA INICIO
				System.out.println("(Por favor sigua el formato DD/MM/AAAA)\n");
				fecha_inicio= teclado.nextLine();
				
				while(!g.validarFecha(fecha_inicio)) {					//COMPROBAMOS QUE INTRODUZCA UNA FECHA V�LIDA
					System.out.println("\nFecha no v�lida");
					System.out.println("Fecha inicio del anuncio: \n");
					System.out.println("(Por favor sigua el formato DD/MM/AAAA)\n");
					fecha_inicio = teclado.nextLine();
				}
				
				
				System.out.println("Fecha de finalizaci�n del anuncio: \n");  //FECHA FINALIZACI�N 
				System.out.println("(Por favor sigua el formato DD/MM/AAAA)\n");
				fecha_fin= teclado.nextLine();
				
				
				
				while(!g.validarFecha(fecha_fin)) {							//COMPROBAMOS QUE INTRODUZCA UNA FECHA V�LIDA
					System.out.println("\nFecha no v�lida");
					System.out.println("Fecha fin del anuncio: \n");
					System.out.println("(Por favor sigua el formato DD/MM/AAAA)\n");
					fecha_fin = teclado.nextLine();
				}
				
				
				usuario_dest="todos";
				usuarios_dest.add(usuario_dest);
				break;
				
				
			default:
				break;
			}
			
			System.out.println("Cuerpo: \n");
			String cuerpo= teclado.nextLine();
	
			Anuncio a= new Anuncio(id,titulo,fecha_inicio,fecha_fin,usuario_prop,usuarios_dest,cuerpo,tipo);

			
			
			ArrayList<Anuncio> auxiliar= new ArrayList<Anuncio>();
			auxiliar.add(a);
			
			c.setMisAnuncios(auxiliar);
			
			System.out.println("Anuncio creado \n");
			
			
		}
	
	
		
		
		public ArrayList<String>Separar(String cadena) {
			ArrayList<String> aux= new ArrayList<String>();
			
			
			String[] separado = cadena.split(",");
			
			
			
			for (int i=0; i<separado.length-1; i++) {
				aux.add(separado[i]);
			}
			
			return aux;
		}
		
	
		
	public void EditarAnuncio(Contacto c){
		
		Scanner sn = new Scanner(System.in);
		Scanner teclado = new Scanner(System.in);
		System.out.println("A continuaci�n te mostramos el t�tulo y los identificadores de tus anuncios: \n");
		ArrayList<Anuncio> auxiliar=new ArrayList<Anuncio>();
		
			auxiliar=c.getMisAnuncios();
			
			for(int j=0;j<auxiliar.size();j++) {
				
				System.out.println("T�tulo : "+auxiliar.get(j).getTitulo()+"\n");
				System.out.println("ID : "+auxiliar.get(j).getId()+"\n");
				System.out.println("------------------------------\n");
				
			}
			
			System.out.println("Escribe el ID del anuncio que quieras modificar: ");
			String id = teclado.nextLine();
			
			
			
			
			
		}
		
		
		

}
		
		
		
	
	



	


	
	