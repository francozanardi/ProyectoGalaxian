package PowerUp;

import java.util.Timer;
import java.util.TimerTask;
import Jugador.Jugador;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import visitor.ColPowerUp;



public class PUMultiplicador extends PowerUp
{
	protected final double	MULTIPLICADOR_DMG			= 1.5,
							MULTIPLICADOR_CADENCIA		= 1.5;
	protected final int		DURACION_MULTIPLICADOR_SEG	= 10;
	
	
	
	protected Jugador receptor;
	
	
	
	public PUMultiplicador( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		setSprite( new Sprite( "/GameSprites/puDmg.PNG" ) );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
	}
	
	
	
	public void afectar(Jugador player)
	{
		receptor = player;
		
		player.getArma().setMultDmg( player.getArma().getMultDmg() * MULTIPLICADOR_DMG );
		player.getArma().setMultCadencia( player.getArma().getMultCadencia() / MULTIPLICADOR_CADENCIA );
		
		Timer timer = new Timer(); 
	    timer.schedule(new TimerRemoverMultiplicador(), DURACION_MULTIPLICADOR_SEG * 1000L);
	    
	    
	    map.mostrarAnuncio( String.format("BONUS %.1f%% DE DAMAGE!", MULTIPLICADOR_DMG * 100.0) );
	}

	private void quitarArma( )
	{
		receptor.getArma().setMultDmg( receptor.getArma().getMultDmg() / MULTIPLICADOR_DMG );
		receptor.getArma().setMultCadencia( receptor.getArma().getMultCadencia() * MULTIPLICADOR_CADENCIA );
		
		
		map.mostrarAnuncio("Se terminó el bonus de daño." );
	}
	
	private class TimerRemoverMultiplicador extends TimerTask
	{
		public void run()
		{
			quitarArma();
		}
	}
}