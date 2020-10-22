package ejercicio2;

import java.util.ArrayList;

import ejercicio1.Contacto;
import ejercicio1.GestorContactos;

public class AnuncioTematico extends Anuncio {
	
	GestorContactos g = GestorContactos.getInstance();

	public ArrayList<Contacto> targets(String interes){
		
		ArrayList<Contacto> ret = new ArrayList<Contacto>();
		
		for(int i=0;i<g.getContactos().size();i++) {
			for(int j=0;j<g.getContactos().get(i).getIntereses().size();j++) {
				if(g.getContactos().get(i).getIntereses().get(j).equals(interes)) {
					ret.add(g.getContactos().get(i));
				}
			}
		}
		
		for(int a = 0;a<ret.size();a++) {
			System.out.println(ret.get(a).getNombre());
		}
		
		return ret;
	}
	
}
