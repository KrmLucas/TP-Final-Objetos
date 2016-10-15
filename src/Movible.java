public abstract class Movible extends Elemento{
	
	private int direccion;
	private int velocidad;
	
	public Movible(){
		super();
		this.direccion = 0;
		this.velocidad = 0;
	}
	/**
	 * Cada elemento movible deber� implementar su forma de avanzar
	 */
	public abstract void avanzar();

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
}