/**
 * Clase abstracta de la que heredar�n todos los objetos que participen en el escenario (salvo el Radar)
 * Posee tama�o y posici�n
 *  
 * @author Krmpotic-Saiegg
 * 
 * @see Tamanio
 * @see Posicion
 * {@link Tamanio#getAlto()}
 */
public abstract class Elemento {
	
	private Posicion posicion;
	private Tamanio tamanio;
	private boolean vivo = true;
		
	/**
	 * Cada elemento debe implementar este m�todo donde definir� qu� acci�n o acciones realizar
	 * cuando le toque su turno para jugar 
	 */
	public abstract void jugar();
	
	/**
	 * M�todo que destruye el elemento indicando que NO est� vivo
	 */
	public void destruir(){
		this.vivo = false;
	}
	
	/**
	 * M�todo que indica si el elemento est� vivo o no 
	 * @return true or false
	 */
	public boolean estaVivo(){
		return this.vivo;
	}
	
	/**
	 * Cada elemento debe implementar este m�todo donde definir� qu� acci�n o acciones realizar
	 * cuando choque contra otro elemento o la pared del escenario
	 * @param elemento
	 */
	public abstract void chocarContra(Elemento elemento);

	/**
	 * M�todo que devuelve la posici�n del elemento en el escenario 
	 * @return Un objeto Posicion
	 * @see Posicion
	 */
	public Posicion getPosicion() {
		return posicion;
	}
	
	/**
	 * M�todo utilizado para fijar la posici�n de un elemento
	 * @param Un objeto Posicion
	 * @see Posicion
	 */
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	/**
	 * M�todo que devuelve el tama�o del elemento 
	 * @return Un objeto Tamanio
	 * @see Tamanio
	 */
	public Tamanio getTamanio() {
		return tamanio;
	}

	/**
	 * M�todo utilizado para fijar el tama�o de un elemento
	 * @param Un objeto Tamanio
	 * @see Tamanio
	 */
	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}
}