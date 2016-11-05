package Views;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import Core.Movible;
import Elementos.Elemento;
import Elementos.Robot;
import Robots.RobotHumano;
import Robots.RobotQuejoDido;
import Robots.RobotRencoroso;
import Robots.RobotSoldadoRyan;

public class Tablero extends Canvas implements KeyListener{
	private HashMap<String, BufferedImage> imagenes;
	 
	private ArrayList<Elemento> elementos;
	private RobotHumano robotHumano; 
	
	public ArrayList<Elemento> getElementos() {
		return this.elementos;
	}

	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}
	
	public void setRobotHumano(RobotHumano robotHumano){
		this.robotHumano = robotHumano; 
	}

	
	public Tablero(){
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		mostrar();
	}
	private Graphics paintPolygon(){
		return (Graphics) this.getGraphics();
	}
	
  
	private void limpiar(){
		this.getG2D().drawImage(getFondo("fondo"), 0, 0, getWidth(), getHeight(), null);
	}
	
	public void mostrar(){
		
		limpiar();
		
		if (this.elementos != null) {
			for(Elemento e : elementos){
				BufferedImage imagenElemento = getImagen(e);
				if (e instanceof Movible){
					Movible m = (Movible) e; 
					imagenElemento = rotar(imagenElemento, m.getDireccion());
				}
				this.getG2D().drawImage(imagenElemento, e.getPosicion().getX(), e.getPosicion().getY(), null);
				if(e instanceof Robot){
					Polygon poligono = ((Robot) e).getRadar().getZonaDeteccion();
					this.paintPolygon().drawPolyline(poligono.xpoints, poligono.ypoints, poligono.npoints);	
				}
			}
		}
		   
		//Muestra el buffer sobre el cual se estuvo dibujando.
		this.getBufferStrategy().show();
	}
 
	private Graphics2D getG2D(){
		
		if (this.getBufferStrategy() == null)
			return (Graphics2D) this.getGraphics();
		else 
			return (Graphics2D)this.getBufferStrategy().getDrawGraphics();		
	}
		 
	private BufferedImage getFondo(String key){
		if (imagenes == null)
			imagenes = new HashMap<String, BufferedImage>();
		
		BufferedImage img = imagenes.get(key);

		if (img == null) {
			img = cargarImagen(System.getProperty("user.dir") + File.separator + "img" 
								+ File.separator + key + ".png");
		}
		return img;
	}
	
	private BufferedImage getImagen(Elemento e){

		String key = e.getClass().getSimpleName();
		if (imagenes == null)
			imagenes = new HashMap<String, BufferedImage>();
		
		BufferedImage img = imagenes.get(key);

		if (img == null) {
			img = cargarImagen(System.getProperty("user.dir") + File.separator + "img" 
								+ File.separator + key + ".png");

			if (img != null){
				
				//img = cambiarTamanio(img, e);				
				imagenes.put(key, img);
			}
		}
		
		return img;
	}
	
	
	private BufferedImage cargarImagen(String fileName){
		try {
			return ImageIO.read(new File(fileName));
		} catch (Exception e) {
			System.out.println("No se encontro la imagen " + fileName);

			return null;
		}
		
	}
	
	private BufferedImage cambiarTamanio(BufferedImage img, Elemento e){

		int ancho = e.getTamanio().getAncho();
		int alto = e.getTamanio().getAlto();
		
		BufferedImage newImage = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);

		Graphics g = newImage.createGraphics();
		g.drawImage(img, 0, 0, ancho, alto, null);
		g.dispose();
		
		return newImage;
	}

	 
	public void inicializar() {
		
		this.setFocusable(true);
		//Crea dos buffers para dibujar.
		this.createBufferStrategy(2);
		
		this.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int paso = 5;

		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			this.robotHumano.getPosicion().setY(
					this.robotHumano.getPosicion().getY() + paso);
			this.robotHumano.setDireccion(270);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			this.robotHumano.getPosicion().setY(
					this.robotHumano.getPosicion().getY() - paso);
			this.robotHumano.setDireccion(90);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			this.robotHumano.getPosicion().setX(
					this.robotHumano.getPosicion().getX() + paso);
			this.robotHumano.setDireccion(90);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			this.robotHumano.getPosicion().setX(
					this.robotHumano.getPosicion().getX() - paso);
			this.robotHumano.setDireccion(180);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			this.robotHumano.disparar();
		}
		if(e.getKeyCode() == KeyEvent.VK_1){
			this.robotHumano.lanzarBomba();
		}
		
		mostrar();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		//System.out.println("keyTyped - " + posicionRobot.x);
	}
	
	
	
	public BufferedImage rotar(BufferedImage image, int angulo){
		Dimension dim = calcularDimension(image, angulo);

		int w2 = (int)dim.getWidth();
		int h2 = (int)dim.getHeight();		

		int w = image.getWidth();
		int h = image.getHeight();		

		BufferedImage image2 = new BufferedImage(w2, h2, BufferedImage.TYPE_INT_RGB);

		Graphics2D g2d = (Graphics2D)image2.getGraphics();

		double x = (w2- w) / 2.0;
		double y = (h2-h) / 2.0;

		AffineTransform at = AffineTransform.getTranslateInstance(x, y);
		at.rotate(Math.toRadians(angulo), w/2, h/2);

		g2d.drawRenderedImage(image, at);

		return image2;
	}

	private Dimension calcularDimension(BufferedImage img, int angulo){
		double w = (double)img.getWidth();
		double h = (double)img.getHeight();

		double x1 = Math.abs(w * Math.cos(Math.toRadians(angulo))); 
		double x2 = Math.abs(h * Math.sin(Math.toRadians(angulo)));

		double y1 = Math.abs(h * Math.cos(Math.toRadians(angulo))); 
		double y2 = Math.abs(w * Math.sin(Math.toRadians(angulo)));

		return new Dimension((int)(x1+x2), (int)(y1+y2));
	}
}
