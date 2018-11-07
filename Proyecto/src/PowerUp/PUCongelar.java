package PowerUp;

import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

import Colisiones.ColPowerUp;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Inteligencia.IAEnemigo;
import Inteligencia.IANull;
import Jugador.Jugador;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;



public class PUCongelar extends PowerUp
{
	protected final int	DURACION_CONGELADO_EN_SEG = 10;
	
	
	
	protected Hashtable<Entidad, IAEnemigo> inteligencias;
	
	
	
	public PUCongelar( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		cargarSprite( new Sprite( "/GameSprites/PUCongelar.PNG" ) );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
		this.inteligencias	= new Hashtable<Entidad, IAEnemigo>( );
	}


	
	public void afectar(Jugador player)
	{
		for (Enemigo e: map.enemigosEnJuego())
		{
			inteligencias.put(e, e.getIA() );
			e.setIA( new IANull() );
		}
		
		Timer timer = new Timer(); 
	    timer.schedule(new TimerDescongelar(), DURACION_CONGELADO_EN_SEG * 1000L);
	    
	    
	    map.mostrarAnuncio( "Enemigos congelados!");
	}

	private void descongelar( )
	{
		for (Enemigo e: map.enemigosEnJuego())
		{
			if (inteligencias.containsKey(e))
			{
				e.setIA( inteligencias.get(e) );
			}
		}
		
		inteligencias.clear();
		

	    map.mostrarAnuncio( "Enemigos descongelados!");
	}

	private class TimerDescongelar extends TimerTask
	{
		public void run()
		{
			descongelar();
		}
	}
}