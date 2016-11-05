package Core;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import Configuracion.Calculos;
import Configuracion.Config;
import Elementos.Elemento;
import Elementos.Satelite;
import Elementos.ZonaRescate;
import Interfaces.JuegoListener;
import Robots.RobotHumano;
import Robots.RobotQuejoDido;
import Robots.RobotSoldadoRyan;

//CORREGIDO

/**
 * Implementa el tablero donde se desarrollará la partida. Se encarga de crear los elementos
 * participantes, darles el turno para jugar, verificar si hubieron colisiones, eliminar los
 * elementos muertos y mostrar el estado del juego.
 * 
 * @author Krmpotic-Saiegg
 *
 */
public class Escenario {

	private static Escenario escenario;
	private ArrayList<Elemento> elementos;
	private ArrayList<JuegoListener> listeners;
	private int ancho;
	private int alto;
	private boolean pausado;

	//Constructor privado que setea las dimensiones del tablero y crea la lista de elementos que jugarán
	private Escenario(){
		
		this.elementos = new ArrayList<Elemento>();
		this.listeners = new ArrayList<JuegoListener>();
		this.alto = Config.ESCENARIO_ALTO;
		this.ancho = Config.ESCENARIO_ANCHO;
		this.pausado = false;
	}
	
	/**
	 * Método que devuelve la única referencia al escenario para la partida.
	 * Para asegurar esto, se usa el patrón Singleton que limita la creación a un único objeto
	 * de esta clase. No se podrán crear objetos Escenario sino que, cuando se solicite un escenario,
	 * se lo crea si nunca se creó uno o devuelve la referencia al creado.
	 *   
	 * @return La única referencia al Escenario para la partida.
	 */
	public static Escenario getEscenario(){
		
		if (escenario == null){
			escenario = new Escenario();
		}
		return escenario;
	}
	
	/**
	 * 
	 */
	public void addJuegoListener(JuegoListener listener){
		listeners.add(listener);
	}
	/**
	 * Método que crea los elementos que intervendrán en el juego y administra la dinámica del mismo.
	 * Para esta etapa y, a fin de observar los cambios en consola, se agrega un "Pulse una tecla"
	 * por lo que podría crearse una excepción de Entrada/Salida que no se captura.
	 *  
	 * @throws IOException 
	 * 
	 */
	public void iniciarJuego() throws IOException{
		
        //boolean salir = false;
		
		crearElementos();
		while(true){
		
			if (!this.pausado){
			turnos();
			verficarChoques();
			depurarElementos();
			} 
			actualizar();
			 
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}		
	}


	private void actualizar() {
		for(JuegoListener listener: this.listeners){
	        listener.actualizarEstado(this.elementos);
	    }		
	}

	// Crea los elementos que intervendrán en el juego y los agrega a la lista de elementos
	private void crearElementos() {
		ZonaRescate zonaRescate = new ZonaRescate();
		elementos.add(zonaRescate);
		RobotSoldadoRyan robotRyan = new RobotSoldadoRyan(Config.EQUIPO_RYAN);
		elementos.add(robotRyan);
		RobotQuejoDido robotQueJodido = new RobotQuejoDido(Config.EQUIPO_QUEJODIDO);
		elementos.add(robotQueJodido);
		/*Robot robotRencoroso = new RobotRencoroso(Config.EQUIPO_QUEJODIDO);
		elementos.add(robotRencoroso);
		Satelite sateliteRencoroso = new Satelite(Config.EQUIPO_QUEJODIDO);
		elementos.add(sateliteRencoroso);
		//Refugio refugioRencoroso = new Refugio(Config.EQUIPO_QUEJODIDO);
		//elementos.add(refugioRencoroso);
		Satelite sateliteQueJodido = new Satelite(Config.EQUIPO_QUEJODIDO);
		elementos.add(sateliteQueJodido);
		//Refugio refugioQueJodido = new Refugio(Config.EQUIPO_QUEJODIDO);
		//elementos.add(refugioQueJodido);*/
	}
	
	// Muestra el estado de cada elemento en el escenario
	/*private void mostrar() {
		for(int i=0; i<this.elementos.size();i++){
			Elemento e1 = this.elementos.get(i);
			if (e1.estaVivo()){
				System.out.println(e1);
			}
		}
	}*/

	//Saca el elemento de la lista si no está vivo
	private void depurarElementos() {
		for(int i=0; i<this.elementos.size();i++){
			Elemento e1 = this.elementos.get(i);
			if (!e1.estaVivo()){
				this.elementos.remove(i);
			}
		}
	}

	//Toma dos elementos de la lista y verifica si chocaron usando un Rectangle
	private void verficarChoques() {
		for(int i=0; i<this.elementos.size();i++){
			Elemento e1 = this.elementos.get(i);
			Rectangle r1 = new Rectangle(e1.getPosicion().getX(), e1.getPosicion().getY(),
					e1.getTamanio().getAncho(), e1.getTamanio().getAlto());
			
		
			for(int j=i+1; j<this.elementos.size(); j++){
				Elemento e2 = this.elementos.get(j);
				Rectangle r2 = new Rectangle(e2.getPosicion().getX(), e2.getPosicion().getY(),
											e2.getTamanio().getAncho(), e2.getTamanio().getAlto());
				if (r1.intersects(r2)){
					e1.chocarContra(e2);
					e2.chocarContra(e1);
				}
			}			
		}
	}
	
	/**
	 * @return devuelve los elementos que se encuentran dentro de un polígono
	 */
	public ArrayList<Elemento> detectarElementos(Polygon sector){
		ArrayList<Elemento> elementosDetectados = new ArrayList<Elemento>();
		
		for(int i=0; i<this.elementos.size();i++){
			Elemento e = this.elementos.get(i);

			
			Rectangle r = Calculos.area(e);
			
			
			if (sector.intersects(r)){
				elementosDetectados.add(e);
			}
		}			
		return elementosDetectados;
		
	}

	//Da el turno de juego a cada elemento de la lista
	private void turnos() {
		for(int i=0; i<this.elementos.size(); i++){
			Elemento elemento = this.elementos.get(i);
			elemento.jugar();
		}
	}

	public void detener (){
		this.pausado = true;
	}
	public void reanudar(){
		this.pausado = false;
	}
	
	/**
	 * Método que agrega un nuevo elemento que participará de la partida
	 *  
	 * @param elemento
	 */
	public void addElemento(Elemento elemento){
		this.elementos.add(elemento);
	}
	
	/**
	 * Método que elimina un elemento "muerto" de la lista de elementos que participan del juego.
	 * 
	 * @param elemento
	 */
	public void removeElemento(Elemento elemento){
		this.elementos.remove(elemento);
	}
	
	/**
	 * Método que devuelve el ancho del escenario medido en píxeles.
	 * 
	 * @return El ancho del escenario (valor entero)
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * Método que devuelve el alto del escenario medido en píxeles.
	 * 
	 * @return El alto del escenario (valor entero)
	 */
	public int getAlto() {
		return alto;
	}
/**
 * Metodo para que el tablero pueda modificar posicion del rbot humano a partir de eventos de teclado
 * @return RobotHumano
 */
	public RobotHumano getRobotHumano(){
		//TODO: lanzar exepcion si no hay robot humano en la lista;
		RobotHumano robotHumano = null;
		if(this.elementos !=null){
			for(Elemento e: this.elementos){
				if (e instanceof RobotHumano){
					robotHumano = (RobotHumano)e; 
					break;
				}
			}
		}
		if(robotHumano == null){
			robotHumano = new RobotHumano();
			Escenario.getEscenario().addElemento(robotHumano);
		}
		return robotHumano;
		
	}
}