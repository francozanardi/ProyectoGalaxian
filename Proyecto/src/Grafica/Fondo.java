package Grafica;

import java.util.Random;
import java.awt.Color;
import javax.swing.JPanel;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Fondo
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected JPanel panel;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Fondo( JPanel panelDelJuego )
	{
		this.panel = panelDelJuego;
		
		panel.setBackground( new Color(0, 0, 0) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( double msDesdeUltActualizacion )
	{
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////