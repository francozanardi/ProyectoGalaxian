package Enemigo;

import Logica.Juego;
import visitor.Visitor;



public abstract class Kamikaze extends Enemigo
{
	protected double explosionDmg;
	
	
	public void explotar()
	{
		vida = 0;
		remove();
	}
	
	public void disparar() {
		final double LIMIT = (Juego.GAME_HEIGHT * 0.8);
		
		// Solo puede disparar si está en el 70% superior de la pantalla
		if (pos.getY() <= LIMIT)
		{
			super.disparar();
		}
	}
	
	public double getExplosionDmg()
	{
		return explosionDmg;
	}
	
	public void setExplosionDmg(double dmg)
	{
		this.explosionDmg = dmg;
	}
	
	
	public void accept(Visitor col)
	{
		col.visit(this);
	}
}
