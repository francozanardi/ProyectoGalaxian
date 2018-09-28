package Colisiones;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Entidad.Personaje;
import Jugador.Jugador;

public class ColisionadorDisparoJugador extends Colisionador {
	private Disparo disparo;
	private Personaje lanzador;
	
	public ColisionadorDisparoJugador(Disparo d, Personaje j) {
		disparo = d;
		lanzador = j;
	}
	
	@Override
	public void afectar(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Enemigo enemigo) {
		enemigo.recibirDMG(10);
		
		if(enemigo.getVida() <= 0) {
			lanzador.setPuntaje(lanzador.getPuntaje() + enemigo.getPuntaje());
		}
	}
	
	public void afectar(Kamikaze kamikaze) {
		kamikaze.recibirDMG(10);
		
		if(kamikaze.getVida() <= 0) {
			lanzador.setPuntaje(lanzador.getPuntaje() + kamikaze.getPuntaje());
		}
	}

}
