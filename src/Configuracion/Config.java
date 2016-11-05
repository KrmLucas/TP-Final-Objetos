package Configuracion;
public class Config {
	
	// Escenario
	public static final int ESCENARIO_ANCHO = 900;
	public static final int ESCENARIO_ALTO = 600;
	
	// Robot
	public static final int ROBOT_ANCHO = 40;
	public static final int ROBOT_ALTO = 40;
	public static final int ROBOT_ESCUDOS = 25;
	public static final int ROBOT_ENERGIA = 100;
	public static final int ROBOT_VELOCIDAD = Config.ROBOT_ANCHO/2;
	public static final int ROBOT_MUNICIONES = 100;
	public static final int ROBOT_BOMBAS = 50;
	public static final int ROBOT_DANIO = 5;
	
	// Satelite
	public static final int SATELITE_ANCHO = 60;
	public static final int SATELITE_ALTO = 60;
	public static final int SATELITE_ESCUDOS = 25;
		
	// Refugio
	public static final int REFUGIO_ANCHO = 60;
	public static final int REFUGIO_ALTO = 60;
	public static final int REFUGIO_DANIO = 5;

	// ZonaRescate
	public static final int ZONA_ANCHO = 60;
	public static final int ZONA_ALTO = 60;
	public static final int ZONA_CANT_PERS = 100;
	
	// Bonus
	public static final int BONUS_ANCHO = 20;
	public static final int BONUS_ALTO = 20;
	public static final int BONUS_ESCUDO = 5;
	public static final int BONUS_ENERGIA = 5;
	public static final int BONUS_VIDA = 50;

	// Municion
	public static final int MUNICION_ANCHO = 4;
	public static final int MUNICION_ALTO = 8;
	public static final int MUNICION_VELOCIDAD = Config.ROBOT_ANCHO*2;
	public static final int MUNICION_DANIO = 1;
		
	// Bomba
	public static final int BOMBA_ANCHO = 20;
	public static final int BOMBA_ALTO = 20;
	public static final int BOMBA_VELOCIDAD_INICIAL = Config.ROBOT_ANCHO*3;
	public static final int BOMBA_DANIO = 5;
	public static final int BOMBA_ONDA = 10;
		
	// Radar
	public static final int RADAR_ALCANCE_MAX = 200;
	public static final int RADAR_ALCANCE_MIN = 20;
	public static final int RADAR_ANGULO_APERTURA = 40;
	public static final int RADAR_DIRECCION = 40;
	
	//Equipo
	public static final String EQUIPO_RYAN = "RYAN";
	public static final String EQUIPO_HUMANO = "HUMANO";
	public static final String EQUIPO_RENCOROSO = "RENCOROSO";
	public static final String EQUIPO_QUEJODIDO = "QUEJODIDO";
}