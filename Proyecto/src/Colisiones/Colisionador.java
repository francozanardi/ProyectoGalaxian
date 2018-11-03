package Colisiones;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Jugador.Jugador;
import Obstaculo.Barricada;
import Obstaculo.Destructible;
import PowerUp.PowerUp;



public abstract class Colisionador
{	
	public void afectar(Jugador jugador)
	{
	}


	
	public void afectar(Enemigo enemigo)
	{
	}

	public void afectar(Kamikaze kamikaze)
	{
	}


	
	public void afectar(Disparo disparo)
	{
	}


	
	public void afectar(PowerUp powerup)
	{
	}


	
	public void afectar(Destructible obstaculo)
	{
	}
	
	public void afectar(Barricada barricada)
	{
	}
}