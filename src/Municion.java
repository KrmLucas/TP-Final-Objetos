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
	 * @param elemento : referencia al elemento que efectu� el disparo (Robot o Satelite)
	 * @param direccion : indica el �ngulo con el que deber� viajar
	 * 
	 */
	public Municion(){
		Tamanio tamanio = new Tamanio(Config.MUNICION_ANCHO ,Config.MUNICION_ALTO);
		
		this.elemento = elemento;
		this.setPosicion(Calculos.Centro(this.elemento));
		this.setTamanio(tamanio);
		this.danio = Config.MUNICION_DANIO;
		//this.setDireccion(direccion);
	}

	@Override
	/**
	 * M�todo que permite 
	 */
	public void avanzar() {
		
		this.setPosicion(Calculos.getNewPosicion(this.getPosicion(), 
							this.getDireccion(), Config.MUNICION_VELOCIDAD));
		
	}

	@Override
	public void jugar() {
		
		this.avanzar();
		
	}

	@Override
	public void chocarContra(Elemento elemento) {
		// TODO Auto-generated method stub
		
	}

	public int getDanio() {
		return this.danio;
	}
	
	public Elemento getElemento() {
		return this.elemento;
	}
}
