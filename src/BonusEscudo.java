
/**
 * Subclase de Bonus. Otorga cantidades suplementarias de energía al Robot o Satélite que logre tomarlo.
 * @author Krmpotic-Saiegg
 *
 */
public class BonusEscudo extends Bonus{

	private int escudo;
	
	public BonusEscudo (){
		super();
		this.escudo = 5;
	}
	
	/**
	 * El jugar del Bonus implica solamente restar su tiempoDeVida turno a turno hasta que llegue a 0, caso en el 
	 * que el objeto se destruye
	 */
	@Override
	public void jugar() {
		if(this.estaVivo())
			this.setTiempoDeVida(getTiempoDeVida()- 1);
		if (this.getTiempoDeVida() == 0)
			this.destruir();
	}
	/**
	 * El Bonus se destruye solo si choca contra un Robot, una Muncion o una Bomba. Si choca contra una Bomba se 
	 * destruye sin mas, si choca contra una Municion o un Robot se le asigna la "energia" al elemento correspondiente, 
	 * aunque esto ultimo se hace en los métodos chocarContra de dichas clases. 
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		
		if (elemento instanceof Municion | elemento instanceof Robot | elemento instanceof Bomba){
				this.destruir();
			}
	}

	public int getEscudo(){
		return escudo;
	}
	
	public String toString(){
		return "BonusEscudo\n "
				+ "Tiempo de vida: " + this.getTiempoDeVida() + "\n"
				+ "Posicion: " + this.getPosicion().toString(); 			
	}
}
