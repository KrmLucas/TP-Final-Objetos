import java.util.ArrayList;


public class Escenario {

	private ArrayList<Elemento> elementos;
	
	
	
	public void iniciarJuego(){
		
		crearElementos();
		
		while(true){
		 
			turnos();
			
			verficarChoques();
			
			depurarElementos();
		}
		
	}

	private void depurarElementos() {
		// TODO Auto-generated method stub
		
	}

	private void verficarChoques() {
		for(int i=0; i<this.elementos.size();i++){
			Elemento e1 = this.elementos.get(i);
			
			for(int j=i+1; j<this.elementos.size(); j++){
				Elemento e2 = this.elementos.get(j);
				
				
				// ver si se chocaron -> ver Rectangle
				
				e1.chocar(e2);
				e2.chocar(e1);
				
			}
			
			
			
		}
	
	}




	private void turnos() {
		for(int i=0; i<this.elementos.size(); i++){
			Elemento elemento = this.elementos.get(i);
			
			elemento.jugar();
		}
	}



	private void crearElementos() {

		this.elementos = new ArrayList<Elemento>();
	}
	
	
}
