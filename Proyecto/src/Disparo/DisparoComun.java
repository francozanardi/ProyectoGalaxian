package Disparo;

import java.awt.Color;

import Arma.Arma;
import Colisiones.ColDisparo;
import Utils.Posicion;
import Utils.Size;
import Utils.Vector;



public class DisparoComun extends Disparo
{	
	private final double DMG_BASE = 30.0;


	
	public DisparoComun(ColDisparo col, Arma arma, Posicion posInicial, Vector vectorDireccion)
	{
		inicializar( new Size(5, 5), col, arma, posInicial, vectorDireccion, DMG_BASE );
		
		actualizarPanel( true, Color.cyan );
	}
}