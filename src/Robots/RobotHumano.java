package Robots;

import Armamento.Bomba;
import Armamento.Municion;
import Configuracion.Config;
import Core.Escenario;
import Core.Posicion;
import Elementos.Refugio;
import Elementos.Robot;

public class RobotHumano extends Robot{

	public RobotHumano(){
		super(Config.EQUIPO_HUMANO);
		Posicion p = new Posicion(800, 400);
		Posicion r = new Posicion(800, Config.REFUGIO_ALTO + p.getY() + 10);
		Refugio refugio = new Refugio(Config.EQUIPO_HUMANO);
		refugio.setPosicion(p);
		Escenario.getEscenario().addElemento(refugio);
		//p.setY(Config.REFUGIO_ALTO + 300);
		this.setPosicion(r);	
	}
	@Override
	public void definirEstrategia(){
		
	}
	public void disparar(){
		Municion municion = new Municion(this, 45);
		Escenario.getEscenario().addElemento(municion);
	}
	public void lanzarBomba(){
		Bomba bomba = new Bomba(this, 45);
		Escenario.getEscenario().addElemento(bomba);
	}
	public void avanzar(){
		
	}
}
