/**
 * Clase que implementa la munición disparada por un Robot o un Satélite
 *  
 * @author Krmpotic-Saiegg
 * @see Robot
 * @see Satelite
 *
 */
public class Municion extends Movible{
	
	private int danio;
	private Elemento elemento;
	
	/**
	 * Constructor
	 * 
	 */
	private Municion(Elemento objetivo){
		super();
		this.setPosicion(Calculos.Centro(this.elemento));
		this.setTamanio(new Tamanio(Config.MUNICION_ANCHO ,Config.MUNICION_ALTO));
		this.danio = Config.MUNICION_DANIO;
	}
	
	/**
	 * Constructor
	 * @param elemento : referencia al satélite o robot que efectuó el disparo
	 * @param direccion : indica el ángulo con el que deberá viajar
	 */
	public Municion(Elemento elemento, int direccion){
		this();
		this.elemento = elemento;
		this.setDireccion(direccion);
	}

	@Override
	/**
	 * Método que setea la nueva posición donde quedará ubicada la munición después de avanzar
	 */
	public void avanzar() {

		
		this.setPosicion(Calculos.getNewPosicion(this.getPosicion(), 
							this.getDireccion(), Config.MUNICION_VELOCIDAD));
		
		this.setPosicion(Calculos.getNewPosicion(this.getPosicion(), this.getDireccion(), Config.MUNICION_VELOCIDAD));

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
	 * Método que devuelve el daño que provoca la munición
	 * @return La cantidad de escudos que destruye
	 */
	public int getDanio() {
		return this.danio;
	}
	
	/**
	 * Método que devuelve el elemento que efectuó el disparo
	 * @return Un elemento Robot o Satélite
	 */
	public Elemento getElemento() {
		return this.elemento;
	}
}