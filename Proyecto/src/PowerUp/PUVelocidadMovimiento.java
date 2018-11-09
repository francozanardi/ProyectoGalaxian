package PowerUp;

import java.util.Timer;
import java.util.TimerTask;

import Jugador.Jugador;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import visitor.ColPowerUp;

public class PUVelocidadMovimiento extends PowerUp {
	protected final int TIEMPO_VELOCIDAD = 20;
	protected final int INCREMENTO_DE_VELOCIDAD = 20;
	
	public PUVelocidadMovimiento( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		setSprite( new Sprite( "/GameSprites/powerUpShield.PNG" ) );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
	}
	
	public void afectar(Jugador player) {
		map.mostrarAnuncio("Has obtenido un bonus de velocidad movimiento!");
		player.setVelocidadMovimiento(player.getVelocidadMovimiento()+INCREMENTO_DE_VELOCIDAD);
		Timer timer = new Timer();
		timer.schedule(new TimerVelocidad(player), TIEMPO_VELOCIDAD*1000);
	}
	
	public void quitarVelocidad(Jugador player) {
		map.mostrarAnuncio("Se ha acabado el bonus de velocidad!");
		player.setVelocidadMovimiento(player.getVelocidadMovimiento()-INCREMENTO_DE_VELOCIDAD);
	}
	
	
	private class TimerVelocidad extends TimerTask {
		private Jugador jugador;
		
		public TimerVelocidad(Jugador j) {
			this.jugador = j;
		}
		@Override
		public void run() {
			quitarVelocidad(jugador);
		}
		
	}
}
