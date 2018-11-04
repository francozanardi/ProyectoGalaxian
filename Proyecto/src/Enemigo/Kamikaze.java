package Enemigo;

import Colisiones.Colisionador;



public abstract class Kamikaze extends Enemigo
{
	protected double explosionDmg;
	
	
	
	public void explotar()
	{
		vida = 0;
		remove();
	}
	
	public double getExplosionDmg()
	{
		return explosionDmg;
	}
	
	public void setExplosionDmg(double dmg)
	{
		this.explosionDmg = dmg;
	}
	
	
	
	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}
}
