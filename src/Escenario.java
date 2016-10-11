
import java.util.ArrayList;

public class Escenario {

	private ArrayList<Elemento> elementos;
	private static Escenario escenario; 
	public double ancho;
	public double alto;

	
	public static Escenario getEscenario(){
		if (escenario == null){
			escenario = new Escenario(100, 100);
		}
		return escenario;
	}

	private Escenario (double alto, double ancho){
		this.alto = alto; 
		this.ancho = ancho;
	}
	
	// Metodos get y set
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}

	public double getAncho() {
		return ancho;
	}

	public double getAlto() {
		return alto;
	}
}



/*public void iniciarJuego(){
	
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
			
			e1.chocarContra(e2);
			e2.chocarContra(e1);	
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
}*/ 

