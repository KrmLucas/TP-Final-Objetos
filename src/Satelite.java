
import java.util.ArrayList;

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
	}
	
	/**
	 * El método disparar recibe como parametro el elemento "objetivo" y se lo pasa al constructor de Municion
	 * para que al crearse la misma se calcule la direccion del disparo. Ademas incorpora el elemento Municion 
	 * al Escenario y decrementa la cantidad de municiones.
	 * @param e
	 */
	public void disparar (Elemento e){
		Municion m = new Municion(e, 0);
		Escenario.getEscenario().addElemento(m);
		this.setCantidadMuniciones(this.getCantidadMuniciones()-1);
	}
	
	//Implementacion del listener
	@Override
	public void elementosDetectados(ArrayList<Elemento> elementos) {

		for (Elemento e : elementos){
			//TODO: ver tema equipos -> si robot es de mi equipo no le tiro
			if (e instanceof Bonus){
				this.disparar(e);
			}else if (e instanceof Robot){
				this.disparar(e);
			}
		}
	}

	
	/**
	 * Implementacion de los metodos heredados de la clase abstracta Elemento
	 */
	@Override
	public void jugar() {
		
		this.getRadar().escanear();
		
		/*TODO: if elemento detectado ==> disparar municion*/
	}

	@Override
	public void destruir() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * El satelite solo debe estar atento a los choques con Municiones o Bombas, situacion en la cual decrementa
	 * su nivel de escudo.
	 * TODO: ver como manejar el "daño" (cantidad de unidades en la que se decrementa el nivel de escudo) 
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		if (elemento instanceof Municion || elemento instanceof Bomba) {
			this.setNivelEscudo(this.getNivelEscudo()-1);
		}
	}

	/**
	 * Métodos get y set
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
