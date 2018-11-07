package Disparo;

import Arma.Arma;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;
import visitor.ColDisparo;



public class DisparoSniper extends Disparo
{	
	private final double DMG_BASE = 50.0;


	
	public DisparoSniper( ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion )
	{
		inicializar( new Sprite( "/GameSprites/Disparo3.PNG" ), col, arma, posInicial, vectorDireccion, DMG_BASE );
	}
}