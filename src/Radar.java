

import java.util.ArrayList;
import java.lang.Math;

public class Radar {

	
	private double anguloApertura;
	private double alcance;
	private ArrayList<RadarListener> listeners;
	
	public Radar(){
		this.listeners = new ArrayList<RadarListener>();
		this.anguloApertura = 45;
		this.alcance = 10;
		
	}
	
	public void addRadarListener(RadarListener listener){
		this.listeners.add(listener);
	}
	
	public void removeRadarListener(RadarListener listener){
		this.listeners.remove(listener);
	}
	
	public void escanear(Posicion miposicion){
		
		ArrayList<Elemento> detectados = new ArrayList<Elemento>();
		
		// armamos zona de deteccion.
		Posicion aux = new Posicion(Math.cos(anguloApertura/2) * alcance, //dx
									Math.sin(anguloApertura/2) * alcance); //dy
		
		//TODO: resolver correctamente 
		for(Elemento e : Escenario.getEscenario().getElementos()) {
			if(e.getPosicion().mayor(miposicion) && e.getPosicion().menor(aux)){
				detectados.add(e);		
			}
		}
		
		for(RadarListener listener : this.listeners){
			listener.elementosDetectados(detectados);
		}
	}

	
	//Metodos get y set
	public double getAnguloApertura() {
		return anguloApertura;
	}

	public void setAnguloApertura(double anguloApertura) {
		this.anguloApertura = anguloApertura;
	}

	public double getAlcance() {
		return alcance;
	}

	public void setAlcance(double alcance) {
		this.alcance = alcance;
	}

	public ArrayList<RadarListener> getListeners() {
		return listeners;
	}

	public void setListeners(ArrayList<RadarListener> listeners) {
		this.listeners = listeners;
	}
	
	
}
