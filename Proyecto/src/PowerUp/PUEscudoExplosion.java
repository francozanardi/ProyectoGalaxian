package PowerUp;

import Colisiones.ColPowerUp;
import Escudo.EscudoExplosion;
import Jugador.Jugador;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;



public class PUEscudoExplosion extends PowerUp
{	
	public PUEscudoExplosion( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		setSprite( new Sprite( "/GameSprites/puShield.PNG" ) );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
	}
	
	
	
	public void afectar(Jugador player)
	{
		map.mostrarAnuncio( "Has agarrado un \"Escudo Explosión\" !" );
		
		player.addEscudo( new EscudoExplosion(player, 1) );
	}
}