
public class Refugio extends Elemento{
	
	private int personas; 
	
	public Refugio (){
		super(); 
		this.personas = 0;
	}

	public void quitarPersona(){
		this.setPersonas(this.getPersonas() - 1);
	}
	
	public void salvarPersona(){
		this.setPersonas(this.getPersonas() + 1);
	}
	
	//TODO: ver que se hace con estos métodos, como hacemos para que no se los pueda llamar desde refugio
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
		if (elemento instanceof Robot){
			//Si trajo una persona sumarla a la lista de refugiados
		}
		
	}
	public int getPersonas(){
		return this.personas;
	}
	
	public void setPersonas(int personas){
		this.personas = personas;
	}
	public String toString(){
		return "Refugio\n "
				+ "Cantidad de personas rescatadas: " + this.getPersonas(); 			
	}

}
