package Disparo;

import java.awt.Color;

import Arma.Arma;
import Utils.Posicion;
import Utils.Size;
import Utils.Vector;
import visitor.ColDisparo;



public class DisparoDefaultEnemigo extends Disparo
{
	private final double DMG_BASE = 10.0;


	
	public DisparoDefaultEnemigo(ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion)
	{
		inicializar( new Size(5, 5), col, arma, posInicial, vectorDireccion, DMG_BASE );
		
		actualizarPanel( true, Color.green );
	}
}