/**
 * Clase que implementa la munici�n disparada por un Robot o un Sat�lite
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
	 * @param elemento : referencia al sat�lite o robot que efectu� el disparo
	 * @param direccion : indica el �ngulo con el que deber� viajar
	 */
	public Municion(Elemento elemento, int direccion){
		this();
		this.elemento = elemento;
		this.setDireccion(direccion);
	}

	@Override
	/**
	 * M�todo que setea la nueva posici�n donde quedar� ubicada la munici�n despu�s de avanzar
	 */
	public void avanzar() {

		
		this.setPosicion(Calculos.getNewPosicion(this.getPosicion(), 
							this.getDireccion(), Config.MUNICION_VELOCIDAD));
		
		this.setPosicion(Calculos.getNewPosicion(this.getPosicion(), this.getDireccion(), Config.MUNICION_VELOCIDAD));

	}

	@Override
	/**
	 * M�todo que implementa la acci�n a seguir por la munici�n: avanzar
	 */
	public void jugar() {
		this.avanzar();
	}

	@Override
	/**
	 * M�todo que implementa la destrucci�n de la munici�n por chocar contra alg�n elemento
	 */
	public void chocarContra(Elemento elemento) {
		this.destruir();
	}

	/**
	 * M�todo que devuelve el da�o que provoca la munici�n
	 * @return La cantidad de escudos que destruye
	 */
	public int getDanio() {
		return this.danio;
	}
	
	/**
	 * M�todo que devuelve el elemento que efectu� el disparo
	 * @return Un elemento Robot o Sat�lite
	 */
	public Elemento getElemento() {
		return this.elemento;
	}
}