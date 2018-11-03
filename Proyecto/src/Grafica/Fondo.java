package Grafica;

import java.awt.Color;
import javax.swing.JPanel;



public class Fondo
{	
	protected JPanel canvas;
	
	
	
	public Fondo( JPanel panelGrafico )
	{
		this.canvas = panelGrafico;
		
		canvas.setBackground( new Color(0, 0, 0) );
	}
	
	
	
	public void actualizar( double msDesdeUltActualizacion )
	{
	}
}