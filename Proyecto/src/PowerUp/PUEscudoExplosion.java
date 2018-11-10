package PowerUp;


import java.awt.Color;

import Escudo.EscudoExplosion;
import Jugador.Jugador;
import Mapa.Mapa;
import Sprite.Sprite;
import Sprite.SpriteEditor;
import Utils.Posicion;
import visitor.ColPowerUp;



public class PUEscudoExplosion extends PowerUp
{	
	public PUEscudoExplosion( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		setSprite( new Sprite( "/GameSprites/powerUpShield.PNG" ) );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
	}
	
	
	
	public void afectar(Jugador player)
	{
		map.mostrarAnuncio( "Has agarrado un \"Escudo Explosión\" !" );
		
		player.addEscudo( new EscudoExplosion(player, 1) );
	}
}