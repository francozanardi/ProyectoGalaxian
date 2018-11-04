package PowerUp;

import java.awt.Color;

import javax.swing.JPanel;

import Arma.ArmaMinigun;
import Colisiones.ColDispJugador;
import Colisiones.ColPowerUp;
import Jugador.Jugador;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Size;



public class PUMinigun extends PowerUp
{	
	public PUMinigun( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		this.panel			= new JPanel( );
		this.tamano			= new Size( 30, 30 );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
		
		this.actualizarPanel(true, Color.cyan);
	}
	
	
	
	public void afectar(Jugador player)
	{
		map.mostrarAnuncio( "Has agarrado la poderosa arma \"Minigun\" !" );
		player.changeArma( new ArmaMinigun( player, new ColDispJugador(), 0.5 * Math.PI) );
	}
}