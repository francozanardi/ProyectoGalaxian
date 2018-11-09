package PowerUp;

import Arma.ArmaTriple;
import Jugador.Jugador;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import visitor.ColDispJugador;
import visitor.ColPowerUp;


public class PUArmaTriple extends PowerUp
{	
	public PUArmaTriple( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		setSprite( new Sprite( "/GameSprites/puArma.PNG" ) );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
	}
		
	public void afectar(Jugador player)
	{
		map.mostrarAnuncio( "Has agarrado el \"arma triple\"!" );
		player.changeArma( new ArmaTriple(player, new ColDispJugador(), 0.5 * Math.PI) );
		player.getArma().setMultCadencia(0.2);
	}
}