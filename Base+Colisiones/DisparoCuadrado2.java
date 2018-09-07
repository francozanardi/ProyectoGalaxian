package Proyecto;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class DisparoCuadrado2 extends Disparo{
	
	public DisparoCuadrado2(Personaje lanzador) {
		panel = new JPanel();
		Rectangle rPos = lanzador.obtenerPanel().getBounds();
		pos = new Posicion((int)(rPos.getMinX() + ((rPos.getMaxX() - rPos.getMinX())/2)),
							(int)rPos.getMinY() + 1);
		tamano = new Size(5, 5);
		fuerza = 1;
		
		panel.setOpaque(true);
		panel.setBackground(new Color(0, 0, 254));
		panel.setBounds(pos.getX(), pos.getY(), tamano.getWidth(), tamano.getHeight());
		panel.setVisible(true);
		
		this.lanzador = lanzador;
	}
	
	public void avanzar() {
		pos.setY(pos.getY()-5);
		actualizarPosicion();
	}
}