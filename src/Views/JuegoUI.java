package Views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Core.Escenario;
import Elementos.Elemento;
import Interfaces.JuegoListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class JuegoUI extends JFrame implements JuegoListener{
	
	private Tablero tablero;
	private Sidebar sidebar;
	private Clip clip;
	
	public JuegoUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tablero = new Tablero();
		tablero.setBackground(Color.black);
		tablero.setForeground(Color.red);
		sidebar = new Sidebar();
		sidebar.setVisible(true);
		Container c = this.getContentPane();

		c.add(tablero, BorderLayout.CENTER);
		c.add(sidebar, BorderLayout.EAST);
		
		sidebar.setSize(200,  400);
		
		this.setSize(Escenario.getEscenario().getAncho() + this.sidebar.getWidth(),
					Escenario.getEscenario().getAlto());
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenu mntmStart = new JMenu("Start");
		mntmStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					iniciar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		menuBar.add(mntmStart);
		
		JMenu mntmStop = new JMenu("Stop");
		mntmStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escenario.getEscenario().detener();
			}
		});
		menuBar.add(mntmStop);
		
		JMenu mntmClose = new JMenu("Reanudar");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escenario.getEscenario().reanudar();
			}
		});
		menuBar.add(mntmClose);
		c.add(menuBar, BorderLayout.NORTH);

		this.setVisible(true);
		tablero.inicializar();
		Escenario.getEscenario().addJuegoListener(this);
		
	}
	public void iniciar() throws IOException{
		tablero.setRobotHumano(Escenario.getEscenario().getRobotHumano());
		//Escenario.getEscenario().iniciarJuego();
		/*try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(System.getProperty("user.dir") + File.separator + "img" 
					+ File.separator + "BackInBlack.wav")));
			clip.start();
		} catch (Exception e) {
			System.out.println("Error al leer el archivo");
		}*/
	}
	@Override
	public void actualizarEstado(ArrayList<Elemento> elementos) {
		this.tablero.setElementos(elementos);
		this.tablero.mostrar();
		this.sidebar.actualizar(Escenario.getEscenario().getRobotHumano());
	}
}
