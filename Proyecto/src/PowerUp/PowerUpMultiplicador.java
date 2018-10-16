package PowerUp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import Arma.ArmaMinigun;
import Colisiones.ColDispJugador;
import Colisiones.ColisionadorPowerup;
import Jugador.Jugador;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class PowerUpMultiplicador extends PowerUp
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected final double	MULTIPLICADOR_DMG			= 2.0;
	protected final int		DURACION_MULTIPLICADOR_SEG	= 10;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Jugador receptor;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public PowerUpMultiplicador( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		this.panel			= new JPanel( );
		this.tamano			= new Size( 25, 25 );
		this.vida			= 1000;
		this.colisionador	= new ColisionadorPowerup( this );
		
		this.actualizarPanel(true, Color.pink);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(Jugador player)
	{
		receptor = player;
		
		player.getArma().setMultiplicadorDmg( player.getArma().getMultiplicadorDmg() * MULTIPLICADOR_DMG );
		
		Timer timer = new Timer(); 
	    timer.schedule(new TimerRemoverMultiplicador(), DURACION_MULTIPLICADOR_SEG * 1000L);
	    
	    
		System.out.printf("POWERUP: Bonus x%.1f de dmg!\n", MULTIPLICADOR_DMG );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void quitarArma( )
	{
		receptor.getArma().setMultiplicadorDmg( receptor.getArma().getMultiplicadorDmg() / MULTIPLICADOR_DMG );
		
		
		System.out.println("POWERUP: bonus MultiplicadorDmg off!" );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private class TimerRemoverMultiplicador extends TimerTask
	{
		public void run()
		{
			quitarArma();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////