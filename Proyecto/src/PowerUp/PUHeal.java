package PowerUp;

import java.awt.Color;

import Escudo.EscudoHealer;
import Jugador.Jugador;
import Mapa.Mapa;
import Sprite.Sprite;
import Sprite.SpriteEditor;
import Utils.Posicion;
import visitor.ColPowerUp;



public class PUHeal extends PowerUp
{
	public PUHeal( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		setSprite( new Sprite( "/GameSprites/powerUpHeal.PNG" ) );
		SpriteEditor editor = SpriteEditor.create();
		editor.colorToAlpha(sprite, Color.white, 50, 255);
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
	}
	
	
	
	public void afectar(Jugador player)
	{
		map.mostrarAnuncio( "Has agarrado una poción \"Heal\"" );
		player.addEscudo( new EscudoHealer(player, 20.0, 200.0) );
	}
}