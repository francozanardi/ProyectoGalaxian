package Proyecto;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ArmaCuadrado extends Arma {

	
	public ArmaCuadrado() {
		panel = new JPanel();
		tamano = new Size(0, 0);
		this.pos = new Posicion(0,0); // pos
		
		panel.setOpaque(true);
		panel.setBackground(new Color(0, 247, 0));
		panel.setBounds(pos.getX(), pos.getY(), tamano.getWidth(), tamano.getHeight());
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setVisible(true);
	}
	
	
	public Disparo lanzarDisparo(Personaje p) {
		return new DisparoCuadrado(p);
	}

}
