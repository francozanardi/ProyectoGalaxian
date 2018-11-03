package Escudo;

import java.awt.Color;

import javax.swing.JPanel;

import Entidad.EntidadConVida;
import Utils.Posicion;
import Utils.Size;



public class EscudoBasico extends Escudo
{	
	private double reduccion;


	
	public EscudoBasico( EntidadConVida holder, double reduccion )
	{
		this.pos		= new Posicion(2, 2);
		this.tamano		= new Size(10, 20);
		this.panel		= new JPanel();
		this.reduccion	= reduccion;
		
		this.holder	 = holder;

		this.actualizarPanel(true, Color.pink);
	}


	
	public double modificarDmg(double dmg)
	{
		return dmg / reduccion;
	}
}