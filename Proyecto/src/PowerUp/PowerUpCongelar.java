package PowerUp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import Arma.ArmaMinigun;
import Colisiones.ColDispJugador;
import Colisiones.ColisionadorPowerup;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Inteligencia.IANull;
import Inteligencia.Inteligencia;
import Jugador.Jugador;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class PowerUpCongelar extends PowerUp
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected final int	DURACION_CONGELADO_EN_SEG = 10;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Hashtable<Entidad, Inteligencia> inteligencias;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public PowerUpCongelar( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		this.panel			= new JPanel( );
		this.tamano			= new Size( 25, 25 );
		this.vida			= 1000;
		this.colisionador	= new ColisionadorPowerup( this );
		this.inteligencias	= new Hashtable<Entidad, Inteligencia>( );
		
		this.actualizarPanel(true, Color.blue);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void afectar(Jugador player)
	{
		for (Entidad e: map.enemigosEnJuego())
		{
			inteligencias.put(e, e.getIA() );
			e.setIA( new IANull() );
		}
		
		Timer timer = new Timer(); 
	    timer.schedule(new TimerDescongelar(), DURACION_CONGELADO_EN_SEG * 1000L);
	    
	    
		System.out.println("POWERUP: Enemigos congelados!");
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void descongelar( )
	{
		for (Entidad e: map.enemigosEnJuego())
		{
			if (inteligencias.containsKey(e))
			{
				e.setIA( inteligencias.get(e) );
			}
		}
		
		inteligencias.clear();
		
		
		System.out.println("POWERUP: enemigos DESCONGELADOS!" );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private class TimerDescongelar extends TimerTask
	{
		public void run()
		{
			descongelar();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////