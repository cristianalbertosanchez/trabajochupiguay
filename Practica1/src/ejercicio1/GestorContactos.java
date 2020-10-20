package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 * Crea una clase para representar un gestor de contactos.
 * Este gestor de contactos realiza operaciones sobre objetos contactos como creación,eliminación,
 * modificación y visualización de contactos. Además permite la lectura y escritura de los contactos
 * en un fichero de texto.
 * @author Pablo Domínguez Alcaide
 * @autor Alberto Sánchez Salido
 *
 */

public class GestorContactos {

	private static GestorContactos gestor;
	
	private ArrayList<Contacto> contactos;
	
	public GestorContactos() {contactos = new ArrayList<Contacto>();}
		
	/**
	 * Este método servirá para que solo se pueda crear una instancia del objeto GestorContacto.
	 * <p>
	 * Esta función forma parte de un patrón de diseño llamado patrón singleton, el cual 
	 * permite la creación de una insancia una sola vez.
	 * @return La operación retorna un objeto de tipo GestorContactos
	 */
	
	public static GestorContactos getInstance() {
		
		if(gestor == null) {
			gestor = new GestorContactos();
		}
		
		return gestor;
		
	}
	

	/**
	 * Este método crea un objeto contacto, cuyos valores vienen dados por los argumentos.
	 * <p>
	 * Este metodo recibe el valor que tendrán los atributos de la clase Contacto y crea un objeto 
	 * Contacto con los valores que recibe para luego añadirlo a la lista de contactos del gestor.
	 * @param nombre es el nombre del contacto
	 * @param apellidos son los apellidos del contacto
	 * @param email	es el correo electrónico del contacto, el cual debe ser único
	 * @param fechaN es la fecha de nacimiento del contacto
	 * @param intereses es una serie de intereses que tendrá el contacto
	 */
	
	
	public void CreacionContacto(String email) {

		
		
		Scanner sn = new Scanner(System.in);
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		boolean loop2 = true;
		System.out.println( "Introduce nombre por favor : \n");
		
		String nombre = teclado.nextLine();
		
		System.out.println( "Introduce apellidos por favor : \n");
		
		String apellidos = teclado.nextLine();
		
		System.out.println("Introduce la fecha de nacimiento :    ");
		System.out.println("(Por favor sigua el formato DD/MM/AAAA)\n");
		String fechaN = teclado.nextLine();
		
		while(!validarFecha(fechaN)) {
			System.out.println("\nFecha no válida");
			System.out.println("Introduce la fecha de nacimiento :    ");
			System.out.println("(Por favor sigua el formato DD/MM/AAAA)\n");
			fechaN = teclado.nextLine();
		}
		
		ArrayList<String> aux = new ArrayList<String>();
		while(!salir) {
			System.out.println("Introduzca sus intereses");
			System.out.println("Escriba alguno de los siguientes : \n");
			System.out.println("Pintura    Música    Deporte  \n");
			System.out.println("Pesca      Cine      Fotografía  \n");
			System.out.println("Viajes     Tecnología \n");
			
			String interes = teclado.nextLine();
			if(!validarElemento(interes)) {
				System.out.println("Interes no válido.\n");
			}else {
				aux.add(interes);
				
				System.out.println("¿Desea añadir otro interes?");
				System.out.println("1.Si");
				System.out.println("2.No");
				int op = teclado.nextInt();
				
				if(op == 2) {
					salir = true;
				} else if(op ==1){
					System.out.println("Interes añadido.");
				}else {
					System.out.println("Opcion no valida.");
				}
					
			}
				
		}	
			

		System.out.println("Contacto creado.\n");
		crearContacto(nombre,apellidos,email,fechaN,aux);
	}
	
	
	
	
	public void crearContacto(String nombre,String apellidos,String email,String fechaN,ArrayList<String> intereses)
	{
		Contacto c = new Contacto(nombre,apellidos,email,fechaN,intereses);
		contactos.add(c);
	}
	
	/**
	 * Esta funcion crea un objeto contacto a partir de otro contacto recibido.
	 * <p>
	 * La función recibira un objeto Contacto del cual copiará sus atributos y lo
	 * añadirá a la lista de contactos del gestor.
	 * @param c Objeto de tipo contacto del cual se copiarán los atributos.
	 */
	
	public void crearContacto(Contacto c) {
		Contacto cont = new Contacto(c);
		contactos.add(cont);
	}
	
	/**
	 * Este método devuelve la lista de contactos del gestor contactos
	 * @return La lista de contactos del gestor
	 */
	
	public ArrayList<Contacto> getContactos (){
		return this.contactos;
	}
	
	/**
	 * Este método comprueba si el interés introducido por el usuario es válido.
	 * <p>
	 * La función crea un ArrayList con los intereses que están permitidos y compara la
	 * variable elemento para ver si se encuentra en el ArrayList, si es un elemento válido
	 * (Esta dentro del ArrayList) devuelve true, en caso contrario devuelve false;
	 * @param elemento Interés el cual se va a comprobar si es válido
	 * @return Devuelve true en caso de que el elemento sea válido, falso en caso contrario
	 */
	
	public boolean validarElemento(String elemento) {
		ArrayList<String> InteresesValidos= new ArrayList<String>() ;
		boolean valido=false;
		
		InteresesValidos.add("Deporte");
		InteresesValidos.add("deporte");
		
		InteresesValidos.add("Pesca");
		InteresesValidos.add("pesca");
		
		InteresesValidos.add("Música");
		InteresesValidos.add("musica");
		InteresesValidos.add("Musica");
		
		
		InteresesValidos.add("Cine");
		InteresesValidos.add("cine");
		
		InteresesValidos.add("Pintura");
		InteresesValidos.add("pintura");
		
		InteresesValidos.add("Viajes");
		InteresesValidos.add("viajes");
		
		InteresesValidos.add("Fotografía");
		InteresesValidos.add("fotografia");
		InteresesValidos.add("fotografía");
		
		
		InteresesValidos.add("Tecnología");
		InteresesValidos.add("Tecnologia");
		InteresesValidos.add("tecnologia");
		
		
		
		
		for(int i=0 ;i<InteresesValidos.size();i++) {
			if(InteresesValidos.get(i).contentEquals(elemento)) {
				valido=true;
			}
		}
		
		return valido;
	}
	
	
	
	
	/**
	 * Este método elimina un contacto de la lista de contactos del gestor.
	 * <p>
	 * Primero se pregunta por el email del contacto a eliminar y lo busca en 
	 * la lista de contactos, si no está se mostrará un error por pantalla, en 
	 * caso contrario se mostrarán los datos del contacto que se va a eliminar
	 * y se pide una confirmación, si se recibe confirmación el contacto se elimina.
	 */
	
	
	public void eliminarContacto() 
	{
		
		
		Scanner sn = new Scanner(System.in);
		Scanner teclado = new Scanner(System.in);
				
		String cadena,auxiliar;
		boolean comprueba=false;
		System.out.println("Introducir email de el contacto a eliminar : \n");
		cadena = teclado.nextLine();
		
		for(int i=0;i<contactos.size();i++) {
			if(contactos.get(i).getEmail().contentEquals(cadena)) {
				comprueba=true;
			}
		}
		
		
		if(!comprueba) {
			System.out.println("Contacto no encontrado\n");
		}
		else {
			System.out.println("A continuación se muestran los datos del contacto a eliminar: \n");
			
			for(int i=0;i<contactos.size();i++) {
				String nombre=contactos.get(i).getNombre();
				String apellidos=contactos.get(i).getApellidos();
				String Email=contactos.get(i).getEmail();
				String Fecha_nacimiento=contactos.get(i).getFechaN();
				
				
				System.out.println("Nombre              : "+nombre);
				System.out.println("Apellidos           : "+apellidos);
				System.out.println("Email               : "+Email);
				System.out.println("Fecha de nacimiento : "+Fecha_nacimiento);
				System.out.print("Intereses           : ");
				for(int a=0;a<contactos.get(i).getIntereses().size();a++)
				{
					if(a== contactos.get(i).getIntereses().size()-1) {
						 System.out.print(contactos.get(i).getIntereses().get(a)+".");
					}else {
						 System.out.print(contactos.get(i).getIntereses().get(a) + ",");
					}
				}
				
				System.out.println("");
				System.out.println("----------------------------");
			
				
			}
			System.out.println("¿Eliminar definitivamente? Y/N \n");
			auxiliar = teclado.nextLine();
							
			if(auxiliar.equals("y")|| auxiliar.equals("Y")) {
				for(int i=0;i<contactos.size();i++) {
					if(contactos.get(i).getEmail().contentEquals(cadena)) {
						System.out.println("Contacto eliminado.\n");
						contactos.remove(i);
					}
				}
			}
		}
		
		
	}
	
	/**
	 * Este método actualiza la información del contacto especificado.
	 * <p>
	 * Esta función recibe de argumento el email del contacto del cual se quieren
	 * modificar los datos. Si lo encuentra en la lista de contactos del gestor le 
	 * pregunta al usuario que dato desea modificar dependiendo de la opción introducida
	 * se le pide al usuario que introduzca el nuevo dato para el contacto y lo sobreescribe.
	 * @param email sirve como identificador del contacto que se va a actualizar
	 */
	
	public void actualizarContacto(String email) {
		
		for(int i=0;i<contactos.size();i++) {
			if(contactos.get(i).getEmail().contentEquals(email)) {
				
				Scanner sn = new Scanner(System.in);
				Scanner teclado = new Scanner(System.in);
				
				System.out.println("1. Cambiar Nombre.\n");
				System.out.println("2. Cambiar Apellidos.\n");
				System.out.println("3. Cambiar Email.\n");
				System.out.println("4. Cambiar Fecha de nacimiento.\n");
				System.out.println("5. Cambiar Intereses.\n");
				
				System.out.println("0. Volver\n");
					
				System.out.println("Introducir opcion para ACTUALIZAR : \n");
				int opcion = sn.nextInt();
				
				switch(opcion){
				
					case 1:
						System.out.println("Introducir nuevo nombre : \n");
						String nuevoNombre = teclado.nextLine();
						contactos.get(i).setNombre(nuevoNombre);
						System.out.println("Actualizado con éxito\n");
					break;
						
					case 2:
						System.out.println("Introducir nuevos apellidos : \n");
						String nuevosApellidos = teclado.nextLine();
						contactos.get(i).setApellidos(nuevosApellidos);
						System.out.println("Actualizado con éxito\n");
					break;
					
					case 3:
						System.out.println("Introducir nuevo email : \n");
						String nuevoEmail = teclado.nextLine();
						
							if(existeContacto(nuevoEmail)==-1) {
								System.out.println("Email ya en uso.\n");
								System.out.println("No se ha actualizado el contacto.\n");
							}
							else {
								contactos.get(i).setEmail(nuevoEmail);
								System.out.println("Actualizado con éxito\n");
							}
					break;
					
					
					case 4:
						System.out.println("Introducir nueva fecha de nacimiento : \n");
						String nuevaFecha = teclado.nextLine();
						boolean a= (validarFecha(nuevaFecha));
						if(a) {
							contactos.get(i).setFechaN(nuevaFecha);
							System.out.println("Actualizado con éxito\n");
						}
						else {
							System.out.println("Formato fecha no válida.\n");
							System.out.println("No se ha actualizado el contacto.\n");
						}
					break;
					
					case 5:
						
					
						
						boolean salir = false;
						ArrayList<String> aux = new ArrayList<String>();
						while(!salir) {
							System.out.println("Introduzca sus nuevos intereses");
							System.out.println("Escriba alguno de los siguientes : \n");
							System.out.println("Pintura    Música    Deporte  \n");
							System.out.println("Pesca      Cine      Fotografía  \n");
							System.out.println("Viajes     Tecnología \n");
							
							String interes = teclado.nextLine();
							if(!validarElemento(interes)) {
								System.out.println("Interes no válido.\n");
							}else {
								aux.add(interes);
								System.out.println("¿Desea añadir otro interes?");
								System.out.println("1.Si");
								System.out.println("2.No");
								int op = teclado.nextInt();
								if(op == 2) {
									salir = true;
								}
							}
							
						}
						
						contactos.get(i).getIntereses().clear();
						contactos.get(i).setIntereses(aux);
						System.out.println("Intereses actualizados correctamente.");

						
					break;
					
					
					case 0:
						
					default:
						System.out.println("Solo opciones entre 0 y 5.\n");
					break;
				}
				
						
				
				
			}
			
		}
	}
		
	/**
	 * Método que busca por nombre y apellidos,por fecha de nacimiento, por email o por intereses y 
	 * lo muestra por pantalla.
	 * <p>
	 * Primero se le pregunta al usuario por que parámetro desea realizar la búsqueda, una vez
	 * indicado se le vuelve a preguntar al usuario que introduzca el parámetro del contacto que se 
	 * quiere visualizar, lo busca en la lista de contactos del gestor y si está muestra sus datos,
	 * si no muestra un error. Este método está implementado de tal forma que si se invoca desde el 
	 * main solo, lo único que hace es mostrar el contacto pero se puede igualar a una variable bool
	 * para comprobar si ese contacto está en la lista de contacto.
	 * @return true si el contacto está en la lista de contactos del gestor, false en caso contrario.
	 */
	
	public boolean buscarContacto(){
		boolean aux;
		aux=false;
		int opcion;
		Scanner sn = new Scanner(System.in);
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("1. Buscar por Nombre y apellidos.\n");
		System.out.println("2. Buscar por Fecha de nacimiento\n");
		System.out.println("3. Buscar por Email.\n");
		System.out.println("4. Buscar por Intereses.\n");
		System.out.println("0. Salir\n");
		
		
		System.out.println("Introducir opcion : \n");
		opcion = sn.nextInt();
			switch(opcion) {
				case 1:
					
					System.out.println( "Introduce el nombre por favor : \n");
					String nombre = teclado.nextLine();
					System.out.println( "Introduce los apellidos por favor : \n");
					String apellidos = teclado.nextLine();
					
					for(int i=0;i<contactos.size();i++) {
						if(contactos.get(i).getNombre().contentEquals(nombre)&&contactos.get(i).getApellidos().contentEquals(apellidos)) {
							System.out.println("\n");
							System.out.println("Nombre              : " + contactos.get(i).getNombre());
							System.out.println("Apellidos           : " + contactos.get(i).getApellidos());
							System.out.println("Email               : " + contactos.get(i).getEmail());
							System.out.println("Fecha de nacimiento : " + contactos.get(i).getFechaN());
							System.out.println("Intereses           : \n");
							for(int j=0;j<contactos.get(i).getIntereses().size();j++)
							{
								System.out.println(contactos.get(i).getIntereses().get(j));
							}
							
							System.out.println("----------------------------");
							
							aux=true;
						}
					}
					if(!aux) {
						System.out.println("No se encuentran resultados");
					}
							
					
				break;
				
				case 2:
					System.out.println( "Introduce la fecha de nacimiento con el siguiente formato DD/MM/AAAA : \n");
					String fecha = teclado.nextLine();
					if(validarFecha(fecha)) {
						for(int i=0;i<contactos.size();i++) {
							if(contactos.get(i).getFechaN().contentEquals(fecha)) {
								System.out.println("\n");
								System.out.println("Nombre              : " + contactos.get(i).getNombre());
								System.out.println("Apellidos           : " + contactos.get(i).getApellidos());
								System.out.println("Email               : " + contactos.get(i).getEmail());
								System.out.println("Fecha de nacimiento : " + contactos.get(i).getFechaN());
								System.out.println("Intereses           : \n");
								for(int j=0;j<contactos.get(i).getIntereses().size();j++)
								{
									System.out.println(contactos.get(i).getIntereses().get(j));
								}
								
								System.out.println("----------------------------");
								aux=true;
							}
						}
					}
					else {
						System.out.println("Formato de Fecha no válido\n");
					}
					if(!aux) {
						System.out.println("No se encuentran resultados");
					}
					
				break;
				
				case 3:

					System.out.println( "Introduce el email a buscar por favor : \n");
					String Email = teclado.nextLine();
					
					for(int i=0;i<contactos.size();i++) {
						if(contactos.get(i).getEmail().contentEquals(Email)) {
							System.out.println("\n");
							System.out.println("Nombre              : " + contactos.get(i).getNombre());
							System.out.println("Apellidos           : " + contactos.get(i).getApellidos());
							System.out.println("Email               : " + contactos.get(i).getEmail());
							System.out.println("Fecha de nacimiento : " + contactos.get(i).getFechaN());
							System.out.println("Intereses           :\n");
							for(int j=0;j<contactos.get(i).getIntereses().size();j++)
							{
								System.out.println(contactos.get(i).getIntereses().get(j));
							}
							
							System.out.println("----------------------------");
							aux=true;
						}
					}
					if(!aux) {
						System.out.println("No se encuentran resultados");
					}
					
				break;
				
				case 4:
					System.out.println( "Introduce el interes a buscar por favor : \n");
					String interes_a_buscar = teclado.nextLine();
					
					for(int i=0;i<contactos.size();i++) {
						for(int j=0;j<contactos.get(i).getIntereses().size();j++) {
							if(contactos.get(i).getIntereses().get(j).contentEquals(interes_a_buscar)) {
								System.out.println("\n");
								System.out.println("Nombre              : " + contactos.get(i).getNombre());
								System.out.println("Apellidos           : " + contactos.get(i).getApellidos());
								System.out.println("Email               : " + contactos.get(i).getEmail());
								System.out.println("Fecha de nacimiento : " + contactos.get(i).getFechaN());
								System.out.println("Intereses           : ");
								for(int a=0;a<contactos.get(i).getIntereses().size();a++)
								{
									System.out.println(contactos.get(i).getIntereses().get(a));
								}
								
								System.out.println("----------------------------");
								aux=true;
							}
						}
						if(!aux) {
							System.out.println("No se encuentran resultados");
						}
					}
				break;
				
				case 0:
					System.out.println("Volviendo al menú... \n");
				break;
				default:
					System.out.println("Opcion no válida \n");
				break;
			}
		
		return aux;
	}
	

	/**
	 * Este método recibe un email como argumento y devuelve 1 en caso de que haya algún
	 * contacto con ese mismo email,0 si no existe ningún contacto con ese email y -1 
	 * si el email no tiene un formato válido
	 * @param email Cadena que se va a buscar como email de un contacto.
	 * @return 1 si el Contacto con email especificado existe, 0 si no existe contacto con ese email y 
	 * -1 si el formato del email especificado no es válido.
	 */
	public int existeContacto(String email) {
		int existe = 0;
		
		if(email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
			
			for(int i=0;i<contactos.size();i++) {
				if(contactos.get(i).getEmail().contentEquals(email)) {
					existe = 1;
				}
			}
			if(existe==1) {
				System.out.println("El email ya se encuentra en uso\n");
			}
			
		}
		else {
			existe=-1;
			System.out.println("Formato de email no válido\n");
		}

		return existe;
	}
	
	/**
	 * Este método comprueba si la cadena introducida cumple el formato inpuesto.
	 * <p>
	 * El método divide la cadena introducida en 3 subcadenas (dia,mes y año) y comprueba 
	 * que cada una de ellas cumple el formato deseado.
	 * @param FechaN Cadena de texto que se quiere comprobar
	 * @return true si la fecha cumple con el formato deseado, false en caso contrario
	 */
	
	public boolean validarFecha(String FechaN) {
		boolean valido=true;

		
		if(!FechaN.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
			valido=false;
		}
		else {
			String aux1 = FechaN.substring(0,2);
			String aux2 = FechaN.substring(3,5);
			String aux3 = FechaN.substring(6,10);
			
			
			int dia=Integer.valueOf(aux1);
			int mes=Integer.valueOf(aux2);
			int anio=Integer.valueOf(aux3);
			if(dia<0 || dia>30) {
				valido=false;
			}
			if(mes<0 || mes>12) {
				valido=false;
			}
			if(anio<1800 || anio>2020) {
				valido=false;
			}
			
		}
		
		
		return valido;
	}
		

	/**
	 * Este método se encarga de esperar a que el usuario pulse una tecla para seguir con el programa.
	 */
	
	static public void press_any_key_to_continue() {
		String seguir;
	    Scanner teclado = new Scanner(System.in);
		System.out.println("Volviendo al menú... pulse INTRO para continuar");
		
		try
	    {
	        seguir = teclado.nextLine();
	    }
	    catch(Exception e)
	    {}
		
	}
	
	/**
	 * Este método se encarga de limpiar la consola.
	 */
	
	public final static void clearConsole()
	{
	       try
	       {
	           final String os = System.getProperty("os.name");

	           if (os.contains("Windows"))
	           {
	               Runtime.getRuntime().exec("cls");
	           }
	           else
	           {
	               Runtime.getRuntime().exec("clear");
	           }
	       }
	       catch (final Exception e)
	       {
	           //  Handle any exceptions.
	       }
	}
	
	
	/**
	 * Este método busca el fichero properties y devuelve su ruta.
	 * @return una cadena String que es la ruta del fichero properties
	 */
	
	public String getRuta() {
		
		File file = new File("C:\\Users\\w10\\git\\trabajochupiguay\\Practica1\\src\\ejercicio1\\fichero.properties");
		String propertiesPath = file.getAbsolutePath();
		
		Properties appProperties = new Properties();
		
		try {
			appProperties.load(new FileInputStream(propertiesPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String ruta = appProperties.getProperty("ruta");
		
		
		return ruta;
		
		
	}
	
	/**
	 * Este método se encarga de escribir los contactos en un fichero.
	 * <p>
	 * El método recibe la lista de contactos del gestor y los escribe en un fichero de texto
	 * @param c Lista de contactos del gestor de contactos
	 */
	
	public void escribirEnFichero() {
		
		String nombre = "";
		String apellidos = "";
		String email = "";
		String fechaN = "";
		ArrayList<String> intereses = new ArrayList<String>();
		
		
		String rutaFichero = getRuta();
		
		
		
		try {
			FileWriter fichero = new FileWriter(rutaFichero,false);
			PrintWriter pw = new PrintWriter(fichero);
			for(int i=0;i<getContactos().size();i++) {
				email = getContactos().get(i).getEmail();
				nombre = getContactos().get(i).getNombre();
				apellidos = getContactos().get(i).getApellidos();				
				fechaN = getContactos().get(i).getFechaN();
				intereses = getContactos().get(i).getIntereses();
				
				pw.println(nombre);
				pw.println(apellidos);
				pw.println(email);
				pw.println(fechaN);
				for(int j=0;j<intereses.size();j++) {
					if(j== intereses.size()-1) {
						 pw.print(intereses.get(j)+"\n");
					}else {
						 pw.print(intereses.get(j) + ",");
					}
					
				}
				
			}
			pw.close();
			fichero.close();
			
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Este método recibe la ruta del fichero properties y devuelve una lista con los contactos
	 * del fichero
	 * <p>
	 * El método busca el fichero.properties que está en la ruta que recibe como argumento, del
	 * cual saca la ruta del fichero con los contactos y guarda estos contactos en la lista de 
	 * contactos del gestor de contactos.
	 * @param ruta Parámetro que indica la ruta del fichero.properties
	 * @return una lista con los contactos del fichero de contactos
	 */
	
	public void leerDeFichero(String ruta) {	
			
			try {
				FileReader fr;
				fr = new FileReader(ruta);
				BufferedReader br = new BufferedReader(fr);
				String cadena;
				String nombre = "",apellidos = "",email = "",fechaN = "";
				ArrayList<String> intereses =  new ArrayList<String>();
				
				while((cadena = br.readLine())!=null) {
				
						nombre = cadena;
						cadena = br.readLine();
						apellidos = cadena;
						cadena = br.readLine();
						email = cadena;
						cadena = br.readLine();
						fechaN = cadena;
						cadena = br.readLine();
						ArrayList<String> aux = new ArrayList<String>(devolver_array(cadena));
						for(int j=0;j<aux.size();j++) {
							System.out.println(aux.get(j));
						}
						
						crearContacto(nombre,apellidos,email,fechaN,aux);
						
						intereses.clear();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	/**
	 * Esta función recibe el email del contacto que se quiere buscar y lo devuelve.
	 * @param email
	 * @return el contacto cuyo atributo de email se corresponde con la cadena enviada.
	 */
	
	public Contacto getContacto(String email) {
		Contacto c = null;
		for(int i=0;i<contactos.size();i++) {
			if(!contactos.get(i).getEmail().contentEquals(email)) {
				System.out.println("No se ha encontrado contacto.\n");
			}else {
				c = contactos.get(i);
			}
		}
		return c;
	}
	
	/**
	 * Este método recibe una lista de contactos y muestra los datos de todos los contactos
	 * de la lista
	 * @param lista Lista de contactos de los cuales se quieren ver los datos
	 */
	
	public void mostrarContactos() {
		
		if(contactos.isEmpty()) {
			System.out.println("La lista de contactos está vacia.\n");
		}
		
		for(int i=0;i<contactos.size();i++) {
			String nombre=contactos.get(i).getNombre();
			String apellidos=contactos.get(i).getApellidos();
			String Email=contactos.get(i).getEmail();
			String Fecha_nacimiento=contactos.get(i).getFechaN();
			
			
			System.out.println("Nombre              : "+nombre);
			System.out.println("Apellidos           : "+apellidos);
			System.out.println("Email               : "+Email);
			System.out.println("Fecha de nacimiento : "+Fecha_nacimiento);
			System.out.print("Intereses           : ");
			for(int a=0;a<contactos.get(i).getIntereses().size();a++)
			{
				if(a== contactos.get(i).getIntereses().size()-1) {
					 System.out.print(contactos.get(i).getIntereses().get(a)+".");
				}else {
					 System.out.print(contactos.get(i).getIntereses().get(a) + ",");
				}
			}
			
			System.out.println("");
			System.out.println("----------------------------");
		
			
		}
	}
	

	
	public ArrayList<String>Separar(String cadena) {
		ArrayList<String> aux= new ArrayList<String>();
		
		
		String[] separado = cadena.split(",");
		
		
		
		for (int i=0; i<separado.length-1; i++) {
			aux.add(separado[i]);
		}
		
		return aux;
	}
	
	//Funcion que recibe una cadena que se presupone con valores String separados entre
	//comas y los separa añadiendo cada valor a una posicion de un ArrayList<String> que devulve posteriormente
	
	public ArrayList<String> UsuariosValidos(String cadena){
		
		ArrayList<String> intereses_buscados=new ArrayList<String>();
		
		ArrayList<String> intereses=new ArrayList<String>();
		
		ArrayList<String> aux=new ArrayList<String>();
		
		intereses_buscados=Separar(cadena);
		
		Contacto c;
		
		for(int j=0;j<intereses_buscados.size();j++) {
				for(int i=0;i<contactos.size();i++) {
					intereses=contactos.get(j).getIntereses();
					c=contactos.get(j);
					for(int h=0;h<intereses.size();h++) {
						if(intereses.get(h).contentEquals(intereses_buscados.get(j))) {
							String nombre=c.getNombre();
							String apellidos=c.getApellidos();
							String nombre_apellidos=nombre+" "+apellidos;
							aux.add(nombre_apellidos);
						}
						
					}
				}
					
					
			}
			
		
		
		
		return aux;
	}
	
	
public ArrayList<String> devolver_array (String cadena){
		
		ArrayList<String> array = new ArrayList<String>();
		boolean aux;
		
				
		String[] InteresElementos = cadena.split(",");
		
	
		for (int i=0; i<InteresElementos.length; i++) {
			
			array.add(InteresElementos[i]);
		}
		
		return array;
	}
	
	
}
