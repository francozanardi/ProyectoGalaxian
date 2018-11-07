package Escudo;

import Entidad.EntidadConVida;
import Sprite.Sprite;
import Utils.Posicion;



public class EscudoBasico extends Escudo
{	
	private double reduccion;


	
	public EscudoBasico( EntidadConVida holder, double reduccion )
	{
		setSprite( new Sprite( "/GameSprites/Escudo.PNG" ) );
		
		this.pos		= new Posicion(2, 2);
		this.reduccion	= reduccion;
		this.holder		= holder;
	}


	
	public double modificarDmg(double dmg)
	{
		return dmg / reduccion;
	}
}