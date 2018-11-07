package Disparo;

import Arma.Arma;
import Colisiones.ColDisparo;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;



public class DisparoPerdigon extends Disparo
{	
	private final double DMG_BASE = 30.0;


	
	public DisparoPerdigon( ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion )
	{
		inicializar( new Sprite( "/GameSprites/Disparo4.PNG" ), col, arma, posInicial, vectorDireccion, DMG_BASE );
	}
}