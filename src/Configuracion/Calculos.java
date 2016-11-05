package Configuracion;
import java.awt.Rectangle;

import Core.Posicion;
import Elementos.Elemento;

public class Calculos {
	
	public static final Posicion Centro(Elemento elemento){
		
		int x = elemento.getTamanio().getAncho()/2 + elemento.getPosicion().getX();
		int y = elemento.getTamanio().getAlto()/2  + elemento.getPosicion().getY();
		
		return new Posicion(x, y);		
	}
	
	public static final Posicion getNewPosicion(Posicion posicion, int direccion, int distancia){
		
		int px = posicion.getX() + (int)Math.round((double)distancia * Math.cos(Math.toRadians(direccion))); 
		int py = posicion.getY() + (int)Math.round((double)distancia * Math.sin(Math.toRadians(direccion))); 
		
		return new Posicion(px, py);
	}
	
	public static int direccion(Posicion inicio, Posicion fin){
		
		int deltaX = fin.getX() - inicio.getX();
		int deltaY = fin.getY() - inicio.getY();
		double hipotenusa = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
		int angulo = (int)Math.round((Math.toDegrees(Math.acos(deltaX/hipotenusa)))); //Devuelve long
		
		if (deltaY < 0)
			angulo = 360 - angulo;
		return angulo;
	}
	
	public static int rebotar(int direccion){
		return 180 - direccion;
	}

	public static Rectangle area(Elemento e) {
		Rectangle r = new Rectangle(e.getPosicion().getX(), e.getPosicion().getY(),
						e.getTamanio().getAncho(), e.getTamanio().getAlto());
		return r;
	}
}