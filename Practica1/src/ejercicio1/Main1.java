package ejercicio1;

import java.util.Scanner;
import java.util.ArrayList;

public class Main1 {

	public static void main(String[] args) {
		
		GestorContactos g = GestorContactos.getInstance(); /*Solicito un objeto gestorContactos
		 													mediante el patron singleton*/
		ArrayList<Contacto> recibidos = new ArrayList<Contacto>();
		Scanner sn = new Scanner(System.in);
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		
		
	//Primero cargamos los posibles contactos que pueda haber en el fichero de contactos	
		String ruta;
		ruta = g.getRuta();
		g.leerDeFichero(ruta);
	//-------------------------------------------------------------------------------------	
	 
		
		while(!salir) {
			System.out.println("MENU DE GESTOR DE CONTACTOS");
			System.out.println("");
			System.out.println("1. Crear contacto.\n");
			System.out.println("2. Eliminar contacto.\n");
			System.out.println("3. Buscar contacto.\n");
			System.out.println("4. Actualizar contacto.\n");
			System.out.println("5. Mostrar contactos.\n");
			System.out.println("0. Salir\n");
			
			
			System.out.println("Introducir opcion : \n");
			opcion = sn.nextInt();
			
			switch(opcion){
			case 1: //A�adir contacto
				
				System.out.println("Introduce email por favor : \n");
				String contactoEmail= teclado.nextLine();
													
				while(g.existeContacto(contactoEmail)!= 0) {
					
					System.out.println("Introduce de nuevo un email por favor : \n");
					contactoEmail= teclado.nextLine();
				}
				
				
				Scanner tec = new Scanner(System.in);
				boolean out = false;
				System.out.println( "Introduce nombre por favor : \n");
				
				String nombre = tec.nextLine();
				
				System.out.println( "Introduce apellidos por favor : \n");
				
				String apellidos = tec.nextLine();
				
				System.out.println("Introduce la fecha de nacimiento :    ");
				System.out.println("(Por favor sigua el formato DD/MM/AAAA)\n");
				String fechaN = tec.nextLine();
				
				while(!g.validarFecha(fechaN)) {
					System.out.println("\nFecha no v�lida");
					System.out.println("Introduce la fecha de nacimiento :    ");
					System.out.println("(Por favor sigua el formato DD/MM/AAAA)\n");
					fechaN = tec.nextLine();
				}
				
				ArrayList<String> aux = new ArrayList<String>();
				while(!out) {
					System.out.println("Introduzca sus intereses");
					System.out.println("Escriba alguno de los siguientes : \n");
					System.out.println("Pintura    M�sica    Deporte  \n");
					System.out.println("Pesca      Cine      Fotograf�a  \n");
					System.out.println("Viajes     Tecnolog�a \n");
					
					String interes = tec.nextLine();
					if(!g.validarElemento(interes)) {
						System.out.println("Interes no v�lido.\n");
					}else {
						aux.add(interes);
						
						System.out.println("�Desea a�adir otro interes?");
						System.out.println("1.Si");
						System.out.println("2.No");
						int op = tec.nextInt();
						
						if(op == 2) {
							out = true;
						} 
						
						if(op == 1) {
							System.out.println("Contacto a�adido.");
						}
						
						if(op != 1 && op != 2) {
							System.out.println("Opcion no valida.");
						}
							
					}
						
				}	
				
				
				g.crearContacto(nombre,apellidos,contactoEmail,fechaN,aux);
				
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
				
			case 2: 
				//Eliminar contacto
				
				String cadena;
				
				System.out.println("Introducir email de el contacto a eliminar : \n");
				cadena = teclado.nextLine();
				
				g.eliminarContacto(cadena);
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				
				break;
			case 3:
				//Buscar contacto
				
				Scanner teclado2 = new Scanner(System.in);
				int op3;
				
				System.out.println("1. Buscar por Nombre y apellidos.\n");
				System.out.println("2. Buscar por Fecha de nacimiento\n");
				System.out.println("3. Buscar por Email.\n");
				System.out.println("4. Buscar por Intereses.\n");
				System.out.println("0. Salir\n");
				
				
				System.out.println("Introducir opcion : \n");
				op3 = teclado2.nextInt();
				
				g.buscarContacto(op3);
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
			case 4:
				//Actualizar contacto
				
				String cadena3;
				int opcion2;
				
				System.out.println("Introducir email de el contacto a actualizar : \n");
				cadena3 = teclado.nextLine();
				
				
				System.out.println("1. Cambiar Nombre.\n");
				System.out.println("2. Cambiar Apellidos.\n");
				System.out.println("3. Cambiar Email.\n");
				System.out.println("4. Cambiar Fecha de nacimiento.\n");
				System.out.println("5. Cambiar Intereses.\n");
				
				System.out.println("0. Volver\n");
					
				System.out.println("Introducir opcion para ACTUALIZAR : \n");
				opcion2 = sn.nextInt();
				
				g.actualizarContacto(opcion2,cadena3);
				
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				break;
			case 5:
				//Mostrar contactos
				g.mostrarContactos();
				GestorContactos.press_any_key_to_continue();
				GestorContactos.clearConsole();
				
				break;	
					
			case 0:
				//Aqui guardamos todos los contactos que tengamos en el fichero de contactos.
				System.out.println("Guardando contactos en fichero...\n");
				g.escribirEnFichero();
				//-----------------------------------------------------------------------------
				System.out.println("Saliendo del programa ...\n");
				salir = true;
				break;
			default:
				System.out.println("Solo opciones entre 1 y 6.\n"); //En caso de que la opci�n introducida no sea v�lida
					
			}
		}
		
	}
	
	

}
