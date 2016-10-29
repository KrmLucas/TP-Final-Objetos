//CORREGIDO
/**
 * Clase que implementa el comportamiento de las bombas que serán "lanzadas" por un robot
 * 
 * @author Krmpotic-Saiegg
 *
 */
public class Bomba extends Movible{
	
	private int velocidad = Config.BOMBA_VELOCIDAD_INICIAL;

	//Constructor privado que realiza los seteos por defecto
	private Bomba(){
		super();
		this.setTamanio(new Tamanio(Config.BOMBA_ANCHO, Config.BOMBA_ALTO));
		this.setDanio(Config.BOMBA_DANIO);	
	}
	
	/**
	 * Constructor que crea la bomba que será lanzada por algún robot 
	 * @param elemento  : referencia al robot que lanzó la bomba
	 * @param direccion : dirección en la que es lanzada la bomba
	 */
	public Bomba(Robot robot, int direccion){
		this();
		this.setPosicion(robot.getPosicion());
		this.setDireccion(direccion);
	}
	
	//La explosión implica el aumento de tamaño de la bomba: la onda expansiva
	private void aumentarTamanio() {
		Tamanio tamanio = new Tamanio(this.getTamanio().getAncho()*(Config.BOMBA_ONDA+1), 
										this.getTamanio().getAlto()*(Config.BOMBA_ONDA+1));
		Posicion posicion = new Posicion(this.getPosicion().getX()-Config.BOMBA_ONDA, 
										this.getPosicion().getY()-Config.BOMBA_ONDA);
		this.setTamanio(tamanio);
		this.setPosicion(posicion);
	}

	/**
	 * Método que destruye la bomba, generando una onda expansiva que afectará a los elementos que
	 * se encuentren en un radio determinado.
	 */
	public void explotar() {
		this.aumentarTamanio();
		this.destruir();
	}
	
	/*@Override
	public void avanzar() {
		//TODO [CORRECCION] Este metodo deberia estar implementado en Movible
		this.setPosicion(Calculos.getNewPosicion(this.getPosicion(), 
				this.getDireccion(), velocidad));	
	}*/ 
	//Se ELIMINARÁ este código después de la reentrega

	@Override
	/**
	 * Método sobreescrito que hace avanzar la bomba con velocidad decreciente y
	 * la hace explotar cuando se detiene.
	 */
	public void jugar() {
		if (velocidad == 0){
			this.explotar();
		} else {
			this.avanzar();
			this.velocidad--;
		}
	}

	@Override
	/**
	 * Método que implementa el comportamiento de la bomba al chocar: se destruye.
	 */
	public void chocarContra(Elemento elemento) {
		this.destruir();	
	}

	@Override
	/**
	 * Método sobreescrito que setea el mensaje que dará la bomba.
	 */
	public String toString() {
		return "Bomba: " + super.toString() + ", Velocidad=" + velocidad;
	}
}