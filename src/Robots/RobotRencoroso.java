package Robots;
import Configuracion.Calculos;
import Configuracion.Config;
import Core.Escenario;
import Core.Posicion;
import Elementos.Bonus;
import Elementos.Elemento;
import Elementos.Refugio;
import Elementos.Robot;

public class RobotRencoroso extends Robot{

	public RobotRencoroso(String equipo) {
		super(equipo);
		int x = Config.ESCENARIO_ANCHO - Config.ROBOT_ANCHO;
		int y = Config.ESCENARIO_ALTO - Config.ROBOT_ALTO;
		Posicion p = new Posicion(x, y);
		Refugio refugio = new Refugio(equipo);
		refugio.setPosicion(p);
		Escenario.getEscenario().addElemento(refugio);
		p.setY(p.getY() - 1);
		this.setPosicion(p);
		this.setDireccion(45);
		this.setVelocidad(Config.ROBOT_VELOCIDAD);
	}
	
	@Override
	public void definirEstrategia(){
		int direccion = (int)Math.round(Math.random()*1000)%360; //Dirección aleatoria
	
		for(int i=0; i<this.getElementosDetectados().size();i++){
			Elemento e = this.getElementosDetectados().get(i);
			if (e instanceof Robot){
				Robot r = (Robot)e;
				Posicion np = Calculos.getNewPosicion(r.getPosicion(), r.getDireccion(), r.getVelocidad());
				direccion = Calculos.direccion(this.getPosicion(), np);
				if (this.getCantidadMuniciones()>0){
					this.dispararMunicion(Calculos.direccion(this.getPosicion(), np));
				}
				this.setDireccion(direccion);
			} else if (e instanceof Bonus){
				Bonus b = (Bonus)e;
				int direccionDisparo = Calculos.direccion(this.getPosicion(), b.getPosicion());
				if (this.getCantidadMuniciones()>0){
					this.dispararMunicion(direccionDisparo);
				}
			}
		}
	}
}