package Core;
import Configuracion.Calculos;
import Elementos.Elemento;
import Interfaces.HaceDanio;

//CORREGIDO

/**
 * Clase abstracta que generaliza el comportamiento de los elementos movibles que participan del juego
 * @author Krmpotic-Saiegg
 *
 */
public abstract class Movible extends Elemento implements HaceDanio{
	
	private int direccion;
	private int velocidad;
	private int danio; //TODO [CORRECCION] Danio?! para que se utiliza?
	// Es el danio que provoca todo elemento movible al chocar. Necesario para la implementación de 
	// la interface HaceDanio
	
	public Movible(){
		super();
		this.direccion = 10;
		this.velocidad = 1;
		this.danio = 1;
	}
	
	/**
	 * Cada elemento movible deberá implementar su forma de avanzar
	 */
	public void avanzar(){
		//TODO [CORRECCION] El movible deberia saber avanzar
		this.setPosicion(Calculos.getNewPosicion(this.getPosicion(), 
				this.getDireccion(), this.velocidad));
	}
	
	/**
	 * Todo elemento movible provoca un daño a quien lo choca
	 * @param Valor en el que disminuirán los escudos de los objetos que lo choquen 
	 */
	protected void setDanio(int danio){
		
		this.danio = danio;
		
	}

	/**
	 * Método que indica la dirección del elemento movible
	 * @return El valor del ángulo que determina la dirección del elemento movible
	 */
	public int getDireccion() {
		return direccion;
	}

	/**
	 * Método que fija la dirección del elemento movible
	 * @param Valor del ángulo
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	/**
	 * Método que indica la velocidad del elemento movible
	 * @return La velocidad del elemento movible
	 */
	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * Método que fija la velocidad del elemento movible
	 * @param Valor de la velocidad
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	/**
	 * Método que indica el nivel de daño que provoca el elemento movible
	 * @return  El valor de nivel de escudos a descontar
	 */
	public int getDanio() {
		return this.danio;
	}
}