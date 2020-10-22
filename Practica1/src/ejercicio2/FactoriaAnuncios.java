package ejercicio2;

public class FactoriaAnuncios {
	
	public static Anuncio getAnuncio(int tipo) {
		if(tipo == 1) {
			return new AnuncioGeneral(tipo, null, null, null, null);
		}else if(tipo == 2) {
			return new AnuncioTematico(tipo, null, null, null, null);
		}else if(tipo == 3) {
			return new AnuncioIndividualizado(tipo, null, null, null, null);
		}else if(tipo == 4) {
			return new AnuncioFlash(tipo, null, null, null, null, null, null);
		}else {
			System.out.println("Opcion no valida.");
		}
	}

}
