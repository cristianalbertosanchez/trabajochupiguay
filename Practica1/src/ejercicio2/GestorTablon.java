package ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import ejercicio1.Contacto;
import ejercicio1.GestorContactos;

public class GestorTablon {

	private static GestorTablon gestor;
	
	private ArrayList<Anuncio> contactos;
	
	private GestorTablon() {contactos = new ArrayList<Anuncio>();}
	private GestorContactos g;
	
		
	public static GestorTablon getInstance() {
		
			if(gestor == null) {
				gestor = new GestorTablon();
			}
			
			return gestor;
		}
	
	
		public void IniciarSesion() {
			
		}	
		
		public void Registrarse() {

			g.CreacionContacto();
			
		}
		
	
	
	
	}



	


	
	