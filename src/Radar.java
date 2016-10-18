
import java.util.ArrayList;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.lang.Math;
/**
 * Clase que define el objeto Radar que permitir� a los objetos que lo posean escanear una determinada zona del 
 * Escenario y as� detectar otros objetos que haya en el.
 * @author Krmpotic-Saiegg
 *
 */
public class Radar {

	
	private double anguloApertura;
	private double alcance;
	private double direccion;
	private Elemento due�o;
	private ArrayList<RadarListener> listeners;
	
	/**
	 * Constructor de la clase. Recibe como parametro el elemento que ser� su due�o (Radar o Satelite)
	 * @param elemento
	 */
	public Radar(Elemento elemento){
		this.listeners = new ArrayList<RadarListener>();
		this.anguloApertura = ConfigOld.RADAR_ANGULO_APERTURA;
		this.alcance = ConfigOld.RADAR_ALCANCE_MIN;
		this.direccion = ConfigOld.RADAR_DIRECCION;
		this.due�o = elemento;
		
	}
	
	/**
	 *M�todo para detectar otros objetos del escenario que esten dentro de la zona de detecci�n del Radar.
	 *El m�todo hace uso de las clases Rectangle y Polygon (nativas de Java) y aprovecha el m�todo intersects
	 *de la interface shape que ambas implementan. 
	 */
	public void escanear(){
		
		ArrayList<Elemento> detectados = new ArrayList<Elemento>();
		
		// armamos zona de deteccion.
		Polygon zonaDeteccion = new Polygon();
		zonaDeteccion.addPoint(this.getDue�o().getPosicion().getX(), 
							   this.getDue�o().getPosicion().getY());
		
		for (double i = (this.getDireccion() - (this.getAnguloApertura()/2)); 
					 i< (this.getDireccion() + (this.getAnguloApertura()/2));
					 i++){
			
			zonaDeteccion.addPoint((int)(Math.cos(Math.toRadians(i) * this.getAlcance())), 
								   (int)(Math.sin(Math.toRadians(i) * this.getAlcance())));
		}

		
		for(Elemento e : Escenario.getEscenario().getElementos()) {
			
			Rectangle r = new Rectangle (e.getPosicion().getX(), e.getPosicion().getY(),
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
		if (ConfigOld.RADAR_ALCANCE_MIN <= alcance && alcance <= ConfigOld.RADAR_ALCANCE_MAX){
			this.alcance = alcance;
		}else if(ConfigOld.RADAR_ALCANCE_MIN > alcance){
			this.alcance = ConfigOld.RADAR_ALCANCE_MIN;
		}else{
			this.alcance = ConfigOld.RADAR_ALCANCE_MAX;
		}
			
	}

	public double getDireccion() {
		return direccion;
	}

	public void setDireccion(double direccion) {
		this.direccion = direccion;
	}

	public Elemento getDue�o() {
		return due�o;
	}

	public ArrayList<RadarListener> getListeners() {
		return listeners;
	}

	public void setListeners(ArrayList<RadarListener> listeners) {
		this.listeners = listeners;
	}
	
	
}
