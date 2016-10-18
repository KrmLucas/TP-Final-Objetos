public class Config {
	
	// Escenario
	public static final int ESCENARIO_ANCHO = 600;
	public static final int ESCENARIO_ALTO = 400;
	
	// Robot
	public static final int ROBOT_ANCHO = 20;
	public static final int ROBOT_ALTO = 20;
	public static final int ROBOT_ESCUDOS = 25;
	public static final int ROBOT_ENERGIA = 1000;
	public static final int ROBOT_VELOCIDAD = Config.ROBOT_ANCHO/2;
	
	// Satelite
	public static final int SATELITE_ANCHO = 30;
	public static final int SATELITE_ALTO = 30;
	public static final int SATELITE_ESCUDOS = 25;
		
	// Refugio
	public static final int REFUGIO_ANCHO = 30;
	public static final int REFUGIO_ALTO = 30;
	public static final int REFUGIO_DANIO = 5;

	// ZonaRescate
	public static final int ZONA_ANCHO = 30;
	public static final int ZONA_ALTO = 30;
	public static final int ZONA_CANT_PERS = 100;
	
	// Bonus
	public static final int BONUS_ANCHO = 10;
	public static final int BONUS_ALTO = 10;

	// Municion
	public static final int MUNICION_ANCHO = 2;
	public static final int MUNICION_ALTO = 4;
	public static final int MUNICION_VELOCIDAD = Config.ROBOT_ANCHO*2;
	public static final int MUNICION_DANIO = 1;
		
	// Bomba
	public static final int BOMBA_ANCHO = 10;
	public static final int BOMBA_ALTO = 10;
	public static final int BOMBA_VELOCIDAD_INICIAL = Config.ROBOT_ANCHO*3;
	public static final int BOMBA_DANIO = 5;
		
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