package ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

import ejercicio1.Contacto;

public class FactoriaAnunciosGenerales extends FactoriaAnuncios{

	@Override
	public AnuncioGeneral crearAnuncioGeneral() {
		
		Scanner sn = new Scanner(System.in);
		String titulo,cuerpo;
		
		System.out.println("Introducir titulo : ");
		titulo = sn.nextLine();
		System.out.println("Introducir cuerpo : ");
		cuerpo = sn.nextLine();
		
		
		AnuncioGeneral a = new AnuncioGeneral(id,titulo,propietario,destinatarios,cuerpo);
		return a;
	}
	
}
