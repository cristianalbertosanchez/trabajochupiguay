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
			if(contactos.get(i).getEmail() == email) {
				contactos.remove(i);
				System.out.println("Contacto eliminado.\n");
			}
		}
	}
	
	public void actualizarContacto(String email) {
		
		for(int i=0;i<contactos.size();i++) {
			if(contactos.get(i).getEmail() == email) {
				Scanner teclado = new Scanner(System.in);
				System.out.println("Introducir nuevo nombre : \n");
				String nuevoNombre = teclado.nextLine();
				contactos.get(i).setNombre(nuevoNombre);
				System.out.println("Introducir nuevos apellidos : \n");
				String nuevosApellidos = teclado.nextLine();
				contactos.get(i).setApellidos(nuevosApellidos);
				System.out.println("Introducir nuevo email : \n");
				String nuevoEmail = teclado.nextLine();
				contactos.get(i).setEmail(nuevoEmail);
				System.out.println("Introducir nueva fecha de nacimiento : \n");
			}
		}
		
	}
	
	public void buscarContacto(String email) {}
	
	public void mostrarContactos() {
		
		for(int i=0;i<contactos.size();i++) {
			System.out.println(contactos.get(i).getNombre());
			System.out.println(contactos.get(i).getApellidos());
			System.out.println(contactos.get(i).getEmail());
			System.out.println(contactos.get(i).getFechaN());
			System.out.println("----------------------------");
		}
		
	}
	
	
}
