package PowerUp;

import java.awt.Color;

import Arma.ArmaMinigun;
import Jugador.Jugador;
import Mapa.Mapa;
import Sprite.Sprite;
import Sprite.SpriteEditor;
import Utils.Posicion;
import visitor.ColDispJugador;
import visitor.ColPowerUp;



public class PUMinigun extends PowerUp
{	
	public PUMinigun( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		setSprite( new Sprite( "/GameSprites/powerUpArma.PNG" ) );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
	}
	
	
	
	public void afectar(Jugador player)
	{
		map.mostrarAnuncio( "Has agarrado el arma \"Minigun\"!" );
		player.changeArma( new ArmaMinigun( player, new ColDispJugador(), 0.5 * Math.PI) );
	}
}