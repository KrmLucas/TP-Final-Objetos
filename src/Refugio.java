
public class Refugio extends Elemento{
	
	private int personas; 
	
	public Refugio (){
		//TODO: ver como se resuelve que no se choquen los refugios de los diferentes equipos
		super(); 
		this.personas = 0;
	}

	public void quitarPersona(){
		this.personas--;
	}
	
	public void salvarPersona(){
		this.personas++;
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
		// TODO Auto-generated method stub
		
	}

}
