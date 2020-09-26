package ejercicio1;
import java.util.ArrayList;


public class Contacto {

	
	private String nombre;
	private String apellidos;
	private String fecha_nacimiento;
	private String email;
	private ArrayList<String> intereses;
	
	public Contacto(String nombre,String apellidos,String email,String fechaN) {this.nombre = nombre; this.apellidos = apellidos; this.email = email;this.fecha_nacimiento = fechaN;}
	
	public String getEmail() {return email;}
	public String getNombre(){return this.nombre;}
	public String getApellidos() {return this.apellidos;}	
	public String getFechaN() {return this.fecha_nacimiento;}
	
	public ArrayList<String> getIntereses(){return this.intereses;}
	
	public void setEmail(String email) {this.email = email;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setApellidos(String apellidos) {this.apellidos = apellidos;}
	public void setFechaN(String fechaN) {this.fecha_nacimiento = fechaN;}
		
	
	

	
}
