package Grafica;

import java.awt.Color;
import javax.swing.JPanel;



public class FondoEstatico extends Fondo
{
	public FondoEstatico( JPanel panelDelJuego )
	{	
		super( panelDelJuego );
		
		canvas.setBackground( new Color(0, 0, 0) );
	}
}