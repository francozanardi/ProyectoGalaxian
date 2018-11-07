package Disparo;

import java.awt.Color;

import Arma.Arma;
import Utils.Posicion;
import Utils.Size;
import Utils.Vector;
import visitor.ColDisparo;



public class DisparoPerdigon extends Disparo
{	
	private final double DMG_BASE = 30.0;


	
	public DisparoPerdigon( ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion )
	{
		inicializar( new Size(4, 4), col, arma, posInicial, vectorDireccion, DMG_BASE );
		
		actualizarPanel( true, Color.pink );
	}
}