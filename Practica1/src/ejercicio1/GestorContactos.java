package ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;



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
				Scanner teclado = new Scanner(System.in);
				System.out.println("Introducir nuevo nombre : \n");
				String nuevoNombre = teclado.nextLine();
				
				System.out.println("Introducir nuevos apellidos : \n");
				String nuevosApellidos = teclado.nextLine();
				
				System.out.println("Introducir nuevo email : \n");
				String nuevoEmail = teclado.nextLine();
				
				System.out.println("Introducir nueva fecha de nacimiento : \n");
				String nuevaFecha = teclado.nextLine();
				
				if(existeContacto(nuevoEmail)) {
					System.out.println("El email debe ser unico para cada contacto.\n");
					System.out.println("No se ha actualizado el contacto.\n");
				}else {
					contactos.get(i).setNombre(nuevoNombre);
					contactos.get(i).setApellidos(nuevosApellidos);
					contactos.get(i).setEmail(nuevoEmail);
					contactos.get(i).setFechaN(nuevaFecha);
					System.out.println("Contacto actualizado con exito.\n");
				}
				
			}else {
			
				System.out.println("Contacto no encontrado.\n");
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
	
	
	public boolean existeContacto(String email) {
		boolean existe = false;
		
		for(int i=0;i<contactos.size();i++) {
			if(contactos.get(i).getEmail().contentEquals(email)) {
				existe = true;
			}
		}
		return existe;
	}
	
	static public void press_any_key_to_continue() {
		String seguir;
	    Scanner teclado = new Scanner(System.in);
		System.out.println("Volviendo al men�... pulse una tecla para continuar");
		
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
