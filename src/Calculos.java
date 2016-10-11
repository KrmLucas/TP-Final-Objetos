class Calculos {
	
	public static final Posicion Centro(Elemento elemento){
		
		int x = elemento.getTamanio().getAncho()/2+elemento.getPosicion().getX();
		int y = elemento.getTamanio().getAlto()/2+elemento.getPosicion().getY();
		
		return new Posicion(x, y);		
	}
	
	public static final Posicion getNewPosicion(Posicion posicion, int direccion, int distancia){
		
		int px = posicion.getX() + (int)Math.round((double)distancia * Math.cos(Math.toRadians(direccion))); 
		int py = posicion.getY() + (int)Math.round((double)distancia * Math.sin(Math.toRadians(direccion))); 
		
		return new Posicion(px, py);
	}

}
