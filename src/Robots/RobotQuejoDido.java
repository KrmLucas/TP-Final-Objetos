package Robots;
import Bonus.BonusBateria;
import Configuracion.Calculos;
import Configuracion.Config;
import Core.Escenario;
import Core.Posicion;
import Elementos.Elemento;
import Elementos.Refugio;
import Elementos.Robot;

public class RobotQuejoDido extends Robot{
	
	private static final double LIMITE_ENERGIA = 0.2;

	public RobotQuejoDido(String equipo) {
		super(equipo);
		int x = Config.ESCENARIO_ANCHO - Config.REFUGIO_ANCHO - 30;
		int y = 0;
		Posicion p = new Posicion(x, y);
		Posicion r = new Posicion(x, Config.REFUGIO_ALTO + p.getY() + 10);
		Refugio refugio = new Refugio(equipo);
		refugio.setPosicion(p);
		Escenario.getEscenario().addElemento(refugio);
		//p.setY(Config.REFUGIO_ALTO + 1);
		this.setPosicion(r);
		this.setDireccion(45);
		this.setVelocidad(Config.ROBOT_VELOCIDAD);
	}
	
	@Override
	public void definirEstrategia(){
		int nivelMinimoEnergia = (int) Math.round(Config.ROBOT_ENERGIA * LIMITE_ENERGIA);
		boolean buscaBateria = false;
		int direccion;
		
		if (this.getNivelEnergia() < nivelMinimoEnergia){
			buscaBateria = true;
		}
		this.getRadar();
		for(int i=0; i<this.getElementosDetectados().size();i++){
			Elemento e = this.getElementosDetectados().get(i);
			if ((e instanceof BonusBateria) && buscaBateria){
				BonusBateria b = (BonusBateria)e;
				direccion = Calculos.direccion(this.getPosicion(), b.getPosicion());
				if (this.getCantidadMuniciones()>0){
					this.dispararMunicion(direccion);
				}
				this.setDireccion(direccion);
			} else if (e instanceof Robot){
				Robot r = (Robot)e;
				if (r.getPersona()){
					Posicion np = Calculos.getNewPosicion(r.getPosicion(), r.getDireccion(), r.getVelocidad());
					direccion = Calculos.direccion(this.getPosicion(), np);
					if (this.getCantidadMuniciones()>0){
						this.dispararMunicion(Calculos.direccion(this.getPosicion(), np));
					}
				}
			}
			merodearZonaRescate();
		}
	}

	private void merodearZonaRescate() {
		// TODO Implementar cálculos para rondar la zona central
		
	}
}
