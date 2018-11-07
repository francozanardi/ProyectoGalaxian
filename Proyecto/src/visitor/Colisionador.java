package visitor;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Jugador.Jugador;
import Obstaculo.Barricada;
import Obstaculo.Destructible;
import PowerUp.PowerUp;



public abstract class Colisionador extends Visitor
{	
	public void visit(Jugador jugador)
	{
	}
	
	public void visit(Enemigo enemigo)
	{
	}

	public void visit(Kamikaze kamikaze)
	{
	}
	
	public void visit(Disparo disparo)
	{
	}
	
	public void visit(PowerUp powerup)
	{
	}

	public void visit(Destructible obstaculo)
	{
	}
	
	public void visit(Barricada barricada)
	{
	}
}