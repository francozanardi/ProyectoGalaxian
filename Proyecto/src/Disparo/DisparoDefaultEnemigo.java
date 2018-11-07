package Disparo;

import Arma.Arma;
import Colisiones.ColDisparo;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;



public class DisparoDefaultEnemigo extends Disparo
{
	private final double DMG_BASE = 10.0;


	
	public DisparoDefaultEnemigo(ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion)
	{
		inicializar(new Sprite( "/GameSprites/Disparo1.PNG" ), col, arma, posInicial, vectorDireccion, DMG_BASE );
	}
}