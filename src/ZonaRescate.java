
public class ZonaRescate extends Elemento{

	private int personas;
	
	public ZonaRescate() {
		super (5, 5, 5, 5);
		this.personas = 10;
	}
	
	public void rescatarPersona(){
		this.setPersonas(this.getPersonas()-1);
	}
	
	public int getPersonas() {
		return personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}

	//TODO: idem Refugio
	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destruir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContra(Elemento elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void estaVivo() {
		// TODO Auto-generated method stub
		
	}

}
