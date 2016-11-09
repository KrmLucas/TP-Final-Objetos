package Armamento;

import java.util.ArrayList;
import java.util.Iterator;

import Configuracion.Config;
import Core.Escenario;
import Elementos.Elemento;
import Elementos.Robot;
import Interfaces.RadarListener;
import Robots.RobotHumano;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.lang.Math;
/**
 * Clase que define el objeto Radar que permitirá a los objetos que lo posean escanear una determinada zona del 
 * Escenario y así detectar otros objetos que haya en el.
 * @author Krmpotic-Saiegg
 *
 */
public class Radar {

	private double anguloApertura;
	private double alcance;
	private double direccion;
	private Elemento duenio;
	private Escenario escenario;
	private ArrayList<Elemento> elementosDetectados; 
	private ArrayList<RadarListener> listeners;
	
	/**
	 * Constructor de la clase. Recibe como parametro el elemento que será su dueño (Radar o Satelite)
	 * @param elemento
	 */
	public Radar(Elemento elemento){
		this.listeners = new ArrayList<RadarListener>();
		this.elementosDetectados = new ArrayList<Elemento>();
		this.anguloApertura = Config.RADAR_ANGULO_APERTURA;
		this.alcance = Config.RADAR_ALCANCE_MIN;
		this.direccion = Config.RADAR_DIRECCION;
		this.duenio = elemento;
		this.escenario = Escenario.getEscenario();

	}
	
	/**
	 *Método para detectar otros objetos del escenario que esten dentro de la zona de detección del Radar.
	 *El método hace uso de las clases Rectangle y Polygon (nativas de Java) y aprovecha el método intersects
	 *de la interface shape que ambas implementan. 
	 */
	public void escanear(){
		
		this.elementosDetectados = this.escenario.detectarElementos(getZonaDeteccion());
		
		// Hasta acá

		/*
		//TODO [CORRECCION] No exponer la lista
		for(Elemento e : it.next()){ //Escenario.getEscenario().getElementos()) {
			
			Rectangle r = new Rectangle (e.getPosicion().getX(), e.getPosicion().getY(),
										 e.getTamanio().getAncho(), e.getTamanio().getAlto());
			
			if (zonaDeteccion.intersects(r)){
				detectados.add(e);
			}			
		}*/
		for(RadarListener listener : this.listeners){
			listener.elementosDetectados(this.elementosDetectados);
		}
	}

	
	public void addRadarListener(RadarListener listener){
		this.listeners.add(listener);
	}
	
	public void removeRadarListener(RadarListener listener){
		this.listeners.remove(listener);
	}
	
	//Metodos get y set
	public double getAnguloApertura() {
		return anguloApertura;
	}
	public Polygon getZonaDeteccion(){
		
		
		//ArrayList<Elemento> detectados = new ArrayList<Elemento>();
		
		
				//TODO [MEJORA] Si van a utilizar muchas veces el mismo x e y, seria interesanto ponerlas en variables locales
				//asi el código queda mucho mas entendible.
				
				// armamos zona de deteccion.
				Polygon zona = new Polygon();
				
				int x = this.getDuenio().getPosicionX();
				int y = this.getDuenio().getPosicionY();
				
				double direccion = this.getDireccion();
				
				if (this.getDuenio() instanceof Robot)
					direccion += ((Robot)this.getDuenio()).getDireccion();
				
				zona.addPoint(x,y);
				for (double i = (direccion - (this.getAnguloApertura()/2)); 
							 i< (direccion + (this.getAnguloApertura()/2));
							 i += 2){
					
					double angulo = Math.toRadians(i);
					
					int x1 = (int)(Math.cos(angulo) * this.getAlcance() + x);
					int y1 = (int)(Math.sin(angulo) * this.getAlcance() + y);
					
					zona.addPoint(x1, y1);
				}
				
				zona.addPoint(x,y);
				
/*
				zona = new Polygon();
				
				zona.addPoint(x, y);
				zona.addPoint(x+100, y);
				zona.addPoint(x+100, y+100);
				 
				zona.addPoint(x, y);
	*/			 	
		return zona;
	}

	public void setAnguloApertura(double anguloApertura) {
		this.anguloApertura = anguloApertura;
	}

	public double getAlcance() {
		return alcance;
	}

	
	@Override
	public String toString() {
		return "Radar detecto elemento";
	}
	
	public void setAlcance(double alcance) {
		if (Config.RADAR_ALCANCE_MIN <= alcance && alcance <= Config.RADAR_ALCANCE_MAX){
			this.alcance = alcance;
		}else if(Config.RADAR_ALCANCE_MIN > alcance){
			this.alcance = Config.RADAR_ALCANCE_MIN;
		}else{
			this.alcance = Config.RADAR_ALCANCE_MAX;
		}	
	}

	public double getDireccion() {
		return direccion;
	}

	public void setDireccion(double direccion) {
		this.direccion = direccion;
	}

	public Elemento getDuenio() {
		return duenio;
	}
	
	//TODO [CORRECCION] Si tienen un addRadarListener y un removeRadarListener, no deberian exponer la variable listeners

	//public ArrayList<RadarListener> getListeners() {
	//	return listeners;
	//}

	//public void setListeners(ArrayList<RadarListener> listeners) {
	//	this.listeners = listeners;
	//}
}
