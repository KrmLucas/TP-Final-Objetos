package Views;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import Robots.RobotHumano;

import java.awt.Component;
public class Sidebar extends Panel{
	
	private JTextField nivelVida;
	private JTextField rescatados;
	private JTextField energia;
	private JTextField municiones;
	private JTextField bombas;
	public Sidebar() {
		setForeground(new Color(192, 192, 192));
		
		setLayout(null);
		
		JLabel lblEquipoHumano = new JLabel("Equipo Humano");
		lblEquipoHumano.setBounds(54, 11, 108, 14);
		add(lblEquipoHumano);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(106, 27, 1, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 30, 172, 2);
		add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Rescatados");
		lblNewLabel.setBounds(20, 43, 76, 14);
		add(lblNewLabel);
		
		rescatados = new JTextField();
		rescatados.setBounds(106, 40, 86, 20);
		add(rescatados);
		rescatados.setColumns(10);
		
		JLabel lblNivelDeVida = new JLabel("Nivel de vida");
		lblNivelDeVida.setBounds(20, 68, 76, 14);
		add(lblNivelDeVida);
		
		nivelVida = new JTextField();
		nivelVida.setBounds(106, 65, 86, 20);
		add(nivelVida);
		nivelVida.setColumns(10);
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(20, 93, 46, 14);
		add(lblEnergia);
		
		energia = new JTextField();
		energia.setBounds(106, 90, 86, 20);
		add(energia);
		energia.setColumns(10);
		
		JLabel lblMuniciones = new JLabel("Municiones");
		lblMuniciones.setBounds(20, 118, 76, 14);
		add(lblMuniciones);
		
		municiones = new JTextField();
		municiones.setBounds(106, 116, 86, 20);
		add(municiones);
		municiones.setColumns(10);
		
		JLabel lblBombas = new JLabel("Bombas");
		lblBombas.setBounds(20, 143, 46, 14);
		add(lblBombas);
		
		bombas = new JTextField();
		bombas.setColumns(10);
		bombas.setBounds(106, 141, 86, 20);
		add(bombas);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblEquipoHumano, separator, separator_1, lblNewLabel, rescatados, lblNivelDeVida, nivelVida, lblEnergia, energia, lblMuniciones, municiones, lblBombas, bombas}));
		
	}
	public void inicializar(){
		this.setFocusable(true);
	}
	public void actualizar(RobotHumano robotHumano){
		rescatados.setText(Integer.toString(robotHumano.getRefugio().getPersonas()));
		nivelVida.setText(Integer.toString(robotHumano.getNivelEscudo()));
		energia.setText(Integer.toString(robotHumano.getNivelEnergia()));
		municiones.setText(Integer.toString(robotHumano.getCantidadMuniciones()));
		bombas.setText(Integer.toString(robotHumano.getCantidadBombas()));
	}
}
