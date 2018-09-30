package Escudo;

import java.awt.Color;

import javax.swing.JPanel;

import Entidad.EntidadConVida;
import Utils.Posicion;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class EscudoBasico extends Escudo
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public EscudoBasico( EntidadConVida holder )
	{
		this.pos	= new Posicion(2, 2);
		this.tamano	= new Size(10, 20);
		this.panel	= new JPanel();
		
		this.holder = holder;

		this.actualizarPanel(true, Color.pink);
		holder.getPanel().add( panel );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public double modificarDmg(double dmg)
	{
		return dmg / 2.0;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar(double msDesdeUltActualizacion)
	{		
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////