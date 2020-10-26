package ejercicio2;

import ejercicio1.Contacto;
import java.util.ArrayList;

public abstract class Anuncio {

	private int id;
	private String titulo;
	private Contacto propietario;
	private ArrayList<Contacto> destinatarios;
	private String cuerpo;
	
	
	public Anuncio (int id,String titulo,Contacto propietario,ArrayList<Contacto> destinatarios,String cuerpo){
		
		this.id = id;
		this.titulo = titulo;
		this.propietario = new Contacto(propietario);
		this.destinatarios = new ArrayList<Contacto>(destinatarios);
		this.cuerpo = cuerpo;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Contacto getPropietario() {
		return propietario;
	}
	public void setPropietario(Contacto propietario) {
		this.propietario = propietario;
	}
	public ArrayList<Contacto> getDestinatarios() {
		return destinatarios;
	}
	public void setDestinatarios(ArrayList<Contacto> destinatarios) {
		this.destinatarios = destinatarios;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	
	
	
}
