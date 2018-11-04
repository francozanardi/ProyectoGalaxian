package PowerUp;

import java.awt.Color;

import javax.swing.JPanel;

import Colisiones.ColPowerUp;
import Escudo.EscudoHealer;
import Jugador.Jugador;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Size;



public class PUHeal extends PowerUp
{
	public PUHeal( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		this.panel			= new JPanel( );
		this.tamano			= new Size( 30, 30 );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
		
		this.actualizarPanel(true, Color.green);
	}
	
	
	
	public void afectar(Jugador player)
	{
		map.mostrarAnuncio( "Has agarrado una poción \"Heal\"" );
		player.addEscudo( new EscudoHealer(player, 20.0, 200.0) );
	}
}