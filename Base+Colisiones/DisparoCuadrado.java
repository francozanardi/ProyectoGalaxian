package Proyecto;

import java.awt.Color;

import javax.swing.JPanel;

public class DisparoCuadrado extends Disparo{
	
	public DisparoCuadrado(Personaje lanzador) {
		panel = new JPanel();
		pos = new Posicion((int)lanzador.obtenerPanel().getBounds().getMaxX() + 1, (int)lanzador.obtenerPanel().getBounds().getMaxY() + 1);
		tamano = new Size(5, 5);
		fuerza = 1;
		
		panel.setOpaque(true);
		panel.setBackground(new Color(254, 0,0));
		panel.setBounds(pos.getX(), pos.getY(), tamano.getWidth(), tamano.getHeight());
		panel.setVisible(true);
		
		this.lanzador = lanzador;
	}
}
