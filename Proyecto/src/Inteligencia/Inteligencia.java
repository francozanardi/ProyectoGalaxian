package Inteligencia;

import Curva.Curva;
import Entidad.Entidad;
import Utils.Randomizador;



public abstract class Inteligencia
{	
	protected Entidad		entidad;
	protected Curva			curvaMovimiento;
	

	
	public abstract void mover( double msDesdeUltAct );
			
	

	protected double calcularVelocidad( double unidadesPorSegundo, double tiempoTranscurrido )
	{
		return tiempoTranscurrido * (unidadesPorSegundo / 1000.0);
	}

}