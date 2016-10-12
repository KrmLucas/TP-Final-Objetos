
public class BonusBateria extends Bonus {

	private int energia;
	
	public BonusBateria (){
		super();
		this.energia = 5;
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
		
		if (elemento instanceof Municion | elemento instanceof Robot){
			this.destruir();
		}
	}
	
	public int getEnergia(){
		return energia;
	}
	
}
