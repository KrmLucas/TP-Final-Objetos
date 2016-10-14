
public class BonusEscudo extends Bonus{

	private int escudo;
	
	public BonusEscudo (){
		super();
		this.escudo = 5;
	}
	
	@Override
	public void jugar() {
		if(this.estaVivo())
			this.setTiempoDeVida(getTiempoDeVida()- 1);
		if (this.getTiempoDeVida() == 0)
			this.destruir();
	}
	
	@Override
	public void chocarContra(Elemento elemento) {
		
		if (elemento instanceof Municion | elemento instanceof Robot | elemento instanceof Bomba){
				this.destruir();
			}
	}

	public int getEscudo(){
		return escudo;
	}
}
