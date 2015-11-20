package utilidades;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
	private int dia, mes, año;
	
	public void asignarFecha(int d, int m, int a){
		this.dia = d;
		this.mes = m;
		this.año = a;
	}
	
	public String mostrarFecha(){
		return (this.obtenerDia() + "/" + this.obtenerMes() + "/" + this.obtenerAño());
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
	
	public int obtenerAño(){
		return año;
	}
	
	protected boolean bisiesto(){
		return ((año % 4) == 0) && (año % 100 != 0 || (año % 400 == 0));
	}
	
	public boolean fechaCorrecta(){
		boolean diaCorrecto, mesCorrecto, añoCorrecto;
		// año correcto?
		añoCorrecto = (año >= 1582);
		// mes correcto?
		mesCorrecto = (mes >= 1) && (mes <=12);
		// día correcto?
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
		return diaCorrecto && mesCorrecto && añoCorrecto;
	}

}
