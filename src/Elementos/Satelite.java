package Elementos;

import java.util.ArrayList;

import Armamento.Bomba;
import Armamento.Municion;
import Armamento.Radar;
import Configuracion.Config;
import Core.Escenario;
import Core.Posicion;
import Interfaces.RadarListener;

/**
 * Clase que define el concepto Satelite.  
 * @author Krmpotic-Saiegg
 *
 */
public class Satelite extends Elemento implements RadarListener {

	private Radar radar;
	private int nivelEscudo;
	private String equipo;
	private int cantidadMuniciones;
	private int direccionDisparo;
	
	/**
	 * Constructor de la clase. 
	 */
	public Satelite (String equipo){
		super(); 
		this.cantidadMuniciones = 10;
		this.nivelEscudo = Config.SATELITE_ESCUDOS;
		this.equipo = equipo;
		this.radar = new Radar(this);
		this.getTamanio().setAlto(Config.SATELITE_ALTO);
		this.getTamanio().setAncho(Config.SATELITE_ANCHO);
		this.setPosicion(new Posicion(50,50));	//TODO
		this.direccionDisparo = 0;				//TODO
		this.radar.addRadarListener(this);
		//TODO [CORRECCION] Nunca se ponen a escuchar el radar.
	}
	
	/**
	 * El m�todo disparar recibe como parametro el elemento "objetivo" y se lo pasa al constructor de Municion
	 * para que al crearse la misma se calcule la direccion del disparo. Ademas incorpora el elemento Municion 
	 * al Escenario y decrementa la cantidad de municiones.
	 * @param e
	 */
	public void disparar(int direccion){
		//TODO [CORRECCION] Por qu� necesitan un elemento por parametro?
		Municion m = new Municion(this, direccion);
		Escenario.getEscenario().addElemento(m);
		this.setCantidadMuniciones(this.getCantidadMuniciones()-1);
	}
	
	//Implementacion del listener
	@Override
	public void elementosDetectados(ArrayList<Elemento> elementos) {

		for (Elemento e : elementos){
			//TODO: ver tema equipos -> si robot es de mi equipo no le tiro
			if (e instanceof Bonus){
				this.disparar(this.calcularDireccion(e.getPosicion()));
			}else if (e instanceof Robot){
				Robot r = (Robot) e;
				this.disparar(this.calcularDireccion(r.getPosicion(),r.getDireccion(),r.getVelocidad()));
			}
		}
	}

	
	private int calcularDireccion(Posicion posicion, int direccion, int velocidad) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int calcularDireccion(Posicion posicion) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Implementacion de los metodos heredados de la clase abstracta Elemento
	 */
	@Override
	public void jugar() {
		
		//this.getRadar().escanear();
		
		/*TODO: if elemento detectado ==> disparar municion*/
	}

	@Override
	public void destruir() {
		//TODO [CORRECCION] Por qu� sobreescriben esto? y no hacen nada?
		
	}
	/**
	 * El satelite solo debe estar atento a los choques con Municiones o Bombas, situacion en la cual decrementa
	 * su nivel de escudo.
	 * TODO: ver como manejar el "da�o" (cantidad de unidades en la que se decrementa el nivel de escudo) 
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		if (elemento instanceof Municion || elemento instanceof Bomba) {
			this.setNivelEscudo(this.getNivelEscudo()-1);
		}
	}

	/**
	 * M�todos get y set
	 * 
	 */
	public Radar getRadar() {
		return radar;
	}

	public int getNivelEscudo() {
		return nivelEscudo;
	}

	public void setNivelEscudo(int nivelEscudo) {
		this.nivelEscudo = nivelEscudo;
	}

	public int getCantidadMuniciones() {
		return cantidadMuniciones;
	}

	public void setCantidadMuniciones(int cantidadMuniciones) {
		this.cantidadMuniciones = cantidadMuniciones;
	}

	public String getEquipo(){
		return this.equipo;
	}
}