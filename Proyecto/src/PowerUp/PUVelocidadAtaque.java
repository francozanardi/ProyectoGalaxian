package PowerUp;

import java.util.Timer;
import java.util.TimerTask;

import Jugador.Jugador;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import visitor.ColPowerUp;

public class PUVelocidadAtaque extends PowerUp {
	
	private final int PORCENTAJE_AUMENTO_VELOCIDAD = 55;
	private final int TIEMPO_SEG = 20;
	
	public PUVelocidadAtaque( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		setSprite( new Sprite( "/GameSprites/powerUpDmg.PNG" ) );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
	}

	@Override
	public void afectar(Jugador player) {
		player.getArma().setMultCadencia(player.getArma().getMultCadencia()*(1-(PORCENTAJE_AUMENTO_VELOCIDAD/100.0)));
		
		Timer timer = new Timer();
		timer.schedule(new TimerVelocidad(player), TIEMPO_SEG*1000);
		
		map.mostrarAnuncio("Has obtenido un bonus de velocidad de ataque!");
	}
	
	public void quitarVelocidad(Jugador p) {
		p.getArma().setMultCadencia(p.getArma().getMultCadencia()/(1-(PORCENTAJE_AUMENTO_VELOCIDAD/100.0)));
		map.mostrarAnuncio("Se acabó el bonus de velocidad de ataque!");
	}
	

	private class TimerVelocidad extends TimerTask {
	
		private Jugador player;
		
		public TimerVelocidad(Jugador p) {
			this.player = p;
		}
		
		@Override
		public void run() {
			quitarVelocidad(player);
		}
		
	}

}


