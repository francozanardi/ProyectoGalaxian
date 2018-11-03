package Disparo;

import java.awt.Color;

import Arma.Arma;
import Colisiones.ColDisparo;
import Utils.Posicion;
import Utils.Size;
import Utils.Vector;



public class DisparoSniper extends Disparo
{	
	private final double DMG_BASE = 50.0;


	
	public DisparoSniper( ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion )
	{
		inicializar( new Size(8, 8), col, arma, posInicial, vectorDireccion, DMG_BASE );
		
		actualizarPanel( true, Color.red );
	}
}