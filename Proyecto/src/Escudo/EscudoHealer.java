package Escudo;

import java.awt.Color;

import javax.swing.JPanel;

import Entidad.EntidadConVida;
import Utils.Posicion;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class EscudoHealer extends Escudo
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double HEAL_POR_SEG = 2;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public EscudoHealer( EntidadConVida holder )
	{
		this.pos	= new Posicion(2, 2);
		this.tamano	= new Size(10, 10);
		this.panel	= new JPanel();
		
		this.holder = holder;

		this.actualizarPanel(true, Color.green);
		holder.getPanel().add( panel );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar(double msDesdeUltActualizacion)
	{
		double curacion = conversionEnTiempo( HEAL_POR_SEG, msDesdeUltActualizacion );
		holder.setVida( holder.getVida() + curacion );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////