package Disparo;

import java.awt.Color;

import Arma.Arma;
import Colisiones.ColDisparo;
import Utils.Posicion;
import Utils.Size;
import Utils.Vector;



public class DisparoMinigun extends Disparo
{	
	private final double DMG_BASE = 15.0;


	
	public DisparoMinigun(ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion)
	{
		inicializar( new Size(4, 4), col, arma, posInicial, vectorDireccion, DMG_BASE );
		
		actualizarPanel( true, Color.white );
	}
}