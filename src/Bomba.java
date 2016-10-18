
public class Bomba extends Movible{
	
	private int velocidad = ConfigOld.BOMBA_VELOCIDAD_INICIAL;

	private Bomba(){
		super();
		this.setTamanio(new Tamanio(ConfigOld.BOMBA_ANCHO, ConfigOld.BOMBA_ALTO));
		this.setDanio(ConfigOld.BOMBA_DANIO);	
	}
	
	public Bomba(Elemento elemento, int direccion){
		this();
		this.setPosicion(elemento.getPosicion());
		this.setDireccion(direccion);
	}
	
	private void aumentarTamanio() {
		Tamanio tamanio = new Tamanio(this.getTamanio().getAncho()*(ConfigOld.BOMBA_ONDA+1), this.getTamanio().getAlto()*(ConfigOld.BOMBA_ONDA+1));
		Posicion posicion = new Posicion(this.getPosicion().getX()-ConfigOld.BOMBA_ONDA, this.getPosicion().getY()-ConfigOld.BOMBA_ONDA);
		this.setTamanio(tamanio);
		this.setPosicion(posicion);
	}

	public void explotar() {
		this.aumentarTamanio();
		this.destruir();
	}
	
	@Override
	public void avanzar() {
		this.setPosicion(Calculos.getNewPosicion(this.getPosicion(), 
				this.getDireccion(), velocidad));	
	}

	@Override
	public void jugar() {
		if (velocidad == 0){
			this.explotar();
		} else {
			this.avanzar();
			this.velocidad--;
		}
	}

	@Override
	public void chocarContra(Elemento elemento) {
		this.destruir();	
	}

	@Override
	public String toString() {
		return "Bomba: Posición=" + super.toString() + ", Velocidad=" + velocidad;
	}
}