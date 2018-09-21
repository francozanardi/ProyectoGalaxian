package Inteligencia;

import java.util.Random;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Mapa.Mapa;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class Inteligencia
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Randomizador	rand;
	protected Mapa			map;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract void mover( Enemigo me, double msDesdeUltActualizacion );
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract Disparo disparar( Enemigo me );
		
	///////////////////////////////////////////////////////////////////////////////////////////////

	protected double calcularVelocidad( double unidadesPorSegundo, double tiempoTranscurrido )
	{
		return tiempoTranscurrido * (unidadesPorSegundo / 1000.0);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////