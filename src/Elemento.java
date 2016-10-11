

public abstract class Elemento {

	private Posicion posicion;
	private Tamanio tamanio;
	
	
	public abstract void jugar();
	
	public abstract void destruir();
	
	public abstract void chocarContra(Elemento elemento);
	
	public abstract boolean estaVivo();
	
	/**Constructor*/
	public Elemento (double x, double y, double alto, double ancho){

  		this.posicion = new Posicion(x, y);
  		this.tamanio = new Tamanio(alto, ancho);
		
	}
	

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	
}
