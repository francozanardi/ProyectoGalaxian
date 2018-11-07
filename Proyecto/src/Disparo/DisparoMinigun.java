package Disparo;

import Arma.Arma;
import Colisiones.ColDisparo;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;



public class DisparoMinigun extends Disparo
{	
	private final double DMG_BASE = 15.0;


	
	public DisparoMinigun(ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion)
	{
		inicializar( new Sprite( "/GameSprites/Disparo2.PNG" ), col, arma, posInicial, vectorDireccion, DMG_BASE );
	}
}