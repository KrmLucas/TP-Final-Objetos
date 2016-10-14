
import java.util.ArrayList;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.lang.Math;

public class Radar {

	
	private double anguloApertura;
	private double alcance;
	private double direccion;
	private ArrayList<RadarListener> listeners;
	
	public Radar(){
		this.listeners = new ArrayList<RadarListener>();
		this.anguloApertura = 40;
		this.alcance = 10;
		this.direccion = 40;
		
	}
	
	public void escanear(Posicion miposicion){
		
		ArrayList<Elemento> detectados = new ArrayList<Elemento>();
		
		// armamos zona de deteccion.
		Polygon zonaDeteccion = new Polygon();
		zonaDeteccion.addPoint(miposicion.getX(), miposicion.getY());
		
		for (double i = (this.getDireccion() - (this.getAnguloApertura()/2)); 
					i< (this.getDireccion() + (this.getAnguloApertura()/2));
					i++){
			
			zonaDeteccion.addPoint((int)(Math.cos(Math.toRadians(i) * this.getAlcance())), 
									(int)(Math.sin(Math.toRadians(i) * this.getAlcance())));
		}

		
		for(Elemento e : Escenario.getEscenario().getElementos()) {
			
			Rectangle r = new Rectangle(e.getPosicion().getX(), e.getPosicion().getY(),
					e.getTamanio().getAncho(), e.getTamanio().getAlto());
			
			if (zonaDeteccion.intersects(r)){
				detectados.add(e);
			}
			
		}
		
		for(RadarListener listener : this.listeners){
			listener.elementosDetectados(detectados);
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

	public void setAnguloApertura(double anguloApertura) {
		this.anguloApertura = anguloApertura;
	}

	public double getAlcance() {
		return alcance;
	}

	public void setAlcance(double alcance) {
		this.alcance = alcance;
	}

	public double getDireccion() {
		return direccion;
	}

	public void setDireccion(double direccion) {
		this.direccion = direccion;
	}
	
	public ArrayList<RadarListener> getListeners() {
		return listeners;
	}

	public void setListeners(ArrayList<RadarListener> listeners) {
		this.listeners = listeners;
	}
	
	
}
