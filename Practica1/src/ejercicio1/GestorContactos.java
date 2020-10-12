package ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;


public class GestorContactos {

	private static GestorContactos gestor;
	
	private ArrayList<Contacto> contactos;
	
	private GestorContactos() {contactos = new ArrayList<Contacto>();}
		
	public static GestorContactos getInstance() {
		
		if(gestor == null) {
			gestor = new GestorContactos();
		}
		
		return gestor;
		
	}
	

	
	
	public void crearContacto(String nombre,String apellidos,String email,String fechaN,ArrayList<String> intereses)
	{
		Contacto c = new Contacto(nombre,apellidos,email,fechaN,intereses);
		contactos.add(c);
	}
	
	
	public boolean Obtencion_Intereses(String interesestotal) {
		
		String[] InteresElementos = interesestotal.split(",");
		boolean aux;
		
		
		for (int i=0; i<InteresElementos.length-1; i++) {
			aux=validarElemento(InteresElementos[i]);
			if (!aux) {
				InteresElementos = interesestotal.split(" ,");
				for(int j=0;j<InteresElementos.length-1; j++) {
					aux=validarElemento(InteresElementos[j]);
					if(!aux) {
						return false;
					}
				}
			}
		}
	return true;
	}
	
	public ArrayList<String> devolver_array (String cadena){
		
		ArrayList<String> array = new ArrayList<String>();
		array.add(cadena);
		boolean aux;
				
		String[] InteresElementos = cadena.split(",");
		
		
		
		for (int i=0; i<InteresElementos.length-1; i++) {
			
			aux=validarElemento(InteresElementos[i]);
			
			if (!aux) {
				
				InteresElementos = cadena.split(" ,");
				
				for(int j=0;j<InteresElementos.length-1; j++) {
					
					aux=validarElemento(InteresElementos[j]);
					
					if (aux) {
						array.add(InteresElementos[i]);
					}
				}
			}
		}
		
		return array;
	}
	
	
	public boolean validarElemento(String elemento) {
		ArrayList<String> InteresesValidos= new ArrayList<String>() ;
		boolean valido=false;
		
		InteresesValidos.add("Deporte");
		InteresesValidos.add("deporte");
		
		InteresesValidos.add("Pesca");
		InteresesValidos.add("pesca");
		
		InteresesValidos.add("M�sica");
		InteresesValidos.add("musica");
		InteresesValidos.add("Musica");
		
		
		InteresesValidos.add("Cine");
		InteresesValidos.add("cine");
		
		InteresesValidos.add("Pintura");
		InteresesValidos.add("pintura");
		
		InteresesValidos.add("Viajes");
		InteresesValidos.add("viajes");
		
		InteresesValidos.add("Fotograf�a");
		InteresesValidos.add("fotografia");
		InteresesValidos.add("fotograf�a");
		
		
		InteresesValidos.add("Tecnolog�a");
		InteresesValidos.add("Tecnologia");
		InteresesValidos.add("tecnologia");
		
		
		
		
		for(int i=0 ;i<InteresesValidos.size();i++) {
			if(InteresesValidos.get(i).contentEquals(elemento)) {
				valido=true;
			}
		}
		
		return valido;
	}
	
	
	
	
	
	
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
			System.out.println("A continuaci�n se muestran los datos del contacto a eliminar: \n");
			
			for(int i=0;i<contactos.size();i++) {
				if(contactos.get(i).getEmail().contentEquals(cadena)) {
					comprueba=true;
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
				}
			}
			System.out.println("�Eliminar definitivamente? Y/N \n");
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
						System.out.println("Actualizado con �xito\n");
					break;
						
					case 2:
						System.out.println("Introducir nuevos apellidos : \n");
						String nuevosApellidos = teclado.nextLine();
						contactos.get(i).setApellidos(nuevosApellidos);
						System.out.println("Actualizado con �xito\n");
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
								System.out.println("Actualizado con �xito\n");
							}
					break;
					
					
					case 4:
						System.out.println("Introducir nueva fecha de nacimiento : \n");
						String nuevaFecha = teclado.nextLine();
						boolean a= (validarFecha(nuevaFecha));
						if(a) {
							contactos.get(i).setFechaN(nuevaFecha);
							System.out.println("Actualizado con �xito\n");
						}
						else {
							System.out.println("Formato fecha no v�lida.\n");
							System.out.println("No se ha actualizado el contacto.\n");
						}
					break;
					
					case 5:
						System.out.println("Introducir los nuevos intereses: \n");
						System.out.println("Escriba alguno de los siguientes separado por comas\n");
						System.out.println("Pintura    M�sica    Deporte  \n");
						System.out.println("Pesca      Cine      Fotograf�a  \n");
						System.out.println("Viajes     Tecnolog�a \n");
						String intereses = teclado.nextLine();
						ArrayList<String> aux = new ArrayList<String>();
						
						Obtencion_Intereses(intereses);
						
						while(!Obtencion_Intereses(intereses)) {
							System.out.println("\n Intereses no v�lidos");
							System.out.println("Vuelva a introducir los intereses :    ");
							System.out.println("Escriba alguno de los siguientes separado por comas\n");
							System.out.println("Pintura    M�sica    Deporte  \n");
							System.out.println("Pesca      Cine      Fotograf�a  \n");
							System.out.println("Viajes     Tecnolog�a \n");
							intereses = teclado.nextLine();
							
						}
										
						aux = devolver_array(intereses);
						contactos.get(i).addInteres(aux);
						
					break;
					
					
					case 0:
						
					default:
						System.out.println("Solo opciones entre 0 y 5.\n");
					break;
				}
				
						
				
				
			}
			
		}
	}
		
	
	
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
						System.out.println("Formato de Fecha no v�lido\n");
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
					System.out.println("Volviendo al men�... \n");
				break;
				default:
					System.out.println("Opcion no v�lida \n");
				break;
			}
		
		return aux;
	}
	
	public void mostrarContactos() {
		if(contactos.isEmpty()) {
			System.out.println("La lista esta vacia.\n");
		}else {
			
			for(int i=0;i<contactos.size();i++) {
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
			}
		}
		
	}
	
	
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
			System.out.println("Formato de email no v�lido\n");
		}

		return existe;
	}
	
	
	
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
		

	
	
	static public void press_any_key_to_continue() {
		String seguir;
	    Scanner teclado = new Scanner(System.in);
		System.out.println("Volviendo al men�... pulse INTRO para continuar");
		
		try
	    {
	        seguir = teclado.nextLine();
	    }
	    catch(Exception e)
	    {}
		
	}
	
	
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
	
	
	
}
