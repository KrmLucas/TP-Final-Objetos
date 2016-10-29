import java.io.IOException;

/**
 * 
 * Clase que permite probar el avance de la programación del juego.
 * Crea la referencia al escenario de la partida y le pasa el control.
 * 
 * @author Krmpotic-Saiegg
 *
 */
public class Prueba {
	public static void main(String[] args) throws IOException {
		Escenario escenario = Escenario.getEscenario();
		escenario.iniciarJuego();
	}
}
