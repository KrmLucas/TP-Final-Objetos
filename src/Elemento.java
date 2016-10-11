/**
 * Clase abstracta de la que heredarán todos los objetos que participen en el escenario (salvo el Radar)
 * Posee tamaño y posición
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
	 * Cada elemento debe implementar este método donde definirá qué acción o acciones realizar
	 * cuando le toque su turno para jugar 
	 */
	public abstract void jugar();
	
	/**
	 * Método que destruye el elemento indicando que NO está vivo
	 */
	public void destruir(){
		this.vivo = false;
	}
	
	/**
	 * Método que indica si el elemento está vivo o no 
	 * @return true or false
	 */
	public boolean estaVivo(){
		return this.vivo;
	}
	
	/**
	 * Cada elemento debe implementar este método donde definirá qué acción o acciones realizar
	 * cuando choque contra otro elemento o la pared del escenario
	 * @param elemento
	 */
	public abstract void chocarContra(Elemento elemento);

	/**
	 * Método que devuelve la posición del elemento en el escenario 
	 * @return Un objeto Posicion
	 * @see Posicion
	 */
	public Posicion getPosicion() {
		return posicion;
	}
	
	/**
	 * Método utilizado para fijar la posición de un elemento
	 * @param Un objeto Posicion
	 * @see Posicion
	 */
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	/**
	 * Método que devuelve el tamaño del elemento 
	 * @return Un objeto Tamanio
	 * @see Tamanio
	 */
	public Tamanio getTamanio() {
		return tamanio;
	}

	/**
	 * Método utilizado para fijar el tamaño de un elemento
	 * @param Un objeto Tamanio
	 * @see Tamanio
	 */
	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}
}