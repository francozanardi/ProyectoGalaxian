package Proyecto;

import java.awt.Color;

import javax.swing.JPanel;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class DisparoCuadrado extends Disparo
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public DisparoCuadrado(Personaje lanzador, Posicion posInicial)
	{
		panel	= new JPanel();
		pos		= posInicial;
		tamano	= new Size(5, 5);
		fuerza	= 1;
		
		actualizarPanel( true, Color.green );
		
		this.lanzador = lanzador;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////