/**
 * 
 * @author Trabajo
 *
 */
public abstract class Movible extends Elemento implements HaceDanio{
	
	private int direccion;
	private int velocidad;
	private int danio;
	
	public Movible(){
		super();
		this.direccion = 0;
		this.velocidad = 0;
		this.danio = 0;
	}
	
	/**
	 * Cada elemento movible deber� implementar su forma de avanzar
	 */
	public abstract void avanzar();
	
	/**
	 * Todo elemento movible provoca un da�o a quien lo choca
	 * @param Valor en el que disminuir�n los escudos de los objetos que lo choquen 
	 */
	protected void setDanio(int danio){
		
		this.danio = danio;
		
	}

	/**
	 * M�todo que indica la direcci�n del elemento movible
	 * @return El valor del �ngulo que determina la direcci�n del elemento movible
	 */
	public int getDireccion() {
		return direccion;
	}

	/**
	 * M�todo que fija la direcci�n del elemento movible
	 * @param Valor del �ngulo
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	/**
	 * M�todo que indica la velocidad del elemento movible
	 * @return La velocidad del elemento movible
	 */
	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * M�todo que fija la velocidad del elemento movible
	 * @param Valor de la velocidad
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	/**
	 * M�todo que indica el nivel de da�o que provoca el elemento movible
	 * @return  El valor de nivel de escudos a descontar
	 */
	public int getDanio() {
		return this.danio;
	}
}