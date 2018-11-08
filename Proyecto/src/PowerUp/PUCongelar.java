package PowerUp;

import java.awt.Color;

import Entidad.Entidad;
import Jugador.Jugador;
import Mapa.Mapa;
import Sprite.Sprite;
import Sprite.SpriteEditor;
import Utils.Posicion;
import visitor.ColPowerUp;
import visitor.congelador.Congelador;


public class PUCongelar extends PowerUp
{
	protected PUCongelarLogica logica;
	protected Congelador congelador;
	
	public PUCongelar( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		
		setSprite( new Sprite( "/GameSprites/PUCongelar.PNG" ) );
		SpriteEditor editor = SpriteEditor.create();
		editor.colorToAlpha(sprite, Color.white, 5, 255);
		
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
		this.logica			= PUCongelarLogica.create();
		this.congelador		= new Congelador(logica);	
	}

	public void afectar(Jugador player)
	{
		for(Entidad ent: map.getEntidades()) {
			ent.accept(congelador);
		}
		    
	    map.mostrarAnuncio("Enemigos congelados!");
	}

}