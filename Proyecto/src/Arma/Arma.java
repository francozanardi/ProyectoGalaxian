package Arma;

import Disparo.Disparo;
import Entidad.Entidad;
import Entidad.Personaje;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class Arma extends Entidad
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Randomizador rand;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract Disparo lanzarDisparo(Personaje p);
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////