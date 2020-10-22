package ejercicio2;

import java.util.Date;
import java.util.Calendar;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Calendar cal = Calendar.getInstance();
		
		cal.set(cal.YEAR,2020);
		cal.set(cal.MONTH,9);
		cal.set(cal.DAY_OF_MONTH, 22);
		cal.set(cal.HOUR_OF_DAY, 23);
		cal.set(cal.MINUTE,00);
		cal.set(cal.SECOND,00);
		
		Date horaTarget = cal.getTime();
		Date horaActual = new Date();
		
		if(horaActual.equals(horaTarget)) {
			System.out.println("Ya es la hora.");
		}else {
			System.out.println("Todavia no es la hora.");
		}
		
		System.out.println(horaActual);
		
	}

}
