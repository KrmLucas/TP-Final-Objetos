package Armamento;
import Configuracion.Calculos;
import Configuracion.Config;
import Core.Movible;
import Core.Tamanio;
import Elementos.Elemento;
import Elementos.Robot;

//CORREGIDO

/**
 * Clase que implementa la munici�n disparada por un Robot o un Sat�lite
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
	 * Constructor privado que setea los valores de la munici�n
	 * @param elemento : Elemento que efect�a el disparo (Robot o Sat�lite)
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
	 * @param elemento : referencia al sat�lite o robot que efectu� el disparo
	 * @param direccion : indica el �ngulo con el que deber� viajar
	 */
	public Municion(Elemento elemento, int direccion){
		this(elemento);
		//this.elemento = elemento; //TODO [CORRECCION] Esto deberia estar en el otro constructor
		this.setDireccion(direccion);
	}

	@Override
	/**
	 * M�todo que setea la nueva posici�n donde quedar� ubicada la munici�n despu�s de avanzar
	 */
	public void avanzar() {
		//TODO [CORRECCION] La l�gica basica de avanzar deberia estar en Movible.
		//TODO [CORRECCION] No deben utiliar ConfigOld.MUNICION_VELOCIDAD sino el atributo de esta municion
		this.setPosicion(Calculos.getNewPosicion(this.getPosicion(), 
							this.getDireccion(), this.velocidad));
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
	 * M�todo que devuelve el elemento que efectu� el disparo
	 * @return Un elemento Robot o Sat�lite
	 */
	public Elemento getElemento() {
		return this.elemento;
	}

	@Override
	public String toString() {
		return "Munici�n: " + super.toString();
	}
}