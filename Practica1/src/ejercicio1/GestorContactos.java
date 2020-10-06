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
	
	
	
	
	public void crearContacto(String nombre,String apellidos,String email,String fechaN)
	{
		Contacto c = new Contacto(nombre,apellidos,email,fechaN);
		contactos.add(c);
	}
	
	public void eliminarContacto(String email) 
	{
		for(int i=0;i<contactos.size();i++) {
			if(contactos.get(i).getEmail().contentEquals(email)) {
				System.out.println("Contacto eliminado.\n");
				contactos.remove(i);
			}else {
				System.out.println("Contacto no encontrado.\n");
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
					
					case 0:
						
					default:
						System.out.println("Solo opciones entre 0 y 4.\n");
					break;
				}
				
						
				
				
			}
		}
	}
		
	
	
	public boolean buscarContacto(String email){
		boolean aux;
		aux=false;
		
		for(int i=0;i<contactos.size();i++) {
			if(contactos.get(i).getEmail().contentEquals(email)) {
				System.out.println("\n");
				System.out.println("Nombre              : " + contactos.get(i).getNombre());
				System.out.println("Apellidos           : " + contactos.get(i).getApellidos());
				System.out.println("Email               : " + contactos.get(i).getEmail());
				System.out.println("Fecha de nacimiento : " + contactos.get(i).getFechaN());
				System.out.println("----------------------------");
				
				aux=true;
			}
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
