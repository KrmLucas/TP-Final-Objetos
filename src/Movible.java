public abstract class Movible extends Elemento{
	
	private int direccion;
	private int velocidad;
	
	public Movible(){
		super();
		this.direccion = 0;
		this.velocidad = 0;
	}
	/**
	 * Cada elemento movible deberá implementar su forma de avanzar
	 */
	public abstract void avanzar();

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
}