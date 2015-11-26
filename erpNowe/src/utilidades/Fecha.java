package utilidades;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
	private int dia, mes, a�o;
	
	public void asignarFecha(int d, int m, int a){
		this.dia = d;
		this.mes = m;
		this.a�o = a;
	}
	
	public String mostrarFecha(){
		return (this.obtenerDia() + "/" + this.obtenerMes() + "/" + this.obtenerA�o());
	}
	
	public void fechaActual(){
		GregorianCalendar fecAct = new GregorianCalendar();
		this.asignarFecha(fecAct.get(Calendar.DAY_OF_MONTH),
				          fecAct.get(Calendar.MONTH),
				          fecAct.get(Calendar.YEAR));
	}
	
	public int obtenerDia(){
		return dia;
	}
	
	public int obtenerMes(){
		return mes;
	}
	
	public int obtenerA�o(){
		return a�o;
	}
	
	protected boolean bisiesto(){
		return ((a�o % 4) == 0) && (a�o % 100 != 0 || (a�o % 400 == 0));
	}
	/**
	 * Cambiar el formato de la fecha dd/mm/aaaa a aaaa/mm/dd
	 * */
	public static String darFormatoBD(String fecString){
		String d, m, a;
		int tam = fecString.length();
		if(tam == 10){  // teniendo en cuenta dd/mm/aaaa
			d = fecString.substring(0, 2);
			m = fecString.substring(3, 5);
			a = fecString.substring(6);
			return (a + "-" + m + "-" + d);
		}
		return "";
	}
	
	public boolean fechaCorrecta(){
		boolean diaCorrecto, mesCorrecto, a�oCorrecto;
		// a�o correcto?
		a�oCorrecto = (a�o >= 1582);
		// mes correcto?
		mesCorrecto = (mes >= 1) && (mes <=12);
		// d�a correcto?
		switch(mes){
		case 2: if(bisiesto())
					diaCorrecto = (dia >= 1 && dia <= 29);
				else
					diaCorrecto = (dia >= 1 && dia <= 28);
				break;
		case 4: case 6: case 9: case 11:
				diaCorrecto = (dia >= 1 && dia <= 30);
				break;
		default:
				diaCorrecto = (dia >= 1 && dia <= 31);
		}
		return diaCorrecto && mesCorrecto && a�oCorrecto;
	}

}
