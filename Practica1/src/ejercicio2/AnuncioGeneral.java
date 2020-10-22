package ejercicio2;

import java.util.ArrayList;

import ejercicio1.Contacto;

public class AnuncioGeneral extends Anuncio {

	public AnuncioGeneral(int id,String titulo,Contacto propietario,ArrayList<Contacto> destinatarios,String cuerpo) {
		super(id,titulo,propietario,destinatarios,cuerpo);
	}
	
}
