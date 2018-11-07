package Disparo;

import Arma.Arma;
import Colisiones.ColDisparo;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;



public class DisparoComun extends Disparo
{	
	private final double DMG_BASE = 30.0;


	
	public DisparoComun(ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion)
	{
		inicializar( new Sprite( "/GameSprites/Disparo1.PNG" ), col, arma, posInicial, vectorDireccion, DMG_BASE );
	}
}