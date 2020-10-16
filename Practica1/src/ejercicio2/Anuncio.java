package ejercicio2;
import java.util.ArrayList;



public class Anuncio {

	
	private int id;
	private String titulo;
	private String usuario_prop;
	private ArrayList<String> usuario_dest;
	private String cuerpo;
	private String tipo;
	
	public Anuncio(int id,String titulo,String usuario_prop, ArrayList<String>usuario_dest, String cuerpo, String tipo) {this.id = id; this.titulo = titulo; this.usuario_prop = usuario_prop;this.usuario_dest = usuario_dest;this.cuerpo = cuerpo;this.tipo = tipo;}
	
	public int getId() {return id;}
	public String getTitulo(){return this.titulo;}
	public String getUsuarioProp() {return this.usuario_prop;}
	public ArrayList<String> getUsuarioDest(){return this.usuario_dest;}
	public String getCuerpo() {return this.cuerpo;}
	public String getTipo() {return this.tipo;}
	
	public void setId(int id) {this.id = id;}
	public void setTitulo(String titulo) {this.titulo = titulo;}
	public void setUsuarioProp(String usuario_prop) {this.usuario_prop = usuario_prop;}
	public void setUsuarioDest(ArrayList<String> usuario_dest) {this.usuario_dest = usuario_dest;}
	public void setCuerpo(String cuerpo) {this.cuerpo = cuerpo;}
	public void setTipo(String tipo) {this.tipo = tipo;}
	
	

	
}
