package ejercicio1;
import java.util.ArrayList;

import ejercicio2.Anuncio;
import ejercicio2.GestorTablon;


public class Contacto {

	
	private String nombre;
	private String apellidos;
	private String fecha_nacimiento;
	private String email;
	private ArrayList<String> intereses;
	private ArrayList<Anuncio> mis_anuncios;



	public Contacto(String nombre,String apellidos,String email,String fechaN,ArrayList<String> intereses,ArrayList<Anuncio> mis_anuncios) {this.nombre = nombre; this.apellidos = apellidos; this.email = email;this.fecha_nacimiento = fechaN;this.intereses = intereses;this.mis_anuncios = mis_anuncios;}
	public Contacto(String nombre,String apellidos,String email,String fechaN,ArrayList<String> intereses) {this.nombre = nombre; this.apellidos = apellidos; this.email = email;this.fecha_nacimiento = fechaN;this.intereses = intereses;}

	public Contacto(Contacto c) {
		
		this.nombre = c.nombre; 
		this.apellidos = c.apellidos; 
		this.email = c.email;
		this.fecha_nacimiento = c.fecha_nacimiento;
		this.intereses = new ArrayList<String>(c.intereses);
		this.mis_anuncios = new ArrayList<Anuncio>(c.mis_anuncios);
	}
	
	
	public String getEmail() {return email;}
	public String getNombre(){return this.nombre;}
	public String getApellidos() {return this.apellidos;}	
	public String getFechaN() {return this.fecha_nacimiento;}
	public ArrayList<String> getIntereses(){return this.intereses;}
	public ArrayList<Anuncio> getMisAnuncios(){return this.mis_anuncios;}


	
	public void setEmail(String email) {this.email = email;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setApellidos(String apellidos) {this.apellidos = apellidos;}
	public void setFechaN(String fechaN) {this.fecha_nacimiento = fechaN;}

	public void setIntereses(ArrayList<String> intereses) {this.intereses = intereses;}
	public void setMisAnuncios(ArrayList<Anuncio> mis_anuncios) {this.mis_anuncios = mis_anuncios;}

		
	
	

	
}
