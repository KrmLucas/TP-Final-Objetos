
import java.util.Random;

public class Bonus extends Elemento {

	private int tiempoDeVida;
	static Random rand = new Random();

	//TODO: limitar el random en funcion de las dimensiones del escenario
	public Bonus (){
		super (rand.nextInt(), rand.nextInt(), 5, 5); //posicion aleatoria y tamaño by default
		this.tiempoDeVida = 5000; //son 5 segundos. Es para poder hacer un delay quizas con thread.sleep() o wait()
	}

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
