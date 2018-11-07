package Escudo;

import Entidad.EntidadConVida;
import Sprite.Sprite;
import Utils.Posicion;



public class EscudoExplosion extends Escudo
{	
	private int contExplosiones;


	
	public EscudoExplosion( EntidadConVida holder, int cantExplosiones )
	{
		setSprite( new Sprite( "/GameSprites/Escudo.PNG" ) );
		
		this.pos				= new Posicion(2, 2);
		this.contExplosiones	= cantExplosiones;
		this.holder				= holder;

	}


	
	public double modificarDmgExplosion(double dmg)
	{
		if (dmg > 0.0)
		{
			contExplosiones --;
			dmg = 0.0;
			
			if (contExplosiones == 0)
			{
				holder.getMapa().mostrarAnuncio("Se destruyó el escudo anti-kamikaze");

				remove();
			}
		}
		
		return dmg;
	}
}