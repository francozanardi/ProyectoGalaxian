package PowerUp;

import java.awt.Color;

import javax.swing.JPanel;

import Escudo.EscudoExplosion;
import Jugador.Jugador;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Size;
import visitor.ColPowerUp;



public class PUEscudoExplosion extends PowerUp
{	
	public PUEscudoExplosion( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		this.panel			= new JPanel( );
		this.tamano			= new Size( 30, 30 );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
		
		this.actualizarPanel(true, Color.orange );
	}
	
	
	
	public void afectar(Jugador player)
	{
		map.mostrarAnuncio( "Has agarrado un \"Escudo Explosión\" !" );
		
		player.addEscudo( new EscudoExplosion(player, 1) );
	}
}