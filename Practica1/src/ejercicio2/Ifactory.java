package ejercicio2;

import java.util.ArrayList;

import ejercicio1.Contacto;

public interface Ifactory {

	public Anuncio crearAnuncioGeneral();
	
	public AnuncioTematico crearAnuncioTematico();
	
	public AnuncioIndividualizado crearAnuncioIndividualizado();
	
	public AnuncioFlash crearAnuncioFlash();

	
}
