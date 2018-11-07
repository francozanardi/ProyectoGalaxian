package PowerUp;

import Colisiones.ColPowerUp;
import Escudo.EscudoHealer;
import Jugador.Jugador;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;



public class PUHeal extends PowerUp
{
	public PUHeal( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		cargarSprite( new Sprite( "/GameSprites/puHeal.PNG" ) );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
	}
	
	
	
	public void afectar(Jugador player)
	{
		map.mostrarAnuncio( "Has agarrado una poci�n \"Heal\"" );
		player.addEscudo( new EscudoHealer(player, 20.0, 200.0) );
	}
}