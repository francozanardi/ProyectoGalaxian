package Escudo;

import Entidad.EntidadConVida;
import Sprite.Sprite;
import Utils.Posicion;



public class EscudoAbsoluto extends Escudo
{	
	private int disparosMitigados;


	
	public EscudoAbsoluto( EntidadConVida holder, int duracionEnDisparos )
	{
		setSprite( new Sprite( "/GameSprites/Escudo.PNG" ) );
		
		this.pos				= new Posicion(2, 2);
		this.disparosMitigados	= duracionEnDisparos;
		this.holder				= holder;
	}


	
	public double modificarDmg( double dmg )
	{
		disparosMitigados --;
		
		if (disparosMitigados == 0)
			remove( );
		
		return 0.0;
	}
}