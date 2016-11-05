package Armamento;
import Configuracion.Calculos;
import Configuracion.Config;
import Core.Movible;
import Core.Tamanio;
import Elementos.Elemento;
import Elementos.Robot;

//CORREGIDO

/**
 * Clase que implementa la munición disparada por un Robot o un Satélite
 *  
 * @author Krmpotic-Saiegg
 * @see Robot
 * @see SateliteOld
 *
 */
public class Municion extends Movible{
	
	private Elemento elemento;
	private int velocidad;
	
	/**
	 * Constructor privado que setea los valores de la munición
	 * @param elemento : Elemento que efectúa el disparo (Robot o Satélite)
	 */
	private Municion(Elemento elemento){
		super();
		
		//TODO [CORRECCION] Falta guardar la referencia del elemento "padre"
		//this.setPosicion(Calculos.Centro(this.elemento));
		this.setPosicion(elemento.getPosicion());
		this.setTamanio(new Tamanio(Config.MUNICION_ANCHO ,Config.MUNICION_ALTO));
		this.setDanio(Config.MUNICION_DANIO);
		this.velocidad = Config.MUNICION_VELOCIDAD;
		this.elemento = elemento;
	}
	
	/**
	 * Constructor
	 * @param elemento : referencia al satélite o robot que efectuó el disparo
	 * @param direccion : indica el ángulo con el que deberá viajar
	 */
	public Municion(Elemento elemento, int direccion){
		this(elemento);
		//this.elemento = elemento; //TODO [CORRECCION] Esto deberia estar en el otro constructor
		this.setDireccion(direccion);
	}

	@Override
	/**
	 * Método que setea la nueva posición donde quedará ubicada la munición después de avanzar
	 */
	public void avanzar() {
		//TODO [CORRECCION] La lógica basica de avanzar deberia estar en Movible.
		//TODO [CORRECCION] No deben utiliar ConfigOld.MUNICION_VELOCIDAD sino el atributo de esta municion
		this.setPosicion(Calculos.getNewPosicion(this.getPosicion(), 
							this.getDireccion(), this.velocidad));
	}

	@Override
	/**
	 * Método que implementa la acción a seguir por la munición: avanzar
	 */
	public void jugar() {
		this.avanzar();
	}

	@Override
	/**
	 * Método que implementa la destrucción de la munición por chocar contra algún elemento
	 */
	public void chocarContra(Elemento elemento) {
		this.destruir();
	}

	/**
	 * Método que devuelve el elemento que efectuó el disparo
	 * @return Un elemento Robot o Satélite
	 */
	public Elemento getElemento() {
		return this.elemento;
	}

	@Override
	public String toString() {
		return "Munición: " + super.toString();
	}
}