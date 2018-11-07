package visitor;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Jugador.Jugador;
import Obstaculo.Barricada;
import Obstaculo.Destructible;
import PowerUp.PowerUp;

public abstract class Visitor {
	
	public abstract void visit(Jugador jugador);
	
	public abstract void visit(Enemigo enemigo);

	public abstract void visit(Kamikaze kamikaze);
	
	public abstract void visit(Disparo disparo);	
	
	public abstract void visit(PowerUp powerup);

	public abstract void visit(Destructible obstaculo);
	
	public abstract void visit(Barricada barricada);
	
}
