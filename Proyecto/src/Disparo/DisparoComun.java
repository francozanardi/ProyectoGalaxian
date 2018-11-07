package Disparo;

import Arma.Arma;

import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;
import visitor.ColDisparo;



public class DisparoComun extends Disparo
{	
	private final double DMG_BASE = 30.0;


	
	public DisparoComun(ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion)
	{
		inicializar( new Sprite( "/GameSprites/Disparo1.PNG" ), col, arma, posInicial, vectorDireccion, DMG_BASE );
	}
}